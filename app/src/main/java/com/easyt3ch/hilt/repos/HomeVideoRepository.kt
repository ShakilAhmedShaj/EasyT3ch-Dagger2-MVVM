package com.easyt3ch.hilt.repos

import NetworkBoundResource
import androidx.lifecycle.LiveData
import com.easyt3ch.hilt.core.Constants.NetworkService.RATE_LIMITER_TYPE
import com.easyt3ch.hilt.domain.datasource.HomeVideoLocalDataSource
import com.easyt3ch.hilt.domain.datasource.HomeVideoRemoteDataSource
import com.easyt3ch.hilt.domain.model.Post
import com.easyt3ch.hilt.domain.model.VideoList
import com.easyt3ch.hilt.utils.domain.RateLimiter
import com.easyt3ch.hilt.utils.domain.Resource
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */
class HomeVideoRepository @Inject constructor(
    private val homeVideoRemoteDataSource: HomeVideoRemoteDataSource,
    private val homeVideoLocalDataSource: HomeVideoLocalDataSource
) {

    private val rateLimit = RateLimiter<String>(30, TimeUnit.SECONDS)

    fun loadSource(
        api_key: String,
        page: Int,
        count: Int,
        fetchRequired: Boolean
    ): LiveData<Resource<List<Post>>> {
        return object :
            NetworkBoundResource<List<Post>, VideoList>() {
            override fun saveCallResult(item: VideoList) {

                homeVideoLocalDataSource.insertSources(item.posts)
            }

            override fun shouldFetch(data: List<Post>?): Boolean {
                return (fetchRequired && data?.size == 0)
            }


            override fun loadFromDb(): LiveData<List<Post>> {
                return homeVideoLocalDataSource.getPosts()
            }

            override fun createCall(): Single<VideoList> {
                return homeVideoRemoteDataSource.getSources(
                    api_key,
                    page,
                    count
                )
            }

            override fun onFetchFailed() {
                rateLimit.reset(RATE_LIMITER_TYPE)
            }

        }.asLiveData
    }
}

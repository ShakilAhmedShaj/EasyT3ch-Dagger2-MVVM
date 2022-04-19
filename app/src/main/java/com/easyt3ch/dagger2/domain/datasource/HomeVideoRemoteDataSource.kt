package com.easyt3ch.dagger2.domain.datasource


import com.easyt3ch.dagger2.domain.VideoPostApi
import com.easyt3ch.dagger2.domain.model.VideoList

import io.reactivex.Single
import javax.inject.Inject

class HomeVideoRemoteDataSource @Inject constructor(private val api: VideoPostApi) {

    fun getSources(
        api_key: String,
        page: Int,
        count: Int
    ): Single<VideoList> {
        return api.getRecentPost(api_key, page, count)
    }
}

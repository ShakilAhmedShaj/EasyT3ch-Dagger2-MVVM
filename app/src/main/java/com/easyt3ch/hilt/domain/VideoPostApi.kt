package com.easyt3ch.hilt.domain

import com.easyt3ch.hilt.domain.model.VideoList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */
interface VideoPostApi {

    @GET("api/get_recent_posts")
    fun getRecentPost(
        @Query("api_key") api_key: String?,
        @Query("page") page: Int,
        @Query("count") count: Int
    ): Single<VideoList>
}
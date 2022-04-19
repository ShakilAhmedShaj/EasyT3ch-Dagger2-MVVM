package com.easyt3ch.dagger2.ui.home

import com.easyt3ch.dagger2.domain.model.Post
import com.easyt3ch.dagger2.domain.model.VideoList
import com.easyt3ch.dagger2.utils.domain.Status

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */
class HomeViewState(
    val status: Status,
    val error: String? = null,
    val data: List<Post>? = null
) {
    fun getVideoPosts() = data

    fun isLoading() = status == Status.LOADING

    fun getErrorMessage() = error

    fun shouldShowErrorMessage() = error != null
}
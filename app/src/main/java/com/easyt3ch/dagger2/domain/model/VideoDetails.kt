package com.easyt3ch.dagger2.domain.model

import com.google.gson.annotations.SerializedName

data class VideoDetails(
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("post")
    val post: Post,
    @SerializedName("related")
    val related: List<Any>,
    @SerializedName("status")
    val status: String
)
package com.easyt3ch.hilt.domain.model

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
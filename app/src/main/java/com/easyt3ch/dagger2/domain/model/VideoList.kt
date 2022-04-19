package com.easyt3ch.dagger2.domain.model

import com.google.gson.annotations.SerializedName

data class VideoList(
    @SerializedName("count")
    val count: Int,
    @SerializedName("count_total")
    val count_total: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("posts")
    val posts: List<Post>,
    @SerializedName("status")
    val status: String
)
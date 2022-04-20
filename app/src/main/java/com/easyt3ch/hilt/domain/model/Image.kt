package com.easyt3ch.hilt.domain.model

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("content_type")
    val content_type: String,
    @SerializedName("image_name")
    val image_name: String,
    @SerializedName("nid")
    val nid: Int,
    @SerializedName("video_id")
    val video_id: String,
    @SerializedName("video_url")
    val video_url: String
)
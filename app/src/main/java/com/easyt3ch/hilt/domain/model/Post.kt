package com.easyt3ch.hilt.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "post")
data class Post(
    @SerializedName("cat_id")
    val cat_id: Int,
    @SerializedName("category_name")
    val category_name: String,
    @SerializedName("comments_count")
    val comments_count: Int,
    @SerializedName("content_type")
    val content_type: String,
    @SerializedName("news_date")
    val video_date: String,
    @SerializedName("news_description")
    val video_description: String,
    @SerializedName("news_image")
    val video_image: String,
    @SerializedName("news_title")
    val video_title: String,
    @PrimaryKey(autoGenerate = false)
    @SerializedName("nid")
    val nid: Int,
    @SerializedName("video_id")
    val video_id: String,
    @SerializedName("video_url")
    val video_url: String
)
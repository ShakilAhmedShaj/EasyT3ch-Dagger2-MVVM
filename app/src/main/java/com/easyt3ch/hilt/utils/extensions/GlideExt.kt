package com.easyt3ch.hilt.utils.extensions

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.easyt3ch.hilt.utils.GlideRequest
import jp.wasabeef.glide.transformations.RoundedCornersTransformation


fun <T> GlideRequest<T>.customRequest(
    placeholder: Int,
    error: Int,
    diskCacheStrategy: DiskCacheStrategy = DiskCacheStrategy.ALL,
    priority: Priority = Priority.HIGH
): GlideRequest<T> {

    val options = RequestOptions()
        .placeholder(placeholder)
        .error(error)
        .diskCacheStrategy(diskCacheStrategy)
        .priority(priority)
    return apply(options)
}

fun <T> GlideRequest<T>.removePlaceholders(): GlideRequest<T> {
    val options = RequestOptions()
        .placeholder(android.R.color.transparent)
        .fallback(android.R.color.transparent)
        .error(android.R.color.transparent)
    return apply(options)
}

fun GlideRequest<Drawable>.rounded(radius: Int, margin: Int = 3): GlideRequest<Drawable> =
    this.apply(RequestOptions().transform(RoundedCornersTransformation(radius, margin)))

fun GlideRequest<Drawable>.rounded(): GlideRequest<Drawable> =
    this.apply(RequestOptions().circleCrop())

fun GlideRequest<Bitmap>.roundedBitmap(radius: Int, margin: Int = 3): GlideRequest<Bitmap> =
    this.apply(RequestOptions().transform(RoundedCornersTransformation(radius, margin)))

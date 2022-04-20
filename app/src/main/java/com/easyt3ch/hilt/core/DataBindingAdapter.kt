package com.easyt3ch.hilt.core

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.easyt3ch.hilt.R

import com.easyt3ch.hilt.utils.GlideApp
import com.easyt3ch.hilt.utils.extensions.*
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("app:visibility")
fun setVisibilty(view: View, isVisible: Boolean) {
    view.hide()
    if (isVisible) {
        view.show()
    } else {
        view.hide()
    }
}

@BindingAdapter("app:setDrawableLink")
fun setDrawableLink(view: ImageView, link: String?) {
    if (link.isNullOrEmpty())
        return
    GlideApp.with(view.context)
        .load(link)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .transition(GenericTransitionOptions.with(R.anim.fade_in))
        .customRequest(R.drawable.shape_rectangle_blue, R.drawable.shape_rectangle_red)
        .rounded((16f).dpToPx().toInt())
        .into(view)
}

@BindingAdapter("app:setDrawableLinkRec")
fun setDrawableLinkRec(view: ImageView, link: String?) {
    if (link.isNullOrEmpty())
        return
    GlideApp.with(view.context)
        .load(link)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .transition(GenericTransitionOptions.with(R.anim.fade_in))
        .customRequest(R.color.colorAccent, R.color.red)
        .rounded((16f).dpToPx().toInt())
        .into(view)
}

@BindingAdapter("app:setYtThumb")
fun setYtThumb(view: ImageView, link: String?) {
    if (link.isNullOrEmpty())
        return
    GlideApp.with(view.context)
        .load(Constants.NetworkService.YT_IMG_BASE + link + Constants.NetworkService.YT_IMG_LAST)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .transition(GenericTransitionOptions.with(R.anim.fade_in))
        .customRequest(R.color.colorAccent, R.color.red)
        .rounded((16f).dpToPx().toInt())
        .into(view)
}


@BindingAdapter("app:setDateText")
fun setDrawableLinkRec(view: TextView, date: String?) {
    if (date.isNullOrEmpty())
        return

    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US).parse(date)
    val caldate = Calendar.getInstance()
    caldate.time = dateFormat
    val now = Calendar.getInstance()
    now.time = Date()

    var res =
        "${
            caldate.get(Calendar.DAY_OF_MONTH).toString().padStart(
                2,
                '0'
            )
        }/${caldate.get(Calendar.MONTH).toString().padStart(2, '0')}/${caldate.get(Calendar.YEAR)}"

    if (now.get(Calendar.YEAR) == caldate.get(Calendar.YEAR) && now.get(Calendar.MONTH) == caldate.get(
            Calendar.MONTH
        ) && now.get(
            Calendar.DAY_OF_MONTH
        ) == caldate.get(Calendar.DAY_OF_MONTH)
    ) {
        res = "${
            caldate.get(Calendar.HOUR_OF_DAY).toString().padStart(
                2, '0'
            )
        }:${caldate.get(Calendar.MINUTE).toString().padStart(2, '0')}:${
            caldate.get(
                Calendar.SECOND
            ).toString().padStart(2, '0')
        }"
    }

    view.text = res
}
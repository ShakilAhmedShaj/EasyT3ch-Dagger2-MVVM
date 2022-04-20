package com.easyt3ch.hilt.utils.domain

import com.easyt3ch.hilt.utils.domain.Status.*
import timber.log.Timber

/**
 * A generic class that holds a value with its loading status.
**/

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            Timber.d("Loading..")
            return Resource(LOADING, data, null)
        }
    }
}

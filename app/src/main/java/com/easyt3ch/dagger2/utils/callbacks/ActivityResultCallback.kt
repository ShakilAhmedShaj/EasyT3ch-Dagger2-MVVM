package com.easyt3ch.dagger2.utils.callbacks

import android.content.Intent

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

interface ActivityResultCallback {
    fun onResult(requestCode: Int, resultCode: Int, data: Intent?)
}
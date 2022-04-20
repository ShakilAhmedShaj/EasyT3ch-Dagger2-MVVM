package com.easyt3ch.hilt

import androidx.multidex.MultiDexApplication
import com.easyt3ch.hilt.utils.AppDebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

@HiltAndroidApp
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        initToolsForDebugOnly()
    }

    private fun initToolsForDebugOnly() {
        if (BuildConfig.DEBUG) {
            Timber.plant(AppDebugTree())
        }
    }
}
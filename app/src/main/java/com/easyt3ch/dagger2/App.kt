package com.easyt3ch.dagger2

import androidx.multidex.MultiDexApplication
import com.easyt3ch.dagger2.di.AppInjector
import com.easyt3ch.dagger2.utils.AppDebugTree
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

class App : MultiDexApplication(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = androidInjector

    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)

        initToolsForDebugOnly()
    }

    private fun initToolsForDebugOnly() {
        if (BuildConfig.DEBUG) {
            Timber.plant(AppDebugTree())
        }
    }
}
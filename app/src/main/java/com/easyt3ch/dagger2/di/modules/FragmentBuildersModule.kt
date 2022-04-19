package com.easyt3ch.dagger2.di.modules

import com.easyt3ch.dagger2.ui.home.HomeFragment
import com.easyt3ch.dagger2.ui.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment
}

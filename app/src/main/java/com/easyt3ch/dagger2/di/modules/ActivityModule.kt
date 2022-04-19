package com.easyt3ch.dagger2.di.modules

import com.easyt3ch.dagger2.di.scope.PerActivity
import com.easyt3ch.dagger2.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

@Module
abstract class ActivityModule {

    /**
     * Injects [MainActivity]
     *
     * @return an instance of [MainActivity]
     */

    @PerActivity
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    internal abstract fun mainActivity(): MainActivity
}

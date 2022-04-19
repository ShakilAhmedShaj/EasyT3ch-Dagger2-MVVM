package com.easyt3ch.dagger2.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.easyt3ch.dagger2.di.ViewModelFactory
import com.easyt3ch.dagger2.di.key.ViewModelKey
import com.easyt3ch.dagger2.ui.home.HomeViewModel
import com.easyt3ch.dagger2.ui.main.MainActivityViewModel
import com.easyt3ch.dagger2.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun provideMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SplashViewModel::class)
    abstract fun provideSplashFragmentViewModel(splashFragmentViewModel: SplashViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(HomeViewModel::class)
    abstract fun provideArticleFragmentViewModel(articlesFragmentViewModel: HomeViewModel): ViewModel
}

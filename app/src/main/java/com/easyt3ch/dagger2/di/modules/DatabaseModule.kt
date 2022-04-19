package com.easyt3ch.dagger2.di.modules

import android.content.Context
import com.easyt3ch.dagger2.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun providesHomeVideoDao(db: AppDatabase) = db.homeVideoDao()

}

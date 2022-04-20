package com.easyt3ch.hilt.di.modules

import android.os.Environment
import com.easyt3ch.hilt.BuildConfig
import com.easyt3ch.hilt.core.Constants
import com.easyt3ch.hilt.domain.VideoPostApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

@Module
@InstallIn(SingletonComponent::class)
class NetModule {
    @Singleton
    @Provides
    @Named("cached")
    fun provideOkHttpClient(): OkHttpClient {
        val cache = Cache(Environment.getDownloadCacheDirectory(), 10 * 1024 * 1024)
        val client = OkHttpClient.Builder()
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptorBody = HttpLoggingInterceptor()
            httpLoggingInterceptorBody.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(
                httpLoggingInterceptorBody
            )

            val httpLoggingInterceptorHeader = HttpLoggingInterceptor()
            httpLoggingInterceptorHeader.level = HttpLoggingInterceptor.Level.HEADERS
            client.addNetworkInterceptor(
                httpLoggingInterceptorHeader
            )
        }

        return client.cache(cache).build()
    }

    @Singleton
    @Provides
    @Named("non_cached")
    fun provideNonCachedOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptorBody = HttpLoggingInterceptor()
            httpLoggingInterceptorBody.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(httpLoggingInterceptorBody)

            val httpLoggingInterceptorHeader = HttpLoggingInterceptor()
            httpLoggingInterceptorHeader.level = HttpLoggingInterceptor.Level.HEADERS
            client.addNetworkInterceptor(httpLoggingInterceptorHeader)
        }

        client.addInterceptor {
            val requestBuilder = it.request().newBuilder()
            requestBuilder.addHeader("X-Api-Key", Constants.NetworkService.CLIENT_SECRET)
            val response = it.proceed(requestBuilder.build())

            when (response.code) {
                400 -> {
                    Timber.d("400 - Bad Request")
                }
                401 -> {
                    Timber.d("401 - Unauthorized - refresh token")
                }
                403 -> {
                    Timber.d("403 - Forbidden")
                }
                404 -> {
                    Timber.d("404 - Not Found - URL")
                }
                405 -> {
                    Timber.d("405 - Method Not Allowed - DELETE - GET")
                }
                500 -> {
                    Timber.d("500 - Internal Server ErrorT")
                }
                else -> {
                    Timber.d("Server error - ${response.message}")
                }
            }

            response
        }

        return client.build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, @Named("non_cached") client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit.Builder): VideoPostApi {
        return retrofit.baseUrl(Constants.NetworkService.BASE_URL)
            .build()
            .create(VideoPostApi::class.java)
    }
}

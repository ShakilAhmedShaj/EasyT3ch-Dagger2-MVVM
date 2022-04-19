package com.easyt3ch.dagger2.di.key

import android.app.Activity
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

@MapKey
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class ActivityKey(val value: KClass<out Activity>)

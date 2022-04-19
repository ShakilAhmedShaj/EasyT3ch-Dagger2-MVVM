package com.easyt3ch.dagger2.utils

import timber.log.Timber.DebugTree

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

class AppDebugTree : DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return "SHAZ-LOG/" + "(${element.fileName}:${element.lineNumber}) => ${element.methodName}"
    }
}
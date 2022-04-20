package com.easyt3ch.hilt.core.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> :
    AppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutRes(): Int

    val binding by lazy {
        DataBindingUtil.setContentView(this, getLayoutRes()) as DB
    }

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setupBindingLifecycleOwner()
    }

    private fun setupBindingLifecycleOwner() {
        binding.lifecycleOwner = this
    }
}

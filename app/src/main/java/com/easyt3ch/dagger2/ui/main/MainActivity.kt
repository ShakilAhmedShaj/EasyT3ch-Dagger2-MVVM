package com.easyt3ch.dagger2.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.easyt3ch.dagger2.R
import com.easyt3ch.dagger2.core.base.BaseActivity
import com.easyt3ch.dagger2.databinding.ActivityMainBinding
import com.easyt3ch.dagger2.utils.callbacks.ActivityResultCallback
import com.easyt3ch.dagger2.utils.extensions.hide
import com.easyt3ch.dagger2.utils.extensions.show
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>
    (MainActivityViewModel::class.java), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    private lateinit var activityResultCallback: ActivityResultCallback

    override fun androidInjector() = androidInjector

    override fun initViewModel(viewModel: MainActivityViewModel) {
        binding.viewModel = viewModel
    }

    override fun getLayoutRes() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)

        Timber.i("in `MainActivity`")

        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.container_fragment)
        setupActionBarWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    binding.appBarLayout.hide()
                }
                R.id.homeFragment -> {
                    setupToolbarTitleAndAction(getString(R.string.home), false)
                }
            }
        }
    }

    private fun setupToolbarTitleAndAction(title: String, isDisplayHomeAsUp: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(isDisplayHomeAsUp)
        viewModel.toolbarTitle.set(title)
        binding.appBarLayout.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.container_fragment).navigateUp()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        activityResultCallback.onResult(requestCode, resultCode, data)
    }
}

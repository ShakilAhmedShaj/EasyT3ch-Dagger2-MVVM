package com.easyt3ch.hilt.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.easyt3ch.hilt.R
import com.easyt3ch.hilt.core.base.BaseActivity
import com.easyt3ch.hilt.databinding.ActivityMainBinding
import com.easyt3ch.hilt.utils.extensions.hide
import com.easyt3ch.hilt.utils.extensions.show
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>() {


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

    override val viewModel: MainActivityViewModel by viewModels()
}

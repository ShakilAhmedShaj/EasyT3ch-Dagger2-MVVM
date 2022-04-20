package com.easyt3ch.hilt.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.easyt3ch.hilt.R
import com.easyt3ch.hilt.core.base.BaseFragment
import com.easyt3ch.hilt.databinding.SplashFragmentBinding
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.util.concurrent.TimeUnit

class SplashFragment : BaseFragment<SplashFragmentBinding, SplashViewModel>() {

    var disposable: Disposable? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Timber.i("in `SplashFragment`")

        disposable = Completable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .subscribe({
                showNextActivity()
            }, {})
    }

    private fun showNextActivity() {
        findNavController().graph.setStartDestination(R.id.homeFragment)

        findNavController().navigate(
            SplashFragmentDirections.actionSplashFragmentToHomeFragment()
        )
    }

    override fun onDestroy() {
        disposable?.dispose()
        super.onDestroy()
    }

    override val viewModel: SplashViewModel by viewModels()

    override fun getViewBinding(): SplashFragmentBinding {
        return SplashFragmentBinding.inflate(layoutInflater)
    }

}
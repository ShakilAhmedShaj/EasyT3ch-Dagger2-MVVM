package com.easyt3ch.dagger2.ui.splash

import androidx.navigation.fragment.findNavController
import com.easyt3ch.dagger2.R
import com.easyt3ch.dagger2.core.base.BaseFragment
import com.easyt3ch.dagger2.databinding.SplashFragmentBinding
import com.easyt3ch.dagger2.di.Injectable
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.util.concurrent.TimeUnit

class SplashFragment : BaseFragment<SplashViewModel, SplashFragmentBinding>
    (SplashViewModel::class.java), Injectable {

    var disposable: Disposable? = null

    override fun getLayoutRes() = R.layout.splash_fragment

    override fun initViewModel() {
        mBinding.viewModel = viewModel
    }

    override fun init() {
        super.init()
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

}
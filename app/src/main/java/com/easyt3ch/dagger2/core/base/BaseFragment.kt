package com.easyt3ch.dagger2.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import dagger.android.AndroidInjection

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding>
    (private val mViewModelClass: Class<VM>) : Fragment() {

    lateinit var viewModel: VM
    open lateinit var mBinding: DB
    lateinit var dataBindingComponent: DataBindingComponent

    private fun init(inflater: LayoutInflater, container: ViewGroup) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
    }

    open fun init() {}

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun initViewModel()

    private fun getViewM(): VM =
        ViewModelProvider(
            this,
            (activity as? BaseActivity<*, *>)?.viewModelProviderFactory!!
        ).get(mViewModelClass)

    open fun onInject() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(activity)
        super.onCreate(savedInstanceState)
        viewModel = getViewM()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init(inflater, container!!)
        initViewModel()
        init()
        super.onCreateView(inflater, container, savedInstanceState)

        return mBinding.root
    }

    open fun refresh() {}

    open fun navigate(action: Int) {
        view?.let { _view ->
            Navigation.findNavController(_view).navigate(action)
        }
    }
}

package com.easyt3ch.dagger2.ui.home

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.easyt3ch.dagger2.R
import com.easyt3ch.dagger2.core.Constants
import com.easyt3ch.dagger2.core.base.BaseFragment
import com.easyt3ch.dagger2.databinding.HomeFragmentBinding
import com.easyt3ch.dagger2.di.Injectable
import com.easyt3ch.dagger2.domain.model.Post
import com.easyt3ch.dagger2.domain.usecase.HomeVideoUseCase
import com.easyt3ch.dagger2.ui.home.result.PostResultAdapter
import com.easyt3ch.dagger2.utils.extensions.observeWith
import com.easyt3ch.dagger2.utils.isNetworkAvailable
import timber.log.Timber


class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>
    (HomeViewModel::class.java), Injectable {

    override fun getLayoutRes() = R.layout.home_fragment

    override fun initViewModel() {
        mBinding.viewModel = viewModel
    }

    override fun init() {
        super.init()

        Timber.i("in `HomeFragment`")

        initAdapter()

        setViewModelObserver()

    }

    private fun setViewModelObserver() {
        viewModel.setHomeVideoParams(getParams())

        viewModel.getHomeVideoViewState().observeWith(viewLifecycleOwner) {
            mBinding.viewState = it
            Timber.d("Datas: %s", it.data)
            it.data?.let { results -> initPostResultAdapter(results) }
        }
    }

    private fun initAdapter() {
        val adapter = PostResultAdapter {
            Timber.d("Clicked : %s", it.video_title)
            openYoutubeLink(it.video_id)
        }

        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        mBinding.recyclerView.adapter = adapter
        mBinding.recyclerView.layoutManager = layoutManager

        viewModel.setHomeVideoParams(getParams())

    }

    private fun initPostResultAdapter(list: List<Post>) {
        (mBinding.recyclerView.adapter as PostResultAdapter).submitList(list)
    }

    private fun getParams(): HomeVideoUseCase.HomeVideoParams {
        return HomeVideoUseCase.HomeVideoParams(
            api_key = Constants.NetworkService.API_KEY,
            page = 1,
            count = 5,
            fetchRequired = requireContext().isNetworkAvailable()
        )
    }

    private fun openYoutubeLink(youtubeID: String) {


        val intentApp = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$youtubeID"))
        val intentBrowser =
            Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$youtubeID"))
        try {
            this.startActivity(intentApp)
        } catch (ex: ActivityNotFoundException) {
            this.startActivity(intentBrowser)
        }


    }
}
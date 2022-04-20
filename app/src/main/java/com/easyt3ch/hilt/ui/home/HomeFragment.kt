package com.easyt3ch.hilt.ui.home

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.easyt3ch.hilt.core.Constants
import com.easyt3ch.hilt.core.base.BaseFragment
import com.easyt3ch.hilt.databinding.HomeFragmentBinding
import com.easyt3ch.hilt.domain.model.Post
import com.easyt3ch.hilt.domain.usecase.HomeVideoUseCase
import com.easyt3ch.hilt.ui.home.result.PostResultAdapter
import com.easyt3ch.hilt.utils.extensions.observeWith
import com.easyt3ch.hilt.utils.isNetworkAvailable
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.i("in `HomeFragment`")

        initAdapter()

        setViewModelObserver()
    }

    private fun setViewModelObserver() {
        viewModel.setHomeVideoParams(getParams())

        viewModel.getHomeVideoViewState().observeWith(viewLifecycleOwner) {
            binding.viewState = it
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

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager

        viewModel.setHomeVideoParams(getParams())

    }

    private fun initPostResultAdapter(list: List<Post>) {
        (binding.recyclerView.adapter as PostResultAdapter).submitList(list)
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

    override val viewModel: HomeViewModel by viewModels()


    override fun getViewBinding(): HomeFragmentBinding {
        return HomeFragmentBinding.inflate(layoutInflater)
    }
}
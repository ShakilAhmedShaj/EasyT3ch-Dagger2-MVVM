package com.easyt3ch.hilt.ui.home.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.easyt3ch.hilt.core.base.BaseAdapter
import com.easyt3ch.hilt.databinding.ItemPostBinding
import com.easyt3ch.hilt.domain.model.Post


class PostResultAdapter(
    private val callBack: (Post) -> Unit
) : BaseAdapter<Post>(diffCallback) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = ItemPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val viewModel = PostResultViewModel()
        mBinding.viewModel = viewModel

        mBinding.rootItemView.setOnClickListener {
            mBinding.viewModel?.item?.get()?.let {
                callBack.invoke(it)
            }
        }

        return mBinding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as ItemPostBinding).viewModel?.item?.set(getItem(position))
        binding.executePendingBindings()
    }
}

val diffCallback = object : DiffUtil.ItemCallback<Post>() {
    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean =
        oldItem == newItem

    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean =
        oldItem.nid == newItem.nid
}

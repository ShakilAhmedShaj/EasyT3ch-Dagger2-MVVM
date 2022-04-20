package com.easyt3ch.hilt.ui.home.result

import androidx.databinding.ObservableField
import com.easyt3ch.hilt.core.base.BaseViewModel
import com.easyt3ch.hilt.domain.model.Post
import javax.inject.Inject

class PostResultViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<Post>()
}
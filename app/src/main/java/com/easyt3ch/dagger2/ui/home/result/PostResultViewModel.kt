package com.easyt3ch.dagger2.ui.home.result

import androidx.databinding.ObservableField
import com.easyt3ch.dagger2.core.base.BaseViewModel
import com.easyt3ch.dagger2.domain.model.Post
import javax.inject.Inject

class PostResultViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<Post>()
}
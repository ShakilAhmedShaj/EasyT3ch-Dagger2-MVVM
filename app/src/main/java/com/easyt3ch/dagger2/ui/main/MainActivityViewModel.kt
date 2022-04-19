package com.easyt3ch.dagger2.ui.main

import androidx.databinding.ObservableField
import com.easyt3ch.dagger2.core.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

class MainActivityViewModel @Inject internal constructor() : BaseViewModel() {
    var toolbarTitle: ObservableField<String> = ObservableField()
}

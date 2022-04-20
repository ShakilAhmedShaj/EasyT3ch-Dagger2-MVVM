package com.easyt3ch.hilt.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.easyt3ch.hilt.core.base.BaseViewModel
import com.easyt3ch.hilt.domain.usecase.HomeVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

@HiltViewModel
class HomeViewModel @Inject internal constructor(
    private val homeVideoUseCase: HomeVideoUseCase
) : BaseViewModel() {

    private val _articleParams: MutableLiveData<HomeVideoUseCase.HomeVideoParams> =
        MutableLiveData()

    fun getHomeVideoViewState() = currentHomeVideoViewState

    private val currentHomeVideoViewState: LiveData<HomeViewState> =
        _articleParams.switchMap { params ->
            homeVideoUseCase.execute(params)
        }

    fun setHomeVideoParams(params: HomeVideoUseCase.HomeVideoParams) {
        if (_articleParams.value == params)
            return
        _articleParams.postValue(params)
    }


    fun getHomeVideoTotalResult(): Int? {
        return getHomeVideoViewState().value?.data?.size
    }
}
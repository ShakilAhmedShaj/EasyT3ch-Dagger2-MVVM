package com.easyt3ch.dagger2.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.easyt3ch.dagger2.domain.model.Post
import com.easyt3ch.dagger2.repos.HomeVideoRepository
import com.easyt3ch.dagger2.ui.home.HomeViewState
import com.easyt3ch.dagger2.utils.UseCaseLiveData
import com.easyt3ch.dagger2.utils.domain.Resource
import javax.inject.Inject

class HomeVideoUseCase @Inject internal constructor(
    private val repository: HomeVideoRepository
) : UseCaseLiveData<HomeViewState, HomeVideoUseCase.HomeVideoParams,
        HomeVideoRepository>() {

    override fun getRepository(): HomeVideoRepository {
        return repository
    }

    override fun buildUseCaseObservable(params: HomeVideoParams?): LiveData<HomeViewState> {
        return repository.loadSource(
            api_key = params?.api_key ?: "",
            page = params?.page ?: 1,
            count = params?.count ?: 7,
            fetchRequired = params?.fetchRequired ?: true
        ).map {
            onHomeVideoPostResultReady(it)
        }
    }

    private fun onHomeVideoPostResultReady(resource: Resource<List<Post>>): HomeViewState {
        return HomeViewState(
            status = resource.status,
            error = resource.message,
            data = resource.data
        )
    }

    class HomeVideoParams(
        val api_key: String,
        val page: Int,
        val count: Int,
        val fetchRequired: Boolean
    ) : Params()
}

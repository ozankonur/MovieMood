package com.rokon.moviemood.ui.discover

import androidx.lifecycle.*
import com.rokon.moviemood.ui.discover.discoverData.discoverModel.DiscoverMovieItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val discoverRepository: DiscoverRepository
) : ViewModel() {

    private val _dataState: MutableLiveData<List<DiscoverMovieItem>> = MutableLiveData()

    val dataState: LiveData<List<DiscoverMovieItem>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetDiscoveryEvent -> {
                    discoverRepository.getDiscoverMovies()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
            }
        }
    }
}

sealed class MainStateEvent {

    object GetDiscoveryEvent : MainStateEvent()

}

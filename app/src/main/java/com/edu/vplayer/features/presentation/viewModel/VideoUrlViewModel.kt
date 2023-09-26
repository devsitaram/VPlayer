package com.edu.vplayer.features.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.data.resource.local.SubjectEntity
import com.edu.vplayer.features.data.resource.local.VideoImageEntity
import com.edu.vplayer.features.data.resource.remote.api.model.VideosItem
import com.edu.vplayer.features.domain.usecase.VideoUrlUseCase
import com.edu.vplayer.features.presentation.state.VideoUrlState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class VideoUrlViewModel @Inject constructor(private val videoUrlUseCase: VideoUrlUseCase) :
    ViewModel() {
    private val _vUrl = mutableStateOf(VideoUrlState())
    val vUrl: State<VideoUrlState> get() = _vUrl

    fun getVideoUrlData(videoId: Int?) {

        videoUrlUseCase(videoId).onEach {

            when (it) {

                is Resource.Loading -> {
                    _vUrl.value = VideoUrlState(isLoading = true)
                }

                is Resource.Success -> {
                    _vUrl.value = VideoUrlState(isData = it.data)
                }

                is Resource.Error -> {
                    _vUrl.value = VideoUrlState(isError = it.message.toString())
                }
            }

        }.launchIn(viewModelScope)
    }

    fun insertVideoImageDetails(videosItem: List<VideoImageEntity>) {
        videoUrlUseCase(videosItem).launchIn(viewModelScope)

    }
    }
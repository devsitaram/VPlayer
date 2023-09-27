package com.edu.vplayer.features.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.domain.usecase.VideoInfoUseCase
import com.edu.vplayer.features.presentation.state.VideoDataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class VideoInfoViewModel @Inject constructor(private val videoInfoUseCase: VideoInfoUseCase) :
    ViewModel() {
    private val _videos = mutableStateOf(VideoDataState())
    val videos: State<VideoDataState> get() = _videos
    fun getVideoData() {

        videoInfoUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _videos.value = VideoDataState(isLoading = true)
                }
                is Resource.Success -> {
                    _videos.value = VideoDataState(isData = it.data)
                }

                is Resource.Error -> {
                    _videos.value = VideoDataState(isError = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}
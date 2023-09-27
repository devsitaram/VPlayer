package com.edu.vplayer.features.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.domain.usecase.VideoUseCase
import com.edu.vplayer.features.presentation.state.VideoState
import com.edu.vplayer.features.presentation.state.VideoUrlState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class VideoViewModel @Inject constructor(private val videoUseCase: VideoUseCase): ViewModel(){

    private val _video = mutableStateOf(VideoState())
    val video: State<VideoState> get() = _video

    fun getVideoData(){

        videoUseCase().onEach {
            when(it){

                is Resource.Loading ->{
                    _video.value = VideoState(isLoading = true)
                }

                is Resource.Success ->{
                    _video.value = VideoState(isData = it.data)
                }

                is Resource.Error ->{
                    _video.value = VideoState(isError = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}
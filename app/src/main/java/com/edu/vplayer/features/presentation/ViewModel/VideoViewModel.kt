package com.edu.vplayer.features.presentation.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.vplayer.features.data.resource.remote.Resource
import com.edu.vplayer.features.domain.model.VideoDetails
import com.edu.vplayer.features.domain.usecase.GetVideoUrlUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


class VideoViewModel : ViewModel() {

    var videoDetails by mutableStateOf<VideoDetails?>(null)
    fun addVideoDetails(newVideoDetails: VideoDetails) {
        videoDetails = newVideoDetails
    }
}


//private var _videoDetails by mutableStateOf(VideoState())
//val videoDetails: VideoState get() = _videoDetails
//
//fun addVideoDetails(newVideoDetails: VideoDetails) {
//
//    getVideoUrlUseCase().onEach {
//        _videoDetails = when (it) {
//            is Resource.Loading -> {
//                VideoState(isLoading = true)
//            }
//            is Resource.Success -> {
//                VideoState(data = it.data)
//            }
//            is Resource.Error -> {
//                VideoState(error = it.message.toString())
//            }
//        }
//    }.launchIn(viewModelScope)
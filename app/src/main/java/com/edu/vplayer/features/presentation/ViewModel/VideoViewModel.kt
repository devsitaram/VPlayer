package com.edu.vplayer.features.presentation.ViewModel

import android.os.Parcelable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize


@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
class VideoDetails(
    val title: String,
    val videoUri: String,
) : Parcelable

class VideoViewModel: ViewModel() {
    var videoDetails by mutableStateOf<VideoDetails?>(null)
    fun addVideoDetails(newVideoDetails: VideoDetails) {
        videoDetails = newVideoDetails
    }
}
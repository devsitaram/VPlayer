package com.edu.vplayer.features.presentation.state

import com.edu.vplayer.features.data.resource.remote.api.model.VideoDataPojo
import com.edu.vplayer.features.data.resource.remote.api.model.VideoPojo

data class VideoDataState(
    val isLoading: Boolean = false,
    val isData: VideoDataPojo? = null,
    val isError: String = "",
)
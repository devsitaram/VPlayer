package com.edu.vplayer.features.presentation.state

import com.edu.vplayer.features.data.resource.remote.api.model.VideoResult
import com.edu.vplayer.features.data.resource.remote.api.model.VideoUrlPojo


data class VideoUrlState(
    val isLoading: Boolean = false,
    val isData: VideoResult? = null,
    val isError: String = "",
)

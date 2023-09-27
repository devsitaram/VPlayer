package com.edu.vplayer.features.presentation.state

import com.edu.vplayer.features.data.resource.remote.api.model.VideoResult

data class VideoUrlState(
    val isLoading: Boolean = false,
    val isData: VideoResult? = null,
    val isError: String = "",
)

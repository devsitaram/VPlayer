package com.edu.vplayer.features.presentation.state

import com.edu.vplayer.features.data.resource.remote.api.model.VideoUrlPojo


data class VideoUrlState(
    val isLoading: Boolean = false,
    val isData: VideoUrlPojo? = null,
    val isError: String = "",
)

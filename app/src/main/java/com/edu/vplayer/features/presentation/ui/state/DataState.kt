package com.edu.vplayer.features.presentation.ui.state

import com.edu.vplayer.features.domain.model.VideoDetails

data class DataState(
    val isLoading: Boolean = false,
    val data: VideoDetails? = null,
    val error: String = ""
)
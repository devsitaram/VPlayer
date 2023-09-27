package com.edu.vplayer.features.presentation.state

import com.edu.vplayer.features.data.resource.remote.api.model.SubjectItems
import com.edu.vplayer.features.data.resource.remote.api.model.VideoPojo

data class VideoState
    (
    val isLoading: Boolean = false,
    val isData: VideoPojo? = null,
    val isError: String = "",
            )
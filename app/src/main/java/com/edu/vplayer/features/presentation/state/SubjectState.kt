package com.edu.vplayer.features.presentation.state

import com.edu.vplayer.features.data.resource.remote.api.model.SubjectItem
import com.edu.vplayer.features.data.resource.remote.api.model.SubjectItems

data class SubjectState(
    val isLoading: Boolean = false,
    val isData: List<SubjectItems?>? = null,
    val isError: String = "",
)

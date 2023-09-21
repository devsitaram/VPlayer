package com.edu.vplayer.features.domain.model

import com.edu.vplayer.features.data.resource.remote.api.model.SubjectItem

data class SubjectState(
    val isLoading: Boolean = false,
    val isData: List<SubjectItem?>? = null,
    val isError: String = "",
)

package com.edu.vplayer.features.presentation.state

import com.edu.vplayer.features.data.resource.remote.api.model.ResultItem
import com.edu.vplayer.features.data.resource.remote.api.model.UsersPojo

data class ProfileState(
    val isLoading: Boolean = false,
    val isData: UsersPojo? = null,
    val isError: String = "",
    )

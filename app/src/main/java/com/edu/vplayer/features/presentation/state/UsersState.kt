package com.edu.vplayer.features.presentation.state

import com.edu.vplayer.features.data.data_resource.remote.api.model.AuthPojo


data class UsersState(
    val isLoading: Boolean = false,
    val isData: AuthPojo? = null,
    val isError: String = "",
)
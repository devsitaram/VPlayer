package com.edu.vplayer.features.presentation.state

import com.edu.vplayer.features.data.resource.remote.api.model.LoginPojo


data class UsersState(
    val isLoading: Boolean = false,
    val isData: LoginPojo? = null,
    val isError: String = "",
)
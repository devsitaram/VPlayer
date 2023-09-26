package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.data.resource.remote.api.model.LoginPojo

interface UserRepository {
    suspend fun authenticateUser(email: String, password: String): LoginPojo?
}

package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.data.resource.remote.api.model.AuthPojo

interface UserRepository {
    suspend fun authenticateUser(email: String, password: String): AuthPojo?
}

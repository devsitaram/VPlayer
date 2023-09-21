package com.edu.vplayer.features.domain.repository

interface RegisterUserRepository {
    suspend fun insertUser(name: String?,email: String?, password: String?): Boolean

}
package com.edu.vplayer.features.data.data_resource.remote.repository

import com.edu.vplayer.features.data.data_resource.remote.api.ApiService
import com.edu.vplayer.features.data.data_resource.remote.api.model.AuthPojo
import com.edu.vplayer.features.domain.model.UserDetails
import com.edu.vplayer.features.domain.repository.UserRepository

class UsersRepoImpl(private val apiService: ApiService) : UserRepository {
    override suspend fun authenticateUser(email: String, password: String): AuthPojo {
        try {
            val userDetails = UserDetails(
                userNameOrEmailAddress = email,
                password = password,
                rememberClient = false,
                couponCode = ""
            )
            val response = apiService.getUser(userDetails)
            return response ?: throw Exception("Login Error: ${response?.error}")
        } catch (e: Exception) {
            throw Exception(e)
        }
    }
}
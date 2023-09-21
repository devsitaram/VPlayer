package com.edu.vplayer.features.data.repository_impl

import com.edu.vplayer.features.data.resource.local.User
import com.edu.vplayer.features.data.resource.local.UserDao
import com.edu.vplayer.features.data.resource.remote.api.ApiService
import com.edu.vplayer.features.data.resource.remote.api.model.AuthPojo
import com.edu.vplayer.features.domain.model.UserDetails
import com.edu.vplayer.features.domain.repository.UserRepository

class UserRepoImpl(private val apiService: ApiService) : UserRepository {
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

//    override suspend fun insertUser(name: String?, password: String?) {
//        try {
//            val userList = listOf(User(name = name, password = password))
////            userDao.insertUser(userList)
//        } catch (e: Exception) {
//            throw Exception("error $e")
//        }
//    }


}
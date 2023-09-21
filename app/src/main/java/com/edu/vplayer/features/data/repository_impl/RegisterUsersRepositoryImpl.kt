package com.edu.vplayer.features.data.repository_impl

import com.edu.vplayer.features.data.resource.local.User
import com.edu.vplayer.features.data.resource.local.UserDao
import com.edu.vplayer.features.domain.repository.RegisterUserRepository

class RegisterUsersRepositoryImpl(private val userDao: UserDao) : RegisterUserRepository {

    override suspend fun insertUser(name: String?, email: String?, password: String?): Boolean {
        return try {
            val userList = listOf(User(name = name, email= email, password = password))
            userDao.insertUser(userList)
            true
        } catch (e: Exception) {
            false
        }
    }
}
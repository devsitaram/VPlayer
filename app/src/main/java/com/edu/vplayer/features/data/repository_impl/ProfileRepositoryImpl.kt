package com.edu.vplayer.features.data.repository_impl

import com.edu.vplayer.features.data.resource.local.ProfileEntity
import com.edu.vplayer.features.data.resource.local.UserDao
import com.edu.vplayer.features.data.resource.remote.api.ApiService
import com.edu.vplayer.features.data.resource.remote.api.model.ResultItem
import com.edu.vplayer.features.data.resource.remote.api.model.UsersPojo
import com.edu.vplayer.features.domain.repository.ProfileRepository

class ProfileRepositoryImpl(private val apiService: ApiService, private val userDao: UserDao) : ProfileRepository {
    override suspend fun getUsersDetails(): UsersPojo? {
        try {
            return apiService.getProfile() ?: throw Exception("Error")
        } catch (e: Exception) {
            throw Exception(e)
        }
    }

    override suspend fun getProfileDetails(profileEntity: ProfileEntity?) {
        try {
            userDao.insertUserDetails(profileEntity)
        } catch (e: Exception){
            throw Exception(e)
        }
    }
}
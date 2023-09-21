package com.edu.vplayer.features.data.repository_impl

import com.edu.vplayer.features.data.resource.remote.api.ApiService
import com.edu.vplayer.features.data.resource.remote.api.model.ResultItem
import com.edu.vplayer.features.domain.repository.ProfileRepository

class ProfileRepositoryImpl(private val apiService: ApiService): ProfileRepository {
    override suspend fun getProfileDetails(): List<ResultItem> {
        try {
            return apiService.getProfile().result.map { it}
        } catch (e:Exception){
            throw Exception(e)
        }
    }
}
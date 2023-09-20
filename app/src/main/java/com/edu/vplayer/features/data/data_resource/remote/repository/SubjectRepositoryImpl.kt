package com.edu.vplayer.features.data.data_resource.remote.repository

import com.edu.vplayer.features.data.data_resource.remote.api.ApiConstants.token
import com.edu.vplayer.features.data.data_resource.remote.api.ApiService
import com.edu.vplayer.features.data.data_resource.remote.api.model.SubjectItem
import com.edu.vplayer.features.domain.repository.SubjectRepository

class SubjectRepositoryImpl(private val apiService: ApiService) : SubjectRepository {
    override suspend fun getSubjectDetails(): List<SubjectItem> {
        try {
            return apiService.getSubject().result.map { it }
        } catch (e: Exception) {
            throw Exception(e)
        }
    }
}
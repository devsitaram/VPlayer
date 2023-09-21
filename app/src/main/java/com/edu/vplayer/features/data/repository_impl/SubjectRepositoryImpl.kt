package com.edu.vplayer.features.data.repository_impl

import com.edu.vplayer.features.data.resource.remote.api.ApiService
import com.edu.vplayer.features.data.resource.remote.api.model.ResultItem
import com.edu.vplayer.features.data.resource.remote.api.model.SubjectItem
import com.edu.vplayer.features.data.resource.remote.api.model.UsersPojo
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
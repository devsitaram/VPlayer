package com.edu.vplayer.features.data.repository_impl

import com.edu.vplayer.features.data.resource.remote.api.ApiService
import com.edu.vplayer.features.data.resource.remote.api.model.VideoUrlPojo
import com.edu.vplayer.features.domain.repository.VideoUrlRepository

class VideoUrlRepositoryImpl(private val apiService: ApiService) : VideoUrlRepository {
    override suspend fun getVideoUrl(videoId: Int?): VideoUrlPojo {
        try {
            return apiService.getVideoUrl(videoId) ?: throw Exception("Error")
        } catch (e: Exception) {
            throw Exception(e)
        }
    }
}
package com.edu.vplayer.features.data.repository_impl

import com.edu.vplayer.features.data.resource.remote.api.ApiService
import com.edu.vplayer.features.data.resource.remote.api.model.VideoDataPojo
import com.edu.vplayer.features.domain.repository.VideoInfoRepository

class VideoInfoRepositoryImpl(private val apiService: ApiService) : VideoInfoRepository {
    override suspend fun getVideoData(): VideoDataPojo? {
        try {
            return apiService.getVideoData() ?: throw Exception("Error")

        } catch (e: Exception) {

            throw Exception(e)
        }
    }
}


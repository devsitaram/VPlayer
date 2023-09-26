package com.edu.vplayer.features.data.repository_impl

import com.edu.vplayer.features.data.resource.remote.api.ApiServicesVideo
import com.edu.vplayer.features.data.resource.remote.api.model.Result
import com.edu.vplayer.features.data.resource.remote.api.model.VideoPojo
import com.edu.vplayer.features.domain.repository.VideoRepository

class VideoRepositoryImpl(private val apiServicesVideo: ApiServicesVideo): VideoRepository {
    override suspend fun getVideoDetails(): VideoPojo? {
        try {
            return apiServicesVideo.getVideo() ?: throw  Exception("Error")
        } catch (e: Exception){
            throw  Exception(e)
        }
    }
}

package com.edu.vplayer.features.domain.usecase

import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.data.resource.local.VideoImageEntity
import com.edu.vplayer.features.data.resource.remote.api.model.VideoResult
import com.edu.vplayer.features.domain.repository.VideoUrlRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VideoUrlUseCase(private val videoUrlRepository: VideoUrlRepository) {
    operator fun invoke(videoId: Int?): Flow<Resource<VideoResult>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = videoUrlRepository.getVideoUrl(videoId)))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))

        }
    }
    operator fun invoke(videosItem: List<VideoImageEntity>) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = videoUrlRepository.insertVideoImageDetails(videosItem)))

        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}
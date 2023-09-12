package com.edu.vplayer.features.domain.usecase

import com.edu.vplayer.features.data.resource.remote.Resource
import com.edu.vplayer.features.domain.model.VideoDetails
import com.edu.vplayer.features.domain.repository.VideoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetVideoUrlUseCase(private val videoRepository: VideoRepository) {
    operator fun invoke(): Flow<Resource<VideoDetails>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = videoRepository.getVideoUrl()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}
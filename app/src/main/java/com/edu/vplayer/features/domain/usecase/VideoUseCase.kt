package com.edu.vplayer.features.domain.usecase

import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.data.resource.remote.api.model.VideoPojo
import com.edu.vplayer.features.data.resource.remote.api.model.VideoResult
import com.edu.vplayer.features.domain.repository.VideoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VideoUseCase(private  val videoRepository: VideoRepository) {
    operator fun invoke(): Flow<Resource<VideoPojo>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = videoRepository.getVideoDetails()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}
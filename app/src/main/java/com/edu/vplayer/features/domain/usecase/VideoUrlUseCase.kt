package com.edu.vplayer.features.domain.usecase

import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.data.resource.remote.api.model.UsersPojo
import com.edu.vplayer.features.data.resource.remote.api.model.VideoUrlPojo
import com.edu.vplayer.features.domain.repository.VideoUrlRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VideoUrlUseCase(private val videoUrlRepository: VideoUrlRepository) {
    operator fun invoke(videoId: Int?): Flow<Resource<VideoUrlPojo>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = videoUrlRepository.getVideoUrl(videoId)))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))

        }
    }
}
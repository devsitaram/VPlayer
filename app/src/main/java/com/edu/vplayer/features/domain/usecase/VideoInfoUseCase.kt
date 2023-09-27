package com.edu.vplayer.features.domain.usecase

import androidx.lifecycle.ViewModel
import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.data.resource.remote.api.model.VideoDataPojo
import com.edu.vplayer.features.domain.repository.VideoInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
class VideoInfoUseCase(private  val videoInfoRepository: VideoInfoRepository) {
    operator fun invoke(): Flow<Resource<VideoDataPojo?>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = videoInfoRepository.getVideoData()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}
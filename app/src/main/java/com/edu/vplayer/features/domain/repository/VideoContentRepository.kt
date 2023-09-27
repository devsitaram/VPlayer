package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.data.resource.local.VideoImageEntity
import com.edu.vplayer.features.data.resource.remote.api.model.VideoResult

interface VideoContentRepository{
     suspend fun getVideoContent(videoId: Int?): VideoResult?
      suspend fun insertVideoImageDetails(videosItem: List<VideoImageEntity>)

}
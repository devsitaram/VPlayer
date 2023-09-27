package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.data.resource.remote.api.model.VideoDataPojo

interface VideoInfoRepository {
    suspend fun getVideoData(): VideoDataPojo?
}
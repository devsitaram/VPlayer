package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.domain.model.VideoDetails

interface VideoRepository {
    suspend fun getVideoUrl(): VideoDetails
}
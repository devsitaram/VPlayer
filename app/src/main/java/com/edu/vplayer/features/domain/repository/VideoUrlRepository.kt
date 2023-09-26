package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.data.resource.local.SubjectEntity
import com.edu.vplayer.features.data.resource.local.VideoImageEntity
import com.edu.vplayer.features.data.resource.remote.api.model.VideoResult
import com.edu.vplayer.features.data.resource.remote.api.model.VideoUrlPojo
import com.edu.vplayer.features.data.resource.remote.api.model.VideosItem

interface VideoUrlRepository{
     suspend fun getVideoUrl(videoId: Int?): VideoResult?
    suspend fun insertVideoImageDetails(videosItem: List<VideoImageEntity>)

}
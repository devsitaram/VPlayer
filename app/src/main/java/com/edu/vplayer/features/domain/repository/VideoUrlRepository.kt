package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.data.resource.remote.api.model.VideoUrlPojo

interface VideoUrlRepository{

     suspend fun getVideoUrl(videoId: Int?): VideoUrlPojo
 }
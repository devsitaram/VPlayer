package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.data.resource.remote.api.model.Result
import com.edu.vplayer.features.data.resource.remote.api.model.VideoPojo


interface VideoRepository {

    suspend fun getVideoDetails(): VideoPojo?

}
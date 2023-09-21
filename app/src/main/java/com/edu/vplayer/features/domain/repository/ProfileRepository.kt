package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.data.resource.remote.api.model.ResultItem

interface ProfileRepository {
    suspend fun getProfileDetails(): List<ResultItem>

}
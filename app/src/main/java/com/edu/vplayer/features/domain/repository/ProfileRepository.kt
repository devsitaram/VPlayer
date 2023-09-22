package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.data.resource.local.ProfileEntity
import com.edu.vplayer.features.data.resource.remote.api.model.ResultItem
import com.edu.vplayer.features.data.resource.remote.api.model.UsersPojo

interface ProfileRepository {
    suspend fun getUsersDetails(): UsersPojo?
    suspend fun getProfileDetails(profileEntity: ProfileEntity?)

}
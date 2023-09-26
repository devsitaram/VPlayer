package com.edu.vplayer.features.domain.usecase

import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.data.resource.local.ProfileEntity
import com.edu.vplayer.features.data.resource.remote.api.model.UsersPojo
import com.edu.vplayer.features.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProfileUseCase(private val profileRepository: ProfileRepository) {

    operator fun invoke(): Flow<Resource<UsersPojo?>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = profileRepository.getUsersDetails()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))

        }
    }
    operator  fun invoke(profileEntity: ProfileEntity?) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = profileRepository.getProfileDetails(profileEntity)))
        } catch (e: Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}
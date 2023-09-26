package com.edu.vplayer.features.domain.usecase

import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.data.resource.remote.api.model.LoginPojo
import com.edu.vplayer.features.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow



class  LoginUseCase(private val userRepository: UserRepository) {
    operator fun invoke(email: String ,password: String): Flow<Resource<LoginPojo?>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = userRepository.authenticateUser(email , password)))
        } catch (e: Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}
package com.edu.vplayer.features.domain.usecase

import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.domain.repository.RegisterUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RegisterUserUseCase(private val registerUserRepository: RegisterUserRepository) {
    operator fun invoke(name: String?,email: String?, password: String?): Flow<Resource<Boolean?>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = registerUserRepository.insertUser(name, email , password)))
        } catch (e: Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}
package com.edu.vplayer.features.domain.usecase

import com.edu.vplayer.features.data.data_resource.common.Resource
import com.edu.vplayer.features.data.data_resource.remote.api.model.SubjectItem
import com.edu.vplayer.features.domain.repository.SubjectRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SubjectUseCase(private val subjectRepository: SubjectRepository) {

    operator fun invoke(): Flow<Resource<List<SubjectItem?>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = subjectRepository.getSubjectDetails()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}
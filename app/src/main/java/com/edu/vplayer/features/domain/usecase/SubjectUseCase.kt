package com.edu.vplayer.features.domain.usecase

import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.data.resource.local.SubjectEntity
import com.edu.vplayer.features.data.resource.remote.api.model.SubjectItems
import com.edu.vplayer.features.domain.repository.SubjectRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SubjectUseCase(private val subjectRepository: SubjectRepository) {
    operator fun invoke(): Flow<Resource<List<SubjectItems?>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = subjectRepository.getSubjectDetails()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }

    operator fun invoke(subjectItems: List<SubjectEntity>) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = subjectRepository.insertSubjectDetails(subjectItems)))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }

}
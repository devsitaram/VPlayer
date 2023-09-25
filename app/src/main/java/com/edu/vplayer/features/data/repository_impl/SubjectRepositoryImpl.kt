package com.edu.vplayer.features.data.repository_impl

import com.edu.vplayer.features.data.resource.local.SubjectEntity
import com.edu.vplayer.features.data.resource.local.UserDao
import com.edu.vplayer.features.data.resource.remote.api.ApiService
import com.edu.vplayer.features.data.resource.remote.api.model.SubjectItems
import com.edu.vplayer.features.domain.repository.SubjectRepository

class SubjectRepositoryImpl(private val apiService: ApiService , private val userDao: UserDao) : SubjectRepository {
    override suspend fun getSubjectDetails(): List<SubjectItems> {
        try {
            val getSubject = userDao.getSubjectDetails()
            return getSubject.ifEmpty {
                return apiService.getSubject().result.map { it }
            }
//            return apiService.getSubject().result.map { it }
        } catch (e: Exception) {
            throw Exception(e)
        } }

    override suspend fun insertSubjectDetails(subjectItems: List<SubjectEntity>) {
        try {
            userDao.insertSubjectDetails(subjectItems)
        } catch (e: Exception){
            throw Exception(e)
        }
    }

}
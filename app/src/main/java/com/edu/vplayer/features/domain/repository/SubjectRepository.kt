package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.data.data_resource.remote.api.model.SubjectItem

interface SubjectRepository {
    suspend fun getSubjectDetails(): List<SubjectItem>
}
package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.data.resource.local.ProfileEntity
import com.edu.vplayer.features.data.resource.local.SubjectEntity
import com.edu.vplayer.features.data.resource.remote.api.model.ResultItem
import com.edu.vplayer.features.data.resource.remote.api.model.SubjectItem
import com.edu.vplayer.features.data.resource.remote.api.model.SubjectItems
import com.edu.vplayer.features.data.resource.remote.api.model.UsersPojo

interface SubjectRepository {
    suspend fun getSubjectDetails(): List<SubjectItems>
    suspend fun insertSubjectDetails(subjectItems: List<SubjectEntity>)

}
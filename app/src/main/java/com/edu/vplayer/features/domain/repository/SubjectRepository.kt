package com.edu.vplayer.features.domain.repository

import com.edu.vplayer.features.data.resource.remote.api.model.ResultItem
import com.edu.vplayer.features.data.resource.remote.api.model.SubjectItem
import com.edu.vplayer.features.data.resource.remote.api.model.UsersPojo

interface SubjectRepository {

    suspend fun getSubjectDetails(): List<SubjectItem>

}
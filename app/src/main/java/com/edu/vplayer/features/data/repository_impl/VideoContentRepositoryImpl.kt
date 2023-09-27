package com.edu.vplayer.features.data.repository_impl

import com.edu.vplayer.features.data.resource.local.UserDao
import com.edu.vplayer.features.data.resource.local.VideoImageEntity
import com.edu.vplayer.features.data.resource.remote.api.ApiService
import com.edu.vplayer.features.data.resource.remote.api.model.VideoResult
import com.edu.vplayer.features.domain.repository.VideoContentRepository

class VideoContentRepositoryImpl(private val apiService: ApiService, private  val userDao: UserDao) : VideoContentRepository {
    override suspend fun getVideoContent(videoId: Int?): VideoResult? {
        try {
             val getVideoImage = userDao.getVideoImageDetails()
            return if (getVideoImage?.id == null){
                apiService.getVideoUrl(videoId).result
            } else {
                getVideoImage
            }
        } catch (e: Exception) {
            throw Exception(e)
        }
    }
    override suspend fun insertVideoImageDetails(videosItem: List<VideoImageEntity>) {
        try {
            userDao.insertVideoImageDetails(videosItem)
        } catch (e: Exception){
            throw Exception(e)
        }

    }
}
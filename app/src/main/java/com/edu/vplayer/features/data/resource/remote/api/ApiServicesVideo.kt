package com.edu.vplayer.features.data.resource.remote.api

import com.edu.vplayer.features.data.resource.remote.api.model.VideoDataPojo
import com.edu.vplayer.features.data.resource.remote.api.model.VideoPojo
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiServicesVideo {

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2OTU3NjY0ODIsInBhcmFtcyI6eyJvd25lciI6IjYwMTBlNWExMTJiYmI0MDAxMjE0YmQ5NyIsInZpZXdlciI6Ijk5MTA2IiwidmlkZW9JZCI6IjYyNTZhNGU5MjgwZDgxMDAxMjQ2MTUwMCIsInBsYXliYWNrSWQiOiJQVkxFcFdpZ0FJRk1kNWQzZzZ3dGRvYloxaGhIdVhseFByR2FMZDZ5M25FIiwicGxheWJhY2tSYXRlIjowLCJjYW5TZWVrIjp0cnVlLCJpc1dvcmtlZE91dCI6ZmFsc2UsInRpbWUiOjYzOC42OTUsInBhcmVudFRoZW1lIjoiZ2xvYmFsIn0sImlhdCI6MTY5NTcyMzI4Mn0.EkMEdDnR9h6Yj6mGxf2-b0_iylT1wsKEJzicfI8DqZ8")
    @GET("v1/embed")
    suspend fun getVideo(): VideoPojo?









}
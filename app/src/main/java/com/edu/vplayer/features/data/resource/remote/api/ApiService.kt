package com.edu.vplayer.features.data.resource.remote.api

import com.edu.vplayer.features.data.resource.remote.api.ApiConstants.ENDPOINTS
import com.edu.vplayer.features.data.resource.remote.api.model.LoginPojo
import com.edu.vplayer.features.data.resource.remote.api.model.SubjectPojo
import com.edu.vplayer.features.data.resource.remote.api.model.SubjectsPojo
import com.edu.vplayer.features.data.resource.remote.api.model.UsersPojo
import com.edu.vplayer.features.data.resource.remote.api.model.VideoDataPojo
import com.edu.vplayer.features.data.resource.remote.api.model.VideoPojo
import com.edu.vplayer.features.data.resource.remote.api.model.VideoUrlPojo
import com.edu.vplayer.features.domain.model.UserDetails
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("TokenAuth/Authenticate/")
    suspend fun getUser(@Body userDetails: UserDetails): LoginPojo?
//    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6Ijk5MTA2IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Im5pa2VuLm1haGFyamFuK25tc3RzdHVkQGlubm92YXRldGVjaC5jbyIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2VtYWlsYWRkcmVzcyI6Im5pa2VuLm1haGFyamFuK25tc3RzdHVkQGlubm92YXRldGVjaC5jbyIsIkFzcE5ldC5JZGVudGl0eS5TZWN1cml0eVN0YW1wIjoiQUVPVUVBREVJUUtJN1hQWTVCRTNBVlQ3WUhLSzQySVAiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJTdHVkZW50IiwiaHR0cDovL3d3dy5hc3BuZXRib2lsZXJwbGF0ZS5jb20vaWRlbnRpdHkvY2xhaW1zL3RlbmFudElkIjoiMSIsInN1YiI6Ijk5MTA2IiwianRpIjoiYWI3ZDUyZTMtNjc0Mi00MzE3LWI3NzYtN2IxMTBiM2ZiZmUyIiwiaWF0IjoxNjk1Nzk0MDI3LCJuYmYiOjE2OTU3OTQwMjcsImV4cCI6MTY5NzAwMzYyNywiaXNzIjoiQVBvbGxvIiwiYXVkIjoiQVBvbGxvIn0.uDkpnUQ04_dcuztmexbBm-0fEQdeOmtg9z4BoUvBGF4")
    @GET(ENDPOINTS)
    suspend fun getSubject(): SubjectsPojo
//    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6Ijk5MTA2IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Im5pa2VuLm1haGFyamFuK25tc3RzdHVkQGlubm92YXRldGVjaC5jbyIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2VtYWlsYWRkcmVzcyI6Im5pa2VuLm1haGFyamFuK25tc3RzdHVkQGlubm92YXRldGVjaC5jbyIsIkFzcE5ldC5JZGVudGl0eS5TZWN1cml0eVN0YW1wIjoiQUVPVUVBREVJUUtJN1hQWTVCRTNBVlQ3WUhLSzQySVAiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJTdHVkZW50IiwiaHR0cDovL3d3dy5hc3BuZXRib2lsZXJwbGF0ZS5jb20vaWRlbnRpdHkvY2xhaW1zL3RlbmFudElkIjoiMSIsInN1YiI6Ijk5MTA2IiwianRpIjoiYWI3ZDUyZTMtNjc0Mi00MzE3LWI3NzYtN2IxMTBiM2ZiZmUyIiwiaWF0IjoxNjk1Nzk0MDI3LCJuYmYiOjE2OTU3OTQwMjcsImV4cCI6MTY5NzAwMzYyNywiaXNzIjoiQVBvbGxvIiwiYXVkIjoiQVBvbGxvIn0.uDkpnUQ04_dcuztmexbBm-0fEQdeOmtg9z4BoUvBGF4")
    @GET("subjects/{videoId}/average-tree")
    suspend fun getVideoUrl(@Path("videoId") videoId: Int?): VideoUrlPojo //157

//    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6Ijk5MTA2IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Im5pa2VuLm1haGFyamFuK25tc3RzdHVkQGlubm92YXRldGVjaC5jbyIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2VtYWlsYWRkcmVzcyI6Im5pa2VuLm1haGFyamFuK25tc3RzdHVkQGlubm92YXRldGVjaC5jbyIsIkFzcE5ldC5JZGVudGl0eS5TZWN1cml0eVN0YW1wIjoiQUVPVUVBREVJUUtJN1hQWTVCRTNBVlQ3WUhLSzQySVAiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJTdHVkZW50IiwiaHR0cDovL3d3dy5hc3BuZXRib2lsZXJwbGF0ZS5jb20vaWRlbnRpdHkvY2xhaW1zL3RlbmFudElkIjoiMSIsInN1YiI6Ijk5MTA2IiwianRpIjoiZDU2YTg5NGEtYzdhMC00NDg3LWI5NmYtNDYwODFhOGYwYTE4IiwiaWF0IjoxNjk1NzIxODA1LCJuYmYiOjE2OTU3MjE4MDUsImV4cCI6MTY5NjkzMTQwNSwiaXNzIjoiQVBvbGxvIiwiYXVkIjoiQVBvbGxvIn0.NelRYQAMGDWl_kqwWfuphGvRsjaKYLkVtbAwca_P8IY")
    @GET("/videos/6256a4e9280d810012461500/embed/")
    suspend fun getVideoData(): VideoDataPojo?
//    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6Ijk5MTA2IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Im5pa2VuLm1haGFyamFuK25tc3RzdHVkQGlubm92YXRldGVjaC5jbyIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2VtYWlsYWRkcmVzcyI6Im5pa2VuLm1haGFyamFuK25tc3RzdHVkQGlubm92YXRldGVjaC5jbyIsIkFzcE5ldC5JZGVudGl0eS5TZWN1cml0eVN0YW1wIjoiQUVPVUVBREVJUUtJN1hQWTVCRTNBVlQ3WUhLSzQySVAiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJTdHVkZW50IiwiaHR0cDovL3d3dy5hc3BuZXRib2lsZXJwbGF0ZS5jb20vaWRlbnRpdHkvY2xhaW1zL3RlbmFudElkIjoiMSIsInN1YiI6Ijk5MTA2IiwianRpIjoiZDU2YTg5NGEtYzdhMC00NDg3LWI5NmYtNDYwODFhOGYwYTE4IiwiaWF0IjoxNjk1NzIxODA1LCJuYmYiOjE2OTU3MjE4MDUsImV4cCI6MTY5NjkzMTQwNSwiaXNzIjoiQVBvbGxvIiwiYXVkIjoiQVBvbGxvIn0.NelRYQAMGDWl_kqwWfuphGvRsjaKYLkVtbAwca_P8IY")
    @GET("students/profile/")
    suspend fun getProfile(): UsersPojo?







}
package com.edu.vplayer.features.data.resource.remote.api

import com.edu.vplayer.features.data.resource.remote.api.ApiConstants.ENDPOINTS
import com.edu.vplayer.features.data.resource.remote.api.model.LoginPojo
import com.edu.vplayer.features.data.resource.remote.api.model.SubjectPojo
import com.edu.vplayer.features.data.resource.remote.api.model.SubjectsPojo
import com.edu.vplayer.features.data.resource.remote.api.model.UsersPojo
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

//    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjkwNjg0IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Im5wMDFtYTRzMjIwMDA0QGlzbGluZ3RvbmNvbGxlZ2UuZWR1Lm5wIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvZW1haWxhZGRyZXNzIjoibnAwMW1hNHMyMjAwMDRAaXNsaW5ndG9uY29sbGVnZS5lZHUubnAiLCJBc3BOZXQuSWRlbnRpdHkuU2VjdXJpdHlTdGFtcCI6IjJTQlpESkxENFFBR05NNVdCQzczNDJMVUNTTVJEVzdKIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiU3R1ZGVudCIsImh0dHA6Ly93d3cuYXNwbmV0Ym9pbGVycGxhdGUuY29tL2lkZW50aXR5L2NsYWltcy90ZW5hbnRJZCI6IjEiLCJzdWIiOiI5MDY4NCIsImp0aSI6Ijk0OTRmZWFkLWU5NDQtNDU2NC1hYjY5LWE4ZjVkNmU1NDNjNiIsImlhdCI6MTY5NTM2MzI1MywibmJmIjoxNjk1MzYzMjUzLCJleHAiOjE2OTY1NzI4NTMsImlzcyI6IkFQb2xsbyIsImF1ZCI6IkFQb2xsbyJ9.NE8ADiyeBVFIn_oKBGNnaVHFCCZUUfQiSlmVfmjVeAg")
//    @GET(ENDPOINTS)
//    suspend fun getSubject(): SubjectPojo

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6Ijk5MTA2IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Im5pa2VuLm1haGFyamFuK25tc3RzdHVkQGlubm92YXRldGVjaC5jbyIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2VtYWlsYWRkcmVzcyI6Im5pa2VuLm1haGFyamFuK25tc3RzdHVkQGlubm92YXRldGVjaC5jbyIsIkFzcE5ldC5JZGVudGl0eS5TZWN1cml0eVN0YW1wIjoiQUVPVUVBREVJUUtJN1hQWTVCRTNBVlQ3WUhLSzQySVAiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJTdHVkZW50IiwiaHR0cDovL3d3dy5hc3BuZXRib2lsZXJwbGF0ZS5jb20vaWRlbnRpdHkvY2xhaW1zL3RlbmFudElkIjoiMSIsInN1YiI6Ijk5MTA2IiwianRpIjoiZDU2YTg5NGEtYzdhMC00NDg3LWI5NmYtNDYwODFhOGYwYTE4IiwiaWF0IjoxNjk1NzIxODA1LCJuYmYiOjE2OTU3MjE4MDUsImV4cCI6MTY5NjkzMTQwNSwiaXNzIjoiQVBvbGxvIiwiYXVkIjoiQVBvbGxvIn0.NelRYQAMGDWl_kqwWfuphGvRsjaKYLkVtbAwca_P8IY")
    @GET(ENDPOINTS)
    suspend fun getSubject(): SubjectsPojo
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjkwNjg0IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Im5wMDFtYTRzMjIwMDA0QGlzbGluZ3RvbmNvbGxlZ2UuZWR1Lm5wIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvZW1haWxhZGRyZXNzIjoibnAwMW1hNHMyMjAwMDRAaXNsaW5ndG9uY29sbGVnZS5lZHUubnAiLCJBc3BOZXQuSWRlbnRpdHkuU2VjdXJpdHlTdGFtcCI6IjJTQlpESkxENFFBR05NNVdCQzczNDJMVUNTTVJEVzdKIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiU3R1ZGVudCIsImh0dHA6Ly93d3cuYXNwbmV0Ym9pbGVycGxhdGUuY29tL2lkZW50aXR5L2NsYWltcy90ZW5hbnRJZCI6IjEiLCJzdWIiOiI5MDY4NCIsImp0aSI6Ijk3OTMwNjM0LTNhN2YtNDY4MC1iNzg4LTRkODcwOGVlNzEwYyIsImlhdCI6MTY5NTcwMjc5NCwibmJmIjoxNjk1NzAyNzk0LCJleHAiOjE2OTY5MTIzOTQsImlzcyI6IkFQb2xsbyIsImF1ZCI6IkFQb2xsbyJ9.zOqXTlO3CSoWcx2rT7IqQpXr04msSRhJweziNfRcswc")
    @GET("students/profile/")
    suspend fun getProfile(): UsersPojo?

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6Ijk5MTA2IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Im5pa2VuLm1haGFyamFuK25tc3RzdHVkQGlubm92YXRldGVjaC5jbyIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2VtYWlsYWRkcmVzcyI6Im5pa2VuLm1haGFyamFuK25tc3RzdHVkQGlubm92YXRldGVjaC5jbyIsIkFzcE5ldC5JZGVudGl0eS5TZWN1cml0eVN0YW1wIjoiQUVPVUVBREVJUUtJN1hQWTVCRTNBVlQ3WUhLSzQySVAiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJTdHVkZW50IiwiaHR0cDovL3d3dy5hc3BuZXRib2lsZXJwbGF0ZS5jb20vaWRlbnRpdHkvY2xhaW1zL3RlbmFudElkIjoiMSIsInN1YiI6Ijk5MTA2IiwianRpIjoiZDU2YTg5NGEtYzdhMC00NDg3LWI5NmYtNDYwODFhOGYwYTE4IiwiaWF0IjoxNjk1NzIxODA1LCJuYmYiOjE2OTU3MjE4MDUsImV4cCI6MTY5NjkzMTQwNSwiaXNzIjoiQVBvbGxvIiwiYXVkIjoiQVBvbGxvIn0.NelRYQAMGDWl_kqwWfuphGvRsjaKYLkVtbAwca_P8IY")
    @GET("subjects/{videoId}/average-tree")
    suspend fun getVideoUrl(@Path("videoId") videoId: Int?): VideoUrlPojo //157





}
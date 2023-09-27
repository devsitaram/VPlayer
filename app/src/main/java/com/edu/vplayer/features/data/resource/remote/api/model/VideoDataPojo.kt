package com.edu.vplayer.features.data.resource.remote.api.model

data class VideoDataPojo(
	val result: VideoResults? = null,
	val success: Boolean? = null,
	val abp: Boolean? = null,
	val error: Any? = null,
	val targetUrl: String? = null,
	val unAuthorizedRequest: Boolean? = null
)
data class VideoResults(
	val message: String? = null,
	val embedToken: String? = null,
	val url: String? = null
)


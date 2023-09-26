package com.edu.vplayer.features.data.resource.remote.api.model

data class MainVideoUrlPojo(
	val result: VideoResults? = null,
	val success: Boolean? = null,
	val abp: Boolean? = null,
	val error: Any? = null,
	val targetUrl: Any? = null,
	val unAuthorizedRequest: Boolean? = null
)

data class VideoResults(
	val message: Any? = null,
	val embedToken: String? = null,
	val url: String? = null
)


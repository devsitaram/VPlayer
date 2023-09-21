package com.edu.vplayer.features.data.resource.remote.api.model

data class SubjectPojo(
	val result: List<SubjectItem>,
	val success: Boolean,
	val abp: Boolean,
	val error: Any,
	val targetUrl: Any,
	val unAuthorizedRequest: Boolean
)

data class SubjectItem(
	val photoUrl: String,
	val name: String,
	val description: String,
	val id: Int,
	val isIvy: Boolean
)


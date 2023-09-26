package com.edu.vplayer.features.data.resource.remote.api.model

data class LoginPojo(
	val result: Results? = null,
	val success: Boolean? = null,
	val abp: Boolean? = null,
	val error: Any? = null,
	val targetUrl: Any? = null,
	val unAuthorizedRequest: Boolean? = null
)

data class Chatroom(
	val enableAttachment: Boolean? = null,
	val enableChatroom: Boolean? = null
)

data class Results(
	val featureList: Any? = null,
	val features: Features? = null,
	val tempAuthToken: Any? = null,
	val encryptedCode: Any? = null,
	val expireInSeconds: Int? = null,
	val encryptedAccessToken: String? = null,
	val otpExpireTime: Int? = null,
	val accessToken: String? = null,
	val userId: Int? = null,
	val couponCode: String? = null
)

data class Testpaper(
	val enableNormalTestpaper: Boolean? = null,
	val enableTestpaper: Boolean? = null,
	val enableSelfMarkTestpaper: Boolean? = null
)

data class Features(
	val testpaper: Testpaper? = null,
	val subject: Subject? = null,
	val profile: Profile? = null,
	val chatroom: Chatroom? = null,
	val classroom: Classroom? = null,
	val timeLine: TimeLine? = null,
	val teachingResource: Any? = null
)

data class Profile(
	val enableSubscriptionAction: Boolean? = null
)

data class Classroom(
	val enableTeacherContent: Boolean? = null,
	val enableClassroom: Boolean? = null,
	val enableSession: Boolean? = null,
	val enableAssignment: Boolean? = null
)

data class Subject(
	val enableIVY: Boolean? = null,
	val enableStore: Boolean? = null,
	val enableEbooks: Boolean? = null,
	val enableOtherEbooks: Boolean? = null
)

data class TimeLine(
	val enableTimeLine: Boolean? = null
)


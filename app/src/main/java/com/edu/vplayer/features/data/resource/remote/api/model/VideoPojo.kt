package com.edu.vplayer.features.data.resource.remote.api.model

data class VideoPojo(
	val result: Result? = null,
	val success: Boolean? = null,
	val error: Any? = null
)

data class Action(
	val groupId: String? = null,
	val time: Any? = null,
	val type: String? = null,
	val value: String? = null
)

data class AnnotationsItem(
	val owner: String? = null,
	val updatedBy: String? = null,
	val label: String? = null,
	val video: String? = null,
	val pause: Boolean? = null,
	val createdAt: String? = null,
	val deleted: Boolean? = null,
	val createdBy: String? = null,
	val v: Int? = null,
	val startTime: Any? = null,
	val id: String? = null,
	val position: Position? = null,
	val dimension: Dimension? = null,
	val items: List<ItemsItem?>? = null,
	val updatedAt: String? = null
)

data class ItemsItem(
	val createdAt: String? = null,
	val deleted: Boolean? = null,
	val options: List<OptionsItem?>? = null,
	val id: String? = null,
	val type: String? = null,
	val content: String? = null,
	val updatedAt: String? = null
)

data class TimeLineItem(
	val endTimeLine: Any? = null,
	val id: String? = null,
	val startTimeLine: Any? = null
)

data class OptionsItem(
	val createdAt: String? = null,
	val answerOptionCodes: List<Any?>? = null,
	val deleted: Boolean? = null,
	val action: Action? = null,
	val id: String? = null,
	val content: String? = null,
	val updatedAt: String? = null
)

data class Result(
	val prevAnswers: List<Any?>? = null,
	val secondaryProvider: String? = null,
	val thumbnail: String? = null,
	val controlBars: ControlBars? = null,
	val annotations: List<AnnotationsItem?>? = null,
	val streamingUrl: String? = null,
	val timeLine: List<TimeLineItem?>? = null,
	val canSeek: Boolean? = null,
	val title: String? = null,
	val playbackRate: Int? = null,
	val prevInteractions: Boolean? = null,
	val provider: String? = null,
	val time: Any? = null,
	val parentTheme: String? = null,
	val isWorkedOut: Boolean? = null
)

data class ControlBars(
	val hasEndOfLessonQuiz: Boolean? = null,
	val seekBar: Boolean? = null
)

data class Position(
	val top: String? = null,
	val left: String? = null
)

data class Dimension(
	val width: String? = null,
	val height: String? = null
)


package com.edu.vplayer.features.data.resource.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.edu.vplayer.features.data.resource.remote.api.model.ChaptersItem

@Entity(tableName = "VideoImage_table")
data class VideoImageEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "completion")
    val completion: String? = null,
    @ColumnInfo(name = "photoUrl")
    val photoUrl: String? = null,
    @ColumnInfo(name = "chapters")
    val chapters: List<ChaptersItem?>? = null,
    @ColumnInfo(name = "subjectDescription")
    val subjectDescription: String? = null,
    @ColumnInfo(name = "totalVideoWatchedTimeInSeconds")
    val totalVideoWatchedTimeInSeconds: String? = null,
    @ColumnInfo(name = "className")
    val className: String? = null,
    @ColumnInfo(name = "subjectName")
    val subjectName: String? = null,
    @ColumnInfo(name = "mastery")
    val mastery: String? = null

)

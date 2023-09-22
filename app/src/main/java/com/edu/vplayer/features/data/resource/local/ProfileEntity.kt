package com.edu.vplayer.features.data.resource.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Profile_table")
data class ProfileEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "name")
    val name: String? = null,
    @ColumnInfo(name = "email")
    val email: String? = null,
    @ColumnInfo(name = "collegeName")
    val collegeName: String? = null,
    @ColumnInfo(name = "location")
    val location: String? = null
)

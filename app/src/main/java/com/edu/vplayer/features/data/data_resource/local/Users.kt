package com.edu.vplayer.features.data.data_resource.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "users_table")
data class Users(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id")
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name ="password")
    val password: String?
)

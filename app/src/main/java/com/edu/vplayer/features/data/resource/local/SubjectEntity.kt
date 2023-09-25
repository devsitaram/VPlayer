package com.edu.vplayer.features.data.resource.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.edu.vplayer.features.data.resource.remote.api.model.AssetType
import com.edu.vplayer.features.data.resource.remote.api.model.Level
import com.edu.vplayer.features.data.resource.remote.api.model.StudentSubject

@Entity(tableName = "Subject_table")
data class SubjectEntity(
    @PrimaryKey
    @ColumnInfo(name = "subjectId")
    val subjectId: Int? = null,
    @ColumnInfo(name = "yearlyPrice")
    val yearlyPrice: String? = null,
    @ColumnInfo(name = "studentSubject")
    val studentSubject: StudentSubject? = null,
    @ColumnInfo(name = "validityStartDate")
    val validityStartDate: String? = null,
    @ColumnInfo(name = "level")
    val level: Level? = null,
    @ColumnInfo(name = "packageId")
    val packageId: Int? = null,
    @ColumnInfo(name = "packageTag")
    val packageTag: String? = null,
    @ColumnInfo(name = "monthlyPrice")
    val monthlyPrice: String? = null,
    @ColumnInfo(name = "validityEndDate")
    val validityEndDate: String? = null,
    @ColumnInfo(name = "halfYearlyPrice")
    val halfYearlyPrice: String? = null,
    @ColumnInfo(name = "assetType")
    val assetType: AssetType? = null,
    @ColumnInfo(name = "photoUrl")
    val photoUrl: String? = null,
    @ColumnInfo(name = "isComingSoon")
    val isComingSoon: Boolean? = null,
    @ColumnInfo(name = "name")
    val name: String? = null,
    @ColumnInfo(name = "planEndDate")
    val planEndDate: String? = null,
    @ColumnInfo(name = "packageGrade")
    val packageGrade: String? = null,
    @ColumnInfo(name = "isStudentPremium")
    val isStudentPremium: Boolean? = null,
    @ColumnInfo(name = "order")
    val order: Int? = null
)

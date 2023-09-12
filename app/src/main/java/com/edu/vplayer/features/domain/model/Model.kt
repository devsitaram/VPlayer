package com.edu.vplayer.features.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class VideoDetails(
    val title: String,
    val descriptions: String,
    val videoUri: String,
) : Parcelable
package com.news.domain.models.newslist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaMetadata(
    val format: String?,
    val height: Int = 0,
    val url: String?,
    val width: Int = 0,
) : Parcelable
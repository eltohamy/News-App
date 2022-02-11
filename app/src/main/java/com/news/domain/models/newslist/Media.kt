package com.news.domain.models.newslist

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Media(
    val approved_for_syndication: Int = 0,
    val caption: String?,
    val copyright: String?,
    @SerializedName("media-metadata")
    val mediaMetaData: List<MediaMetadata?>?,
    val subtype: String?,
    val type: String?,
) : Parcelable
package com.news.domain.models.newslist

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    @SerializedName("abstract")
    val abstractString: String?,
    val adx_keywords: String?,
    val asset_id: Long = 0,
    val byline: String?,
    val column: String?,
    val des_facet: List<String?>?,
    val eta_id: Int = 0,
    val geo_facet: List<String?>?,
    val id: Long = 0,
    val media: List<Media?>?,
    val nytdsection: String?,
    val org_facet: List<String?>?,
    val per_facet: List<String?>?,
    val published_date: String?,
    val section: String?,
    val source: String?,
    val subsection: String?,
    val title: String?,
    val type: String?,
    val updated: String?,
    val uri: String?,
    val url: String?,
) : Parcelable
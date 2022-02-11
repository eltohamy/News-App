package com.news.domain.models.newslist

data class NewsResponse(
    val copyright: String?,
    val num_results: Int = 0,
    val results: List<Result?>?,
    val status: String?,
)
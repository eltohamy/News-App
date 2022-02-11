package com.news.domain.models.newslist

data class NewsListState(
    val isLoading: Boolean = false,
    val newsResponse: NewsResponse? = null,
    val exception: Exception? = null
)

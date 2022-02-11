package com.news.data.repository

import com.news.domain.models.newslist.NewsResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi

interface DataRepository {
    @ExperimentalCoroutinesApi
    suspend fun getNewsList(section: String, period: Int): NewsResponse
}
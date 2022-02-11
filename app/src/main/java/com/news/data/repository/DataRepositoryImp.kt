package com.news.data.repository

import com.news.data.network.ApiService
import com.news.domain.models.newslist.NewsResponse
import javax.inject.Inject

class DataRepositoryImp @Inject constructor(private val apiService: ApiService) : DataRepository {
    override suspend fun getNewsList(section: String, period: Int): NewsResponse {
        return apiService.getNewsList(section, period)
    }
}
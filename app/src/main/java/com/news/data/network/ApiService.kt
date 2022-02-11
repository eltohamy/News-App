package com.news.data.network

import com.news.domain.models.newslist.NewsResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @ExperimentalCoroutinesApi
    @GET(NetworkingConstants.GET_MOST_VIEWED_LIST)
    suspend fun getNewsList(
        @Path("section") section: String,
        @Path("period") period: Int,
        @Query("api-key") apiKey: String = NetworkingConstants.API_KEY,
    ): NewsResponse
}
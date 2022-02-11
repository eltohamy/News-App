package com.news.domain.usecases.newslist

import com.news.data.network.ResultData
import com.news.data.repository.DataRepository
import com.news.domain.models.newslist.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsUseCase @Inject
constructor(
    private val dataRepository: DataRepository,
) {

    operator fun invoke(
        section: String,
        period: Int,
    ): Flow<ResultData<NewsResponse>> = flow {
        try {
            emit(ResultData.Loading())
            val newsResponse = dataRepository.getNewsList(section, period)
            emit(ResultData.Success(newsResponse))
        } catch (exception: Exception) {
            exception.printStackTrace()
            emit(
                ResultData.Exception(exception)
            )
        }
    }.flowOn(Dispatchers.IO)
}
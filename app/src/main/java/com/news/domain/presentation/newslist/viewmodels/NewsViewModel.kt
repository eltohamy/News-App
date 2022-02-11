package com.news.domain.presentation.newslist.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.data.network.ResultData
import com.news.domain.models.newslist.NewsListState
import com.news.domain.models.newslist.NewsResponse
import com.news.domain.usecases.newslist.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
@ExperimentalCoroutinesApi
class NewsViewModel @Inject constructor(val newsUseCase: NewsUseCase) : ViewModel() {

    private var getNewsJob: Job? = null
    private val mutableState = mutableStateOf(NewsListState())
    val state: State<NewsListState> = mutableState

    init {
        getNews()
    }

    fun getNews() {
        getNewsJob = newsUseCase("all-sections", 7).onEach { result ->
            when (result) {
                is ResultData.Loading -> {
                    mutableState.value = NewsListState(isLoading = true)
                }
                is ResultData.Success<NewsResponse> -> {
                    mutableState.value = NewsListState(newsResponse = result.data)
                    getNewsJob?.cancel()
                }
                is ResultData.Exception -> mutableState.value =
                    NewsListState(exception = result.exception)
                is ResultData.Failed -> mutableState.value =
                    NewsListState()
            }
        }.launchIn(viewModelScope)
    }
}

package com.news.domain.presentation.newslist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.news.R
import com.news.domain.presentation.basecomponents.BaseAppBar
import com.news.domain.presentation.basecomponents.RetryButton
import com.news.domain.presentation.newslist.viewmodels.NewsViewModel
import com.news.utility.Screens
import java.net.UnknownHostException

@ExperimentalFoundationApi
@Composable
fun NewsListScreen(
    newsViewModel: NewsViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state = newsViewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            BaseAppBar(stringResource(id = R.string.app_name), navController, false)
            state.newsResponse?.let { it ->
                it.results?.let { results ->
                    if (results.isNotEmpty())
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(5.dp)
                        ) {
                            items(results) { result ->
                                result?.let {
                                    NewsListItem(result, onItemClick = {
                                        /*
                                        -Compose navigation is not supporting sending objects till now.
                                        -So I used below workaround .
                                        -It is not the correct way to pass objects , will be updated once navigation supported it
                                          */
                                        navController.navigate(
                                            Screens.NewsDetailsScreen.route + "?title=${it.title},?abstractString=${it.abstractString},?url=${
                                                if (it.media?.isNotEmpty() == true && it.media[0]?.mediaMetaData?.isNotEmpty() == true)
                                                    it.media[0]?.mediaMetaData?.last()?.url ?: " "
                                                else " "
                                            },?publishedDate=${it.published_date}"
                                        )
                                    })
                                }
                            }
                        } else
                        ShowError(stringResource(R.string.empty_response))
                } ?: run {
                    ShowError(stringResource(R.string.empty_response))
                }
            } ?: run {
                ShowError()
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        state.exception?.let {
            if (it is UnknownHostException)
                ShowError(stringResource(R.string.error_no_internet_connection))
            else
                ShowError()
        }

    }
}

@Composable
@Preview(showBackground = true)
fun ShowError(
    message: String = stringResource(id = R.string.error),
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally).padding(horizontal = 10.dp),
            text = message,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 16.sp
        )
        RetryButton(
            modifier = Modifier
                .wrapContentWidth()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(vertical = 10.dp, horizontal = 10.dp), onItemClick = {
                newsViewModel.getNews()
            }
        )
    }
}
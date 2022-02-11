package com.news.utility

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.news.domain.presentation.newsdetails.NewsDetailsScreen
import com.news.domain.presentation.newslist.NewsListScreen

@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.NewsListingScreen.route
    )
    {
        composable(route = Screens.NewsListingScreen.route) {
            NewsListScreen(navController = navController)
        }
        /*
        -Compose navigation is not supporting sending objects till now.
        -So I used below workaround .
        -It is not the correct way to pass objects , will be updated once navigation supported it
         */
        composable(
            route = Screens.NewsDetailsScreen.route +
                    "?title={title}," +
                    "?abstractString={abstractString}," +
                    "?url={url}," +
                    "?publishedDate={publishedDate}",
            arguments = listOf(navArgument("title") {
                type = NavType.StringType
            }, navArgument("abstractString") {
                type = NavType.StringType
            }, navArgument("url") {
                type = NavType.StringType
            }, navArgument("publishedDate") {
                type = NavType.StringType
            }
            )
        )
        {
            val title = it.arguments?.getString("title")
            val abstractString = it.arguments?.getString("abstractString")
            val url = it.arguments?.getString("url")
            val publishedDate = it.arguments?.getString("publishedDate")

            if (title != null && abstractString != null && url != null && publishedDate != null) {
                NewsDetailsScreen(
                    navController,
                    title = title,
                    abstractString = abstractString,
                    url = url,
                    publishedDate = publishedDate
                )
            }
        }
    }
}


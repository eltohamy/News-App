package com.news.utility

sealed class Screens(val route: String) {
    object NewsListingScreen : Screens("news_listing_screen")
    object NewsDetailsScreen : Screens("news_details_screen")
}

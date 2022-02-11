package com.news;

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.news.domain.presentation.MainActivity
import com.news.domain.presentation.newslist.NewsListScreen
import com.news.domain.presentation.ui.theme.NewsTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalFoundationApi::class)
@HiltAndroidTest
class NewsListScreenTest {

    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        hiltTestRule.inject()
        composeTestRule.setContent {
            NewsTheme {
                val navController =
                    TestNavHostController(ApplicationProvider.getApplicationContext())
                NewsListScreen(hiltViewModel(), navController)

            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Test
    fun newsListScreenTest() {
        composeTestRule.onNodeWithText("2022-02-05")
        composeTestRule.onNodeWithText("Effort to Rescue a 5-Year-Old Transfixes Morocco, Only to End Sadly")
    }
}

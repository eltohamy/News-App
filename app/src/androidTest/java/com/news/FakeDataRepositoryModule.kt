package com.news;

import com.google.gson.Gson
import com.news.data.repository.DataRepository
import com.news.di.DataRepositoryModule
import com.news.domain.models.newslist.NewsResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataRepositoryModule::class]
)
@Module
object FakeInventoryRepositoryModule {
    @Singleton
    @Provides
    fun provideFakeInventoryRepository() = object : DataRepository {

        @ExperimentalCoroutinesApi
        override suspend fun getNewsList(section: String, period: Int): NewsResponse {
            val response: String = "{\n" +
                    "status: \"OK\",\n" +
                    "copyright: \"Copyright (c) 2022 The New York Times Company.  All Rights Reserved.\",\n" +
                    "num_results: 20,\n" +
                    "results: [\n" +
                    "{\n" +
                    "uri: \"nyt://article/6b72a1a1-2ad8-5ad1-b1d7-3fae6a2e8891\",\n" +
                    "url: \"https://www.nytimes.com/2022/02/05/world/africa/morocco-boy-well.html\",\n" +
                    "id: 100000008193517,\n" +
                    "asset_id: 100000008193517,\n" +
                    "source: \"New York Times\",\n" +
                    "published_date: \"2022-02-05\",\n" +
                    "updated: \"2022-02-06 10:05:28\",\n" +
                    "section: \"World\",\n" +
                    "subsection: \"Africa\",\n" +
                    "nytdsection: \"world\",\n" +
                    "adx_keywords: \"Wells;Deaths (Fatalities);Falls;Rescues;Ighrane (Morocco)\",\n" +
                    "column: null,\n" +
                    "byline: \"By Vivian Yee, Aida Alami and Mona El-Naggar\",\n" +
                    "type: \"Article\",\n" +
                    "title: \"Effort to Rescue a 5-Year-Old Transfixes Morocco, Only to End Sadly\",\n" +
                    "abstract: \"The four-day rescue operation failed to save the life of Rayan, who plunged down a 100-foot well, a devastating outcome to the many Moroccans who were captivated by the effort to save him.\",\n" +
                    "des_facet: [\n" +
                    "\"Wells\",\n" +
                    "\"Deaths (Fatalities)\",\n" +
                    "\"Falls\",\n" +
                    "\"Rescues\"\n" +
                    "],\n" +
                    "org_facet: [ ],\n" +
                    "per_facet: [ ],\n" +
                    "geo_facet: [\n" +
                    "\"Ighrane (Morocco)\"\n" +
                    "],\n" +
                    "media: [\n" +
                    "{\n" +
                    "type: \"image\",\n" +
                    "subtype: \"photo\",\n" +
                    "caption: \"Rescue workers carried Rayan Oram, 5, to an ambulance in Ighrane, Morocco, on Saturday. The boy, who fell down a 100-foot well on Tuesday, was declared dead soon after he was dug out.\",\n" +
                    "copyright: \"Thami Noua /Reuters\",\n" +
                    "approved_for_syndication: 1,\n" +
                    "media-metadata: [\n" +
                    "{\n" +
                    "url: \"https://static01.nyt.com/images/2022/02/05/world/05morocco-hfo1/05morocco-hfo1-thumbStandard.jpg\",\n" +
                    "format: \"Standard Thumbnail\",\n" +
                    "height: 75,\n" +
                    "width: 75\n" +
                    "},\n" +
                    "{\n" +
                    "url: \"https://static01.nyt.com/images/2022/02/05/world/05morocco-hfo1/05morocco-hfo1-mediumThreeByTwo210.jpg\",\n" +
                    "format: \"mediumThreeByTwo210\",\n" +
                    "height: 140,\n" +
                    "width: 210\n" +
                    "},\n" +
                    "{\n" +
                    "url: \"https://static01.nyt.com/images/2022/02/05/world/05morocco-hfo1/05morocco-hfo1-mediumThreeByTwo440.jpg\",\n" +
                    "format: \"mediumThreeByTwo440\",\n" +
                    "height: 293,\n" +
                    "width: 440\n" +
                    "}\n" +
                    "]\n" +
                    "}\n" +
                    "],\n" +
                    "eta_id: 0\n" +
                    "}" +
                    "]\n" +
                    "}"
            return Gson().fromJson(response, NewsResponse::class.java)
        }
    }
}

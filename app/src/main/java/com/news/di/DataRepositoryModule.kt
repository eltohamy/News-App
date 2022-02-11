package com.news.di

import com.news.data.network.ApiService
import com.news.data.repository.DataRepository
import com.news.data.repository.DataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataRepositoryModule {

    @Provides
    fun provideDataRepository(
        apiService: ApiService
    ): DataRepository {
        return DataRepositoryImp(apiService)
    }
}
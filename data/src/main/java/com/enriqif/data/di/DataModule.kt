package com.enriqif.data.di

import com.enriqif.data.api.NotebookApi
import com.enriqif.data.repository.NotebookRepositoryImpl
import com.enriqif.domain.common.Constants.BASE_URL
import com.enriqif.domain.repository.NotebookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDataApi(): NotebookApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NotebookApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNotebookRepository(notebookApi: NotebookApi): NotebookRepository {
        return NotebookRepositoryImpl(notebookApi)
    }
}
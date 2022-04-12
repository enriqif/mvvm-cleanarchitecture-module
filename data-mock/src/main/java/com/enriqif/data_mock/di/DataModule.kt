package com.enriqif.data_mock.di

import com.enriqif.data_mock.repository.NotebookRepositoryImpl
import com.enriqif.domain.repository.NotebookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDataSource(): NotebookRepository = NotebookRepositoryImpl()
}
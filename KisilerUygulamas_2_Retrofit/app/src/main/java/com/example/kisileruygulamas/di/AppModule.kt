package com.example.kisileruygulamas.di

import com.example.kisileruygulamas.data.datasource.KisilerDataSource
import com.example.kisileruygulamas.data.repo.KisilerRepository
import com.example.kisileruygulamas.retrofit.ApiUtils
import com.example.kisileruygulamas.retrofit.KisilerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesKisilerDataSource(kdao : KisilerDao) : KisilerDataSource
    {
        return KisilerDataSource(kdao)
    }
    @Provides
    @Singleton
    fun providesKisilerRepository(kds: KisilerDataSource) : KisilerRepository
    {
        return KisilerRepository(kds)
    }

    @Provides
    @Singleton
    fun ProvidesKisilerDAO() : KisilerDao
    {
        return ApiUtils.getKisilerDao()
    }
}
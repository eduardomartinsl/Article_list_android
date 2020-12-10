package com.martins.article_list.di

import com.martins.article_list.BuildConfig
import com.martins.article_list.services.ArticlesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule{

    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideArticlesApi(retrofit: Retrofit) = retrofit.create(ArticlesService::class.java)

}
package com.martins.article_list.di

import com.martins.article_list.services.ArticlesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule{

    val BASE_URL = "https://blog.cheesecakelabs.com/challenge/"

    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideArticlesApi(retrofit: Retrofit) = retrofit.create(ArticlesService::class.java)

}
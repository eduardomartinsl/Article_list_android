package com.martins.article_list.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(private val app: Application){

    @Provides
    @Singleton
    open fun provideApp() = app

    @Provides
    @Singleton
    open fun provideContext() = app.applicationContext

    @Provides
    @Singleton
    open fun provideSharedPreferences() = app.getSharedPreferences("SHARED_PREFERENCES", Context.MODE_PRIVATE)

}
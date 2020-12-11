package com.martins.article_list.di

import android.content.Context
import androidx.room.Room
import com.martins.article_list.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @Provides
    @Singleton
    fun providesDB(context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, "Database") .build()

    @Provides
    fun ProvidesArticleDao(db: AppDatabase) = db.articlesDao()

}
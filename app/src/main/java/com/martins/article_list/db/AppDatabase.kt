package com.martins.article_list.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.martins.article_list.db.dao.ArticlesDao
import com.martins.article_list.db.model.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articlesDao() : ArticlesDao
}
package com.martins.article_list.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.martins.article_list.db.model.ArticleEntity
import com.martins.article_list.models.Article

@Dao
interface ArticlesDao {
    @Query("SELECT * from articles")
    suspend fun getAllArticles() : List<ArticleEntity>

    @Query("Select * from articles where title = :title")
    suspend fun getArticleByTitle(title: String) : ArticleEntity

    @Insert(onConflict = REPLACE)
    suspend fun updateArticle(article: Article)

}

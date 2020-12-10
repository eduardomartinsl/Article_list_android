package com.martins.article_list.repository

import com.martins.article_list.models.Article
import com.martins.article_list.services.ArticlesService
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
private val service : ArticlesService
) {
    suspend fun getAllArticles() : List<Article>{
        val articles = service.getAllArticles()
        articles.forEach{
            it.wasRead = false
        }
        return articles
    }
}

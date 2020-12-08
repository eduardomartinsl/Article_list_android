package com.martins.article_list.repository

import com.martins.article_list.models.Article
import com.martins.article_list.services.ArticlesService
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
    private val service : ArticlesService
) {
    suspend fun getAllArticles() : List<Article>{
        val response = service.getAllArticles()
        return response
    }
}

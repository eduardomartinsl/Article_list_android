package com.martins.article_list.services

import com.martins.article_list.models.Article
import retrofit2.http.GET

interface ArticlesService {

    @GET("challenge/")
    suspend fun getAllArticles() : List<Article>

}
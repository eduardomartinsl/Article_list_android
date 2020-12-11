package com.martins.article_list.repository

import com.martins.article_list.db.dao.ArticlesDao
import com.martins.article_list.models.Article
import com.martins.article_list.services.ArticlesService
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
    private val service : ArticlesService,
    private val ArticlesDao : ArticlesDao
) {

    suspend fun getAllArticles() : List<Article>{
        var listArticles: MutableList<Article>

        if(ArticlesDao.getAllArticles().isNullOrEmpty()){
            return service.getAllArticles().onEach { article ->
                article.wasRead = false
            }
        }

        return ArticlesDao.getAllArticles() as List<Article>
    }

    suspend fun saveArticles(article: Article){
        ArticlesDao.updateArticle(article)
    }
}
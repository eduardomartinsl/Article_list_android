package com.martins.article_list.ui.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.martins.article_list.adapters.ArticleListAdapter
import com.martins.article_list.extensions.component
import com.martins.article_list.models.Article
import com.martins.article_list.repository.ArticlesRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ArticlesListViewModel (application: Application) : AndroidViewModel(application){

    @Inject lateinit var repository: ArticlesRepository

    private val context = getApplication<Application>().applicationContext

    init {
        getApplication<Application>().component.inject(this)
    }

    private val _articlesList = MutableLiveData<List<Article>>()
    val articlesList : LiveData<List<Article>>
        get() = _articlesList

    private val _articlesListAdapter = MutableLiveData<ArticleListAdapter>()
    val articleListAdapter: LiveData<ArticleListAdapter>
        get() = _articlesListAdapter

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getAllArticles(){
        viewModelScope.launch {
            _isLoading.postValue(true)

            try {
                val foundArticles = repository.getAllArticles()
                fillAdapter(foundArticles)
                _articlesList.postValue(foundArticles)
            }catch (E: Exception){
                Log.e("erro: ", E.toString())
            }finally {
                _isLoading.postValue(false)

            }
        }
    }

    fun sortArticles(filter: String){
       when(filter){
           //TODO: Parei aqui
       }
    }

    private fun fillAdapter(foundArticles: List<Article>) {
        val articleListAdapter = ArticleListAdapter(context, foundArticles)
        _articlesListAdapter.postValue(articleListAdapter)
    }
}
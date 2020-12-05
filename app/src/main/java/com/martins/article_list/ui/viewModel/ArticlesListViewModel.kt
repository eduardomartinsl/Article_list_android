package com.martins.article_list.ui.viewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.martins.article_list.extensions.component
import com.martins.article_list.models.Article
import com.martins.article_list.repository.ArticlesRepository
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class ArticlesListViewModel (application: Application) : AndroidViewModel(application){

    @Inject lateinit var repository: ArticlesRepository

    init {
        getApplication<Application>().component.inject(this)
    }

    private val _articlesList = MutableLiveData<List<Article>>()
    public val articlesList : LiveData<List<Article>>
        get() = _articlesList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getAllArticles(){
        viewModelScope.launch {
            _isLoading.postValue(true)

            try {
                val foundArticles = repository.getAllArticles()
                _articlesList.postValue(foundArticles)
            }catch (E: Exception){

                Log.e("erro", E.toString())

            }finally {
                _isLoading.postValue(false)

            }

        }
    }

}
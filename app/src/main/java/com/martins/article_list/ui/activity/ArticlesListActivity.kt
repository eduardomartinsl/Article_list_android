package com.martins.article_list.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.martins.article_list.R
import com.martins.article_list.adapters.ArticleListAdapter
import com.martins.article_list.extensions.component
import com.martins.article_list.ui.viewModel.ArticlesListViewModel
import kotlinx.android.synthetic.main.activity_articles_list.*


class ArticlesListActivity : AppCompatActivity() {

    private val viewModel by viewModels<ArticlesListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles_list)

        application.component.inject(this)

        viewModel.getAllArticles()

        viewModel.isLoading.observe(this, Observer { isLoading ->
            if(isLoading) progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE
        })

        viewModel.articlesList.observe(this, Observer { articlesList ->

            val linearLayoutManager = LinearLayoutManager(this)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerViewArticles.layoutManager = linearLayoutManager

            val divisor = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
            recyclerViewArticles.addItemDecoration(divisor)

            val ArticleListAdapter =  ArticleListAdapter(this, articlesList)
            recyclerViewArticles.adapter = ArticleListAdapter

        })
    }
}
package com.martins.article_list.ui.activity

import android.os.Bundle
import android.widget.Toast
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

        viewModel.articlesList.observe(this, Observer {
            val ArticleListAdapter =  ArticleListAdapter(it)

            val linearLayoutManager = LinearLayoutManager(this)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

            val divisor = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)


            recyclerViewArticles.addItemDecoration(divisor)
            recyclerViewArticles.layoutManager = linearLayoutManager
            recyclerViewArticles.adapter = ArticleListAdapter

            Toast.makeText(this, "Existe uma lista!!!", Toast.LENGTH_SHORT).show()
        })
    }
}
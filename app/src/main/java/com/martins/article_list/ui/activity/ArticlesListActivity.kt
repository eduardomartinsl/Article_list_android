package com.martins.article_list.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.martins.article_list.R
import com.martins.article_list.extensions.component
import com.martins.article_list.ui.viewModel.ArticlesListViewModel


class ArticlesListActivity : AppCompatActivity() {

    private val viewModel by viewModels<ArticlesListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles_list)

        application.component.inject(this)

        viewModel.getAllArticles()

        viewModel.articlesList.observe(this, Observer {
            Toast.makeText(this, "Existe uma lista!!!", Toast.LENGTH_SHORT).show()
        })
    }
}
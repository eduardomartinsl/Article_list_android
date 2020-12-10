package com.martins.article_list.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.martins.article_list.R
import com.martins.article_list.extensions.component


class ArticlesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles_list)

        application.component.inject(this)
    }
}
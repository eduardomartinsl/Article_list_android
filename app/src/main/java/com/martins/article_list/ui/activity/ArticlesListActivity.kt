package com.martins.article_list.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martins.article_list.R

class ArticlesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles_list)
    }
}
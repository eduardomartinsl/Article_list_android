package com.martins.article_list.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import com.martins.article_list.R
import com.martins.article_list.models.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_article_details.*

class ArticleDetailFragment : Fragment(){

    private val navArguments by navArgs<ArticleDetailFragmentArgs>()

    private val article by lazy {
        Gson().fromJson(navArguments.article, Article::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get().load(article.imageURL).into(imageViewArticle)

        textViewArticleTitle.text = article.title
        textViewArticleContent.text = article.content
        textViewAuthor.text = article.authors
        textViewDate.text = article.date
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article_details, container, false)
    }
}
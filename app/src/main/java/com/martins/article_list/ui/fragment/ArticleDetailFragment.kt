package com.martins.article_list.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.martins.article_list.R
import com.martins.article_list.helpers.Constants.ARTICLE_KEY
import com.martins.article_list.models.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_article_details.*

class ArticleDetailFragment : Fragment(){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gson = Gson()
        val article = gson.fromJson(arguments?.getString(ARTICLE_KEY), Article::class.java)

        Picasso.get().load(article.imageURL).into(imageViewArticle)

        textViewArticleTitle.text = article.title
        textViewArticleContent.text = article.content
        textViewAuthor.text = article.authors
        textViewDate.text = article.date

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_details, container, false)
    }
}
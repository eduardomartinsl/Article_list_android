package com.martins.article_list.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.martins.article_list.R
import com.martins.article_list.adapters.ArticleListAdapter
import com.martins.article_list.helpers.Constants.ARTICLE_KEY
import com.martins.article_list.interfaces.CellClickListener
import com.martins.article_list.models.Article
import com.martins.article_list.ui.viewModel.ArticlesListViewModel
import kotlinx.android.synthetic.main.fragment_articles_list.*

class ArticlesListFragment : Fragment(), CellClickListener{

    private val viewModel by viewModels<ArticlesListViewModel>()
    private val navController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_articles_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllArticles()

        setRecyclerViewProperties()

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            if(isLoading) progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE
        })

        viewModel.articlesList.observe(viewLifecycleOwner, Observer { articlesList ->
            val adapter = ArticleListAdapter(articlesList, this)
            recyclerViewArticles.adapter = adapter
        })
    }

    private fun setRecyclerViewProperties() {
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViewArticles.layoutManager = linearLayoutManager

        val divisor = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        recyclerViewArticles.addItemDecoration(divisor)
    }

    override fun onCellClickListener(article: Article) {
        article.wasRead = false
        navigateToArticleDetail(article)
    }

    private fun navigateToArticleDetail(article: Article) {

        val bundle = Bundle()
        val gson = Gson()

        val serializedArticle = gson.toJson(article)
        bundle.putString(ARTICLE_KEY, serializedArticle)

        navController.navigate(R.id.articleDetailFragment, bundle)

    }

}
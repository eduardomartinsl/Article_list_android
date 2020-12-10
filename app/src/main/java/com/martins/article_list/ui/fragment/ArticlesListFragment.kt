package com.martins.article_list.ui.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.martins.article_list.R
import com.martins.article_list.adapters.ArticleListAdapter
import com.martins.article_list.helpers.Constants
import com.martins.article_list.interfaces.CellClickListener
import com.martins.article_list.models.Article
import com.martins.article_list.ui.viewModel.ArticlesListViewModel
import kotlinx.android.synthetic.main.fragment_articles_list.*


class ArticlesListFragment : Fragment(), CellClickListener{

    private val viewModel by viewModels<ArticlesListViewModel>()
    private val navController by lazy {
        findNavController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_articles_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerViewProperties()

        viewModel.getAllArticles()

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            if (isLoading) progressBar.visibility = View.VISIBLE else progressBar.visibility =
                View.GONE
        })

        viewModel.articlesList.observe(viewLifecycleOwner, Observer { articlesList ->
            val adapter = ArticleListAdapter(articlesList, this)
            recyclerViewArticles.adapter = adapter
        })
    }

    override fun onCellClickListener(article: Article) {
        article.wasRead = true
        navigateToArticleDetail(article)
    }

    private fun navigateToArticleDetail(article: Article) {
        val direction = ArticlesListFragmentDirections.
            actionArticleListToArticleDetailFragment(Gson().toJson(article))

        navController.navigate(direction)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_articles, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val filterTipes = arrayOf(Constants.AUTHOR, Constants.DATE, Constants.TITLE)
        return when (item.itemId){
            R.id.MenuButtonFilter -> {
                val alert = AlertDialog.Builder(requireContext())
                alert.setSingleChoiceItems(
                    filterTipes,
                    -1
                ) { dialog: DialogInterface?, which: Int ->
                    viewModel.sortArticles(filterTipes[which])
                    dialog?.dismiss()
                }
                alert.show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setRecyclerViewProperties() {
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViewArticles.layoutManager = linearLayoutManager

        val divisor = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        recyclerViewArticles.addItemDecoration(divisor)
    }

}
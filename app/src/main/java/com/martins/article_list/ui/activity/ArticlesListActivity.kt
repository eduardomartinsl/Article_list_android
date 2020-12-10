package com.martins.article_list.ui.activity

import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.martins.article_list.R
import com.martins.article_list.extensions.component
import com.martins.article_list.helpers.Constants
import com.martins.article_list.ui.fragment.ArticlesListFragment
import com.martins.article_list.ui.viewModel.ArticlesListViewModel
import kotlinx.android.synthetic.main.activity_articles_list.*


class ArticlesListActivity : AppCompatActivity() {

    private val viewModel by viewModels<ArticlesListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles_list)

        application.component.inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_articles, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val filterTipes = arrayOf(Constants.AUTHOR, Constants.DATE, Constants.TITLE)
        return when (item.itemId){
            R.id.MenuButtonFilter -> {
                val alert = AlertDialog.Builder(this)
                alert.setSingleChoiceItems(filterTipes, -1) { dialog: DialogInterface?, which: Int ->
                    viewModel.sortArticles(filterTipes[which])
                    dialog?.dismiss()
                }
                alert.show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
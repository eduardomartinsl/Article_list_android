package com.martins.article_list.interfaces
import com.martins.article_list.models.Article

interface CellClickListener {
    fun onCellClickListener(Article: Article)
}
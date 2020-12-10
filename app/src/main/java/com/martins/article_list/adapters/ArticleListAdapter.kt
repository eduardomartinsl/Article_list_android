package com.martins.article_list.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.martins.article_list.R
import com.martins.article_list.interfaces.CellClickListener
import com.martins.article_list.models.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleListAdapter(private val articles: List<Article>,
                         private val cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<ArticleListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_article,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = articles.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.let {
            it.title?.text = article.title
            it.authors?.text = article.authors
            it.date?.text = article.date

            Picasso.get().load(article.imageURL).into(it.imageView)
            //Glide as a second option of image rendering
//            Glide.with(context).load(article.imageURL).diskCacheStrategy(DiskCacheStrategy.ALL).into(it.imageView)

            it.itemView.setOnClickListener{
                cellClickListener.onCellClickListener(article)
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val title = itemView.textViewArticleTitle
        val authors = itemView.textViewAuthor
        val date = itemView.textViewDate
        val imageView = itemView.imageViewArticle

    }
}



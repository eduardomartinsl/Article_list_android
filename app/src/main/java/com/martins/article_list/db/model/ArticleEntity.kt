package com.martins.article_list.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.martins.article_list.models.Tag

@Entity(tableName = "articles")
class ArticleEntity (
    @PrimaryKey val id : String,
    val title: String,
    val website: String,
    val authors: String,
    val date: String,
    val content: String,
    val tags: List<Tag>,
    val imageURL: String,
    var wasRead: Boolean
)
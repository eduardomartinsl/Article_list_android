package com.martins.article_list.models

data class Article(
    val title: String,
    val website: String,
    val authors: String,
    val date: String,
    val content: String,
    val tags: Tag,
    val imageURL: String
)
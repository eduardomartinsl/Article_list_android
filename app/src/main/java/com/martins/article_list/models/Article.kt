package com.martins.article_list.models

import com.google.gson.annotations.SerializedName

data class Article(
    val title: String,
    val website: String,
    val authors: String,
    val date: String,
    val content: String,
    val tags: List<Tag>,
    @SerializedName("image_url")
    val imageURL: String
)
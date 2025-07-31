package com.example.firstprojectwithjetpackcompose.features.mapper

import com.example.firstprojectwithjetpackcompose.features.data.remote.ArticleDto
import com.example.firstprojectwithjetpackcompose.features.domain.model.ArticleVo

fun ArticleDto.toArticleVo(): ArticleVo {
    return ArticleVo(
        title = title ?: "Unknown",
        urlToImage = urlToImage?: "Unknown",
        description = description?: "Unknown",
        publishedAt = publishedAt?: "Unknown",
        author = author?: "Unknown",
        content = content?: "Unknown",
        url = url ?: "Unknown"
    )
}
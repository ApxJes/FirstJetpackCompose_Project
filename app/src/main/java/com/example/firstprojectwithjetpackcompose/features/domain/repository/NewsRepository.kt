package com.example.firstprojectwithjetpackcompose.features.domain.repository

import com.example.firstprojectwithjetpackcompose.features.domain.model.ArticleVo

interface NewsRepository {

    suspend fun getBreakingNews(): List<ArticleVo>
}
package com.example.firstprojectwithjetpackcompose.features.presentation.home

import com.example.firstprojectwithjetpackcompose.features.domain.model.ArticleVo

data class BreakingNewsUiState(
    val isLoading: Boolean = false,
    val articles: List<ArticleVo> = emptyList(),
    val error: String? = null
)

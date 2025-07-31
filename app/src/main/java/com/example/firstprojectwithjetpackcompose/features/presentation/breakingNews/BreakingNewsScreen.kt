package com.example.firstprojectwithjetpackcompose.features.presentation.breakingNews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firstprojectwithjetpackcompose.features.presentation.breakingNews.component.ArticleList
import com.example.firstprojectwithjetpackcompose.features.presentation.breakingNews.component.ErrorView
import com.example.firstprojectwithjetpackcompose.features.presentation.breakingNews.component.LoadingView

@Composable
fun BreakingNewsScreen(viewModel: BreakingNewsViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsState()

    when {
        state.isLoading -> LoadingView()
        state.error != null -> ErrorView(message = state.error!!)
        else -> ArticleList(articles = state.articles)
    }
}

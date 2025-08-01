package com.example.firstprojectwithjetpackcompose.features.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.firstprojectwithjetpackcompose.features.presentation.home.component.ArticleList
import com.example.firstprojectwithjetpackcompose.features.presentation.home.component.ErrorView
import com.example.firstprojectwithjetpackcompose.features.presentation.home.component.LoadingView

@Composable
fun BreakingNewsScreen(
    viewModel: BreakingNewsViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val state by viewModel.uiState.collectAsState()

    when {
        state.isLoading -> LoadingView()
        state.error != null -> ErrorView(message = state.error!!)
        else -> ArticleList(
            articles = state.articles,
            navHostController = navHostController
        )
    }
}

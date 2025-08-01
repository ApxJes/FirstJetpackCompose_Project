package com.example.firstprojectwithjetpackcompose.features.presentation.breakingNews

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.firstprojectwithjetpackcompose.features.presentation.breakingNews.component.ArticleList
import com.example.firstprojectwithjetpackcompose.features.presentation.breakingNews.component.ErrorView
import com.example.firstprojectwithjetpackcompose.features.presentation.breakingNews.component.LoadingView
import com.google.gson.Gson

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

package com.example.firstprojectwithjetpackcompose.features.presentation.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.firstprojectwithjetpackcompose.features.domain.model.ArticleVo

@Composable
fun ArticleList(
    articles: List<ArticleVo>,
    navHostController: NavHostController
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(articles, key = { it.url }) { article ->
            ArticleItem(article = article, navHostController = navHostController)
        }
    }
}

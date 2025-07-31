package com.example.firstprojectwithjetpackcompose.features.presentation.breakingNews.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.firstprojectwithjetpackcompose.features.domain.model.ArticleVo

@Composable
fun ArticleList(articles: List<ArticleVo>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(articles) { article ->
            ArticleItem(article = article)
        }
    }
}

package com.example.firstprojectwithjetpackcompose.features.presentation.screen

sealed class Screen(
    val route: String
) {
    data object BreakingNews: Screen(route = "breaking_news")
    data object NewsDetails: Screen(route = "details_screen/{articleUrl}") {
        fun createRoute(url: String) = "details_screen/$url"
    }
}
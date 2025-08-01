package com.example.firstprojectwithjetpackcompose

sealed class Screen(
    val route: String
) {
    data object BreakingNews: Screen(route = "breaking_news")
    data object NewsDetails: Screen(route = "details_screen/{articleUrl}") {
        fun createRoute(url: String) = "details_screen/$url"
    }
    data object SearchScreen: Screen(route = "search_screen")
}
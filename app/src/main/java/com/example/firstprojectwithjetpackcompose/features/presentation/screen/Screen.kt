package com.example.firstprojectwithjetpackcompose.features.presentation.screen

sealed class Screen(
    val screen: String
) {
    data object BreakingNews: Screen(screen = "breaking_news")
}
package com.example.firstprojectwithjetpackcompose

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.firstprojectwithjetpackcompose.features.presentation.breakingNews.BreakingNewsScreen
import com.example.firstprojectwithjetpackcompose.features.presentation.newsDetails.NewsDetailScreen
import com.example.firstprojectwithjetpackcompose.Screen
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.BreakingNews.route,
        modifier = Modifier.systemBarsPadding()
    ) {
        composable(
            route = Screen.BreakingNews.route
        ) {
            BreakingNewsScreen(navHostController = navController)
        }

        composable(
            route = Screen.NewsDetails.route,
            arguments = listOf(
                navArgument("articleUrl") {
                    type = NavType.StringType
                }
            )
        ) {backStackEntry ->
            val articleUrl = backStackEntry.arguments?.getString("articleUrl")
            val decodeUrl = URLDecoder.decode(articleUrl, StandardCharsets.UTF_8.toString())
            NewsDetailScreen(articleUrl = decodeUrl)
        }
    }
}
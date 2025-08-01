package com.example.firstprojectwithjetpackcompose

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.firstprojectwithjetpackcompose.features.presentation.home.BreakingNewsScreen
import com.example.firstprojectwithjetpackcompose.features.presentation.newsDetails.NewsDetailScreen
import com.example.firstprojectwithjetpackcompose.features.presentation.search.SearchScreen
import com.example.firstprojectwithjetpackcompose.ui.theme.Purple40
import com.example.firstprojectwithjetpackcompose.ui.theme.Purple80
import com.example.firstprojectwithjetpackcompose.ui.theme.PurpleGrey80
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun MyBottomAppBar(navController: NavHostController) {
    val selectedButtonAppBar = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Purple40,
                modifier = Modifier.height(80.dp)
            ) {
                IconButton(
                    onClick = {
                        selectedButtonAppBar.value = Icons.Default.Home
                        navController.navigate(Screen.BreakingNews.route) {
                            popUpTo(Screen.BreakingNews.route) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = null,
                        tint = if (selectedButtonAppBar.value == Icons.Default.Home) Purple80 else PurpleGrey80,
                        modifier = Modifier.size(24.dp)
                    )
                }

                IconButton(
                    onClick = {
                        selectedButtonAppBar.value = Icons.Default.Search
                        navController.navigate(Screen.SearchScreen.route) {
                            popUpTo(Screen.SearchScreen.route) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = if (selectedButtonAppBar.value == Icons.Default.Home) PurpleGrey80 else Purple80,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.BreakingNews.route,
            modifier = Modifier
                .systemBarsPadding()
                .padding(paddingValues)
        ) {
            composable(
                route = Screen.BreakingNews.route
            ) {
                BreakingNewsScreen(navHostController = navController)
            }

            composable(
                route = Screen.SearchScreen.route
            ) {
                SearchScreen(navController = navController)
            }

            composable(
                route = Screen.NewsDetails.route,
                arguments = listOf(
                    navArgument("articleUrl") {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val articleUrl = backStackEntry.arguments?.getString("articleUrl")
                val decodeUrl = URLDecoder.decode(articleUrl, StandardCharsets.UTF_8.toString())
                NewsDetailScreen(articleUrl = decodeUrl)
            }
        }
    }
}
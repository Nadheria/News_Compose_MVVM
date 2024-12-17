package com.nadharia.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nadharia.quotes.screens.DetailScreen
import com.nadharia.quotes.ui.theme.QuotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesTheme {
                MyApp()
            }
        }
    }


}


@Composable
fun ComposeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "CategoryScreen"
    ) {
        composable("CategoryScreen") {
            CategoryScreen(navController)
        }
        composable(
            route = "DetailScreen?category={category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                    defaultValue = "android"
                }
            )
        ) {
            DetailScreen()
        }
    }
}


@Composable
fun MyApp() {
    val navController = rememberNavController()
    ComposeNavGraph(navController = navController)
}
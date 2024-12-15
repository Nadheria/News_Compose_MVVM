package com.nadharia.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
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
               App()
            }
        }
    }


}


@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "CategoryScreen") {

        composable(route = "CategoryScreen") {
            CategoryScreen(navController)
        }

        composable(route = "DetailScreen/{Category}", arguments = listOf(
            navArgument("Category"){
                type= NavType.StringType
            }
        )) {
            it.arguments!!.getString("Category")
            DetailScreen()
        }
    }
}
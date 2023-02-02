package ir.truelearn.androidmvvmsample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.truelearn.androidmvvmsample.ui.screens.basket.BasketScreen
import ir.truelearn.androidmvvmsample.ui.screens.category.CategoryScreen
import ir.truelearn.androidmvvmsample.ui.screens.home.HomeScreen
import ir.truelearn.androidmvvmsample.ui.screens.home.WebPageScreen
import ir.truelearn.androidmvvmsample.ui.screens.product_detail.ProductDetail
import ir.truelearn.androidmvvmsample.ui.screens.product_detail.ProductDetailScreen
import ir.truelearn.androidmvvmsample.ui.screens.profile.ProfileScreen
import ir.truelearn.androidmvvmsample.ui.screens.splash.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = Screen.Basket.route) {
            BasketScreen(navController = navController)
        }
        composable(route = Screen.Category.route) {
            CategoryScreen(navController = navController)
        }

        composable(
            route = Screen.ProductDetail.route + "/{id}/{amazing}",
            arguments = listOf(
                navArgument("id") {
                type = NavType.StringType
            },
                navArgument("amazing") {
                    type = NavType.BoolType
                })
        ) {
            ProductDetailScreen(
                navController = navController,
                id = it.arguments?.getString("id").toString(),
                isAmazing = it.arguments!!.getBoolean("amazing")
            )
        }

        composable(
            route = Screen.WebView.route + "?url={url}",
            arguments = listOf(navArgument("url") {
                type = NavType.StringType
                defaultValue = ""
                nullable = true
            })
        ) {
            val url = it.arguments?.getString("url")
            url?.let {
                WebPageScreen(navController = navController, url = url)
            }
        }

    }
}
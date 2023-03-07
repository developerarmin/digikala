package ir.truelearn.androidmvvmsample.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.ui.screens.basket.CartScreen
import ir.truelearn.androidmvvmsample.ui.screens.category.CategoryScreen
import ir.truelearn.androidmvvmsample.ui.screens.basket.checkout.CheckoutScreen
import ir.truelearn.androidmvvmsample.ui.screens.basket.address.SaveUserAddressScreen
import ir.truelearn.androidmvvmsample.ui.screens.basket.address.AddressListScreen
import ir.truelearn.androidmvvmsample.ui.screens.basket.address.selectCityName
import ir.truelearn.androidmvvmsample.ui.screens.basket.checkout.ConfirmPurchaseScreen
import ir.truelearn.androidmvvmsample.ui.screens.home.HomeScreen
import ir.truelearn.androidmvvmsample.ui.screens.home.WebPageScreen
import ir.truelearn.androidmvvmsample.ui.screens.product_detail.ProductDetailScreen
import ir.truelearn.androidmvvmsample.ui.screens.profile.ProfileScreen
import ir.truelearn.androidmvvmsample.ui.screens.splash.SplashScreen
import ir.truelearn.androidmvvmsample.viewmodel.SaveAddressViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    saveAddressViewModel: SaveAddressViewModel = hiltViewModel()
) {
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
            CartScreen(navController = navController)
        }
        composable(route = Screen.CartCheckout.route) {
            CheckoutScreen(navController = navController)
        }
        composable(route = Screen.ConfirmPurchase.route) {
            ConfirmPurchaseScreen(
                navController = navController
            )
        }

        composable(route = Screen.selectAddress.route) {
            AddressListScreen(navController = navController)
        }

        composable(route = Screen.SaveUserAddress.route) {
            SaveUserAddressScreen(navController = navController, viewModel = saveAddressViewModel)

        }

        composable(route = Screen.selectCityName.route + "/{flag}",
            arguments = listOf(
                navArgument("flag") {
                    type = NavType.StringType
                    defaultValue = "1"
                    nullable = true
                }
            )
        )
        {
            val flag = it.arguments?.getString("flag")
            flag?.let {
                selectCityName(
                    navController = navController,
                    flag = flag,
                    viewModel = saveAddressViewModel
                )
            }
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
                id = "63b9f7ce06661704dc22228d",// it.arguments?.getString("id").toString(),
                isAmazing = it.arguments!!.getBoolean("amazing"),
                item = AmazingItem(
                    "63b9f7ce06661704dc22228d",
                    30,
                    "https://dkstatics-public.digikala.com/digikala-products/8ac0af9ed17bfefb8a7f828b9c88cc12e00c4b93_1673936201.jpg?x-oss-process=image/resize,m_lfit,h_800,w_800/format,webp/quality,q_90",
                    "ست تی شرت آستین بلند و شلوار دخترانه ناربن مدل 1521439-84",
                    340000,
                    ""
                )
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
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
import ir.truelearn.androidmvvmsample.ui.screens.home.SearchScreen
import ir.truelearn.androidmvvmsample.ui.screens.home.WebPageScreen
import ir.truelearn.androidmvvmsample.ui.screens.home.search.ProductListScreen
import ir.truelearn.androidmvvmsample.ui.screens.product_detail.NewCommentScreen
import ir.truelearn.androidmvvmsample.ui.screens.product_detail.ProductDetailScreen
import ir.truelearn.androidmvvmsample.ui.screens.profile.LoginScreen
import ir.truelearn.androidmvvmsample.ui.screens.profile.ProfileScreen
import ir.truelearn.androidmvvmsample.ui.screens.profile.SettingScreen
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
        composable(route = Screen.Setting.route) {
            SettingScreen(navController = navController)
        }
        composable(route = Screen.Basket.route) {
            CartScreen(navController = navController)
        }
        composable(route = Screen.CartCheckout.route) {
            CheckoutScreen(navController = navController)
        }
        composable(route = Screen.ConfirmPurchase.route) {
            ConfirmPurchaseScreen(navController = navController)
        }

        composable(route = Screen.selectAddress.route) {
            AddressListScreen(navController = navController)
        }

        composable(route = Screen.SaveUserAddress.route) {
            SaveUserAddressScreen(navController = navController, viewModel = saveAddressViewModel)
        }

        composable(route = Screen.SearchScreen.route ) {
            SearchScreen(navController = navController)
        }

        composable(route = Screen.ProductListScreen.route){
            ProductListScreen(navController = navController)
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
            route = Screen.ProductDetail.route + "/{id}/{amazing}/{price}/{discountPercent}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                },
                navArgument("amazing") {
                    type = NavType.BoolType

                },
                navArgument("price") {
                    type = NavType.IntType
                },
                navArgument("discountPercent") {
                    type = NavType.IntType
                }

            )
        ) {
            ProductDetailScreen(
                navController = navController,
                id = "63b9f7ce06661704dc22228d",// it.arguments?.getString("id").toString(),
                isAmazing = it.arguments!!.getBoolean("amazing"),
                productDetailItemPrice = it.arguments!!.getInt("price"),
                productDiscountPercent = it.arguments!!.getInt("discountPercent")
            )
        }

        composable(
            route = Screen.WebView.route + "?url={url}",
            arguments = listOf(
                navArgument("url") {
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


        composable(
            route = Screen.NewComment.route + "/{image}/{title}",
            arguments = listOf(
                navArgument("image") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("title") {
                    type = NavType.StringType
                    defaultValue = ""
                },
            )
        ) {
            NewCommentScreen(
                navController = navController,
                productDetailImage = it.arguments?.getString("image").toString(),
                productDetailTitle = it.arguments?.getString("title").toString(),
                )

        }

    }
}
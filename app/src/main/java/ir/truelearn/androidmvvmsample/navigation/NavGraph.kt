package ir.truelearn.androidmvvmsample.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

import ir.truelearn.androidmvvmsample.ui.screens.basket.CartScreen
import ir.truelearn.androidmvvmsample.ui.screens.basket.address.AddressListScreen
import ir.truelearn.androidmvvmsample.ui.screens.category.CategoryScreen
import ir.truelearn.androidmvvmsample.ui.screens.basket.checkout.CheckoutScreen
import ir.truelearn.androidmvvmsample.ui.screens.basket.address.SaveUserAddressScreen
import ir.truelearn.androidmvvmsample.ui.screens.basket.address.selectCityName
import ir.truelearn.androidmvvmsample.ui.screens.basket.checkout.ConfirmPurchaseScreen
import ir.truelearn.androidmvvmsample.ui.screens.home.HomeScreen
import ir.truelearn.androidmvvmsample.ui.screens.home.search.SearchScreen
import ir.truelearn.androidmvvmsample.ui.screens.home.WebPageScreen
import ir.truelearn.androidmvvmsample.ui.screens.home.search.ProductListScreen
import ir.truelearn.androidmvvmsample.ui.screens.comment.NewCommentScreen
import ir.truelearn.androidmvvmsample.ui.screens.product_detail.ProductDetailScreen
import ir.truelearn.androidmvvmsample.ui.screens.profile.ProfileScreen
import ir.truelearn.androidmvvmsample.ui.screens.profile.SettingScreen
import ir.truelearn.androidmvvmsample.ui.screens.profile.address.AddressesScreen
import ir.truelearn.androidmvvmsample.ui.screens.profile.favorite_list.FavoriteListScreen
import ir.truelearn.androidmvvmsample.ui.screens.profile.my_orders.TabLayoutScreen
import ir.truelearn.androidmvvmsample.ui.screens.profile.my_orders.UserAccount
import ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation.itemScreens.AddNameAndLastname
import ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation.itemScreens.AddNationalCode
import ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation.itemScreens.AddPassword
import ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation.itemScreens.AddPhoneNumber
import ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation.itemScreens.AddPostAddress
import ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation.itemScreens.AddRefundMethode
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
        composable(route = Screen.Addresses.route) {
            AddressesScreen(navController = navController)
        }

        composable(route = Screen.SaveUserAddress.route) {
            SaveUserAddressScreen(navController = navController, viewModel = saveAddressViewModel)
        }

        composable(route = Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
        composable(route=Screen.FavoriteListScreen.route){
            FavoriteListScreen(navController)
        }
        composable(route = Screen.UserAccountScreen.route){
            UserAccount(navController = navController)
        }
        composable(route = Screen.AddNameandLastname.route){
            AddNameAndLastname(navController = navController)
        }
        composable(route = Screen.PhoneNumber.route){
            AddPhoneNumber(navController = navController)
        }
        composable(route = Screen.PostAddress.route){
            AddPostAddress(navController = navController)
        }
        composable(route = Screen.NationalCode.route){
            AddNationalCode(navController = navController)
        }
        composable(route = Screen.AddRefundMethode.route){
            AddRefundMethode(navController = navController)
        }
        composable(route = Screen.AddPassword.route){
            AddPassword(navController = navController)
        }

        
        composable(route = Screen.ProductListScreen.route + "/{searchValue}",
            arguments = listOf(
                navArgument("searchValue") {
                    type = NavType.StringType
                    defaultValue = " "
                    nullable = true
                }
            )
        ) {
            it.arguments!!.getString("searchValue")
                ?.let { searchValue ->
                    ProductListScreen(
                        navController = navController,
                        searchValue = searchValue
                    )
                }
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

        composable(route = Screen.TabLayoutScreen.route){
            TabLayoutScreen(navController = navController)
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
                id = it.arguments?.getString("id").toString(),
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
            route = Screen.NewComment.route + "?imageUrl={imageUrl}?productName={productName}?productId={productId}",
            arguments = listOf(
                navArgument("imageUrl") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                },
                navArgument("productName") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                },
                navArgument("productId") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )

        ) {

            NewCommentScreen(
                navController = navController,
                imageUrl = it.arguments?.getString("imageUrl").toString(),
                productName = it.arguments?.getString("productName").toString(),
                productId = it.arguments?.getString("productId").toString(),
                )

        }
//        composable(
//            route = Screen.NewComment.route + "/{image}/{title}",
//            arguments = listOf(
//                navArgument("image") {
//                    type = NavType.StringType
//                    defaultValue = ""
//                },
//                navArgument("title") {
//                    type = NavType.StringType
//                    defaultValue = ""
//                },
//            )
//        ) {
//            NewCommentScreen(
//                navController = navController,
//                productDetailImage = it.arguments?.getString("image").toString(),
//                productDetailTitle = it.arguments?.getString("title").toString(),
//                )
//
//        }

    }
}
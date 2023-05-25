package ir.truelearn.androidmvvmsample.navigation

sealed class Screen(val route: String) {

    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Basket : Screen("basket_screen")
    object CartCheckout : Screen("cart_checkout")
    object ConfirmPurchase : Screen("confirm_purchase")
    object Profile : Screen("profile_screen")
    object Category : Screen("category_screen")
    object WebView : Screen("webView_screen")
    object ProductDetail : Screen("productDetail_screen")
    object NewComment : Screen("newComment_screen")
    object SaveUserAddress : Screen("save_user_address")
    object selectAddress : Screen("select_address")//AddressListScreen
    object Addresses : Screen("addresses")//AddressListScreen
    object selectCityName : Screen("select_city_name")
    object SearchScreen : Screen("search_screen")
    object ProductListScreen :Screen("product_search_screen")
    object Setting:Screen("setting_screen")

    object TabLayoutScreen: Screen("tab_layout_screen")
    object FavoriteListScreen : Screen("favorite_list_screen")

    object UserAccountScreen : Screen("User_Account_Screen")
    object AddNameandLastname : Screen("Add_Name_LastName")
    object PhoneNumber : Screen("Phone_Number")
    object PostAddress : Screen("Post_Address")
    object NationalCode : Screen("National_Code")
    object AddRefundMethode : Screen("Refund_Methode")
    object AddPassword : Screen("Add_Password")


    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }

}

package ir.truelearn.androidmvvmsample.navigation

sealed class Screen(val route: String) {

    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Basket : Screen("basket_screen")
    object Profile : Screen("profile_screen")
    object Category : Screen("category_screen")
    object Test : Screen("test_screen")
    object WebView : Screen("webView_screen")

}

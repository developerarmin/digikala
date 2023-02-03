package ir.truelearn.androidmvvmsample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.truelearn.androidmvvmsample.navigation.BottomNavigationBar
import ir.truelearn.androidmvvmsample.navigation.SetupNavGraph
import ir.truelearn.androidmvvmsample.ui.component.AppConfig
import ir.truelearn.androidmvvmsample.ui.component.ChangeStatusBarColor
import ir.truelearn.androidmvvmsample.ui.screens.basket.CartDetailCard
import ir.truelearn.androidmvvmsample.ui.theme.AndroidMvvmSampleTheme
import ir.truelearn.androidmvvmsample.util.LocaleUtils


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            AndroidMvvmSampleTheme {
                navController = rememberNavController()
                ChangeStatusBarColor(navController)

                AppConfig()

                LocaleUtils.setLocale(LocalContext.current, USER_LANGUAGE)
                val direction = if (USER_LANGUAGE == "en") {
                    androidx.compose.ui.unit.LayoutDirection.Ltr
                } else {
                    androidx.compose.ui.unit.LayoutDirection.Rtl
                }
                Surface() {

                }
                CompositionLocalProvider(LocalLayoutDirection provides direction) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                }
                            )
                        },

                        ) {
                        SetupNavGraph(navController = navController)
                    }
                }
            }
        }
    }


    companion object {
        lateinit var USER_TOKEN: String
        lateinit var USER_ID: String
        lateinit var USER_PHONE: String
        lateinit var USER_PASSWORD: String
        lateinit var USER_LANGUAGE: String
    }


}



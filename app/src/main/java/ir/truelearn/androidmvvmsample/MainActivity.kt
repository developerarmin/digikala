package ir.truelearn.androidmvvmsample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import ir.truelearn.androidmvvmsample.navigation.BottomNavigationBar
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.navigation.SetupNavGraph
import ir.truelearn.androidmvvmsample.ui.theme.AndroidMvvmSampleTheme



@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
      //  setTheme(R.style.LauncherTheme)
        super.onCreate(savedInstanceState)
        setContent {
            AndroidMvvmSampleTheme {
                navController = rememberNavController()

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val systemIiController= rememberSystemUiController()
                val isSystemInDarkTheme= isSystemInDarkTheme()

                when ( navBackStackEntry?.destination?.route) {
                    Screen.Splash.route -> { SideEffect{
                        systemIiController.setStatusBarColor(color = if (!isSystemInDarkTheme) Color(0xFFed1b34) else Color.Blue)
                    }
                    }
                    else -> {systemIiController.setStatusBarColor(color=Color.White)}
                }

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

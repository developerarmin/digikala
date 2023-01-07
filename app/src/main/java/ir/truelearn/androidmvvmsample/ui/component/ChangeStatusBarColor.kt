package ir.truelearn.androidmvvmsample.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.Purple200


@Composable
fun ChangeStatusBarColor(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val systemIiController = rememberSystemUiController()

    when (navBackStackEntry?.destination?.route) {
        Screen.Splash.route -> {
            SideEffect {
                systemIiController.setStatusBarColor(
                    color = Purple200
                )
            }
        }
        else -> {
            systemIiController.setStatusBarColor(color = Color.White)
        }
    }
}
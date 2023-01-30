package ir.truelearn.androidmvvmsample

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.LayoutDirection
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.ResolvedTextDirection
import androidx.compose.ui.text.style.TextDirection.Companion.Rtl
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.navigation.BottomNavigationBar
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.navigation.SetupNavGraph
import ir.truelearn.androidmvvmsample.ui.component.AutoLoginUser
import ir.truelearn.androidmvvmsample.ui.component.ChangeStatusBarColor
import ir.truelearn.androidmvvmsample.ui.screens.profile.ProfilePageState
import ir.truelearn.androidmvvmsample.ui.theme.AndroidMvvmSampleTheme
import ir.truelearn.androidmvvmsample.ui.theme.Purple200
import ir.truelearn.androidmvvmsample.util.LocaleUtils
import ir.truelearn.androidmvvmsample.viewmodel.DataStoreViewModel
import ir.truelearn.androidmvvmsample.viewmodel.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import java.util.*

//val Context.dataStore by dataStore("app-settings.json ")

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

                AutoLoginUser()

                val dataStore by viewModels<DataStoreViewModel>()

                LocaleUtils.setLocale(LocalContext.current, "fa")
                CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
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

}



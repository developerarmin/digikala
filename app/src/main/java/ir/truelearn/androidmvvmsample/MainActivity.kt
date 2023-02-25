package ir.truelearn.androidmvvmsample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.zarinpal.ZarinPalBillingClient
import com.zarinpal.billing.purchase.Purchase
import com.zarinpal.client.BillingClientStateListener
import com.zarinpal.client.ClientState
import com.zarinpal.provider.core.future.FutureCompletionListener
import com.zarinpal.provider.core.future.TaskResult
import com.zarinpal.provider.model.response.Receipt
import dagger.hilt.android.AndroidEntryPoint
import ir.truelearn.androidmvvmsample.navigation.BottomNavigationBar
import ir.truelearn.androidmvvmsample.navigation.SetupNavGraph
import ir.truelearn.androidmvvmsample.ui.component.AppConfig
import ir.truelearn.androidmvvmsample.ui.component.ChangeStatusBarColor
import ir.truelearn.androidmvvmsample.ui.screens.basket.ShowBottomSheetDialog
import ir.truelearn.androidmvvmsample.ui.theme.AndroidMvvmSampleTheme
import ir.truelearn.androidmvvmsample.util.LocaleUtils
import ir.truelearn.androidmvvmsample.util.ZarinpalPurchase


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {

//            ZarinpalPurchase.purchase(this, 100, "test") {
//                Log.e("3636", "from lambda $it") //it is transaction id must be save on db
//            }

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
//        const val  MY_TOKEN: String="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiNjNkZjY5YWJkODkwZGUwMDQwNmMzNGIxIiwiaWF0IjoxNjc3MDUwNTkzLCJleHAiOjE2NzcxNzA1OTN9.S7beOjwtXY_oEDoNhgToxa6-JOYCjtm_5XyrKhA1_-M"
     //   const val  MY_TOKEN: String="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiNjNlMGNjZWFkZTAyOTcwMDQwOWEzOTNhIiwiaWF0IjoxNjc3MjMyMjQ5LCJleHAiOjE2NzczNTIyNDl9.OABxWfULzXZVKASwL8B2QJjPKSFYSbSy0d8djgne3ZY"
        const val  MY_TOKEN: String="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiNjNmYTE4ZDBjNDNmZmJmMDMwOTJjZmY1IiwiaWF0IjoxNjc3MzM0NzM3LCJleHAiOjE2Nzc0NTQ3Mzd9.rhchl0iC-SxGXmrSqCCVtzg7JsH2p57838ebYYu14PM"
        const val USER_NAME: String = "user name"
    }


}



package ir.truelearn.androidmvvmsample.ui.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.google.android.material.snackbar.Snackbar
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.*

@Composable
fun HomeScreen(navController: NavHostController) {
    Home(navController=navController)
}


@Composable
fun Home(navController: NavHostController,
         viewModel: HomeViewModel = hiltViewModel()) {
    if (!isSystemInDarkTheme()) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {

            SearchBar(navController)

            val refreshScope = rememberCoroutineScope()
            val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
            SwipeRefresh(state = swipeRefreshState, onRefresh = {
                refreshScope.launch {
                    viewModel.getAllDataFromServer()
                    Log.e("3636", "call again!")
                }
            }) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 60.dp)
                ) {

                    LaunchedEffect(true) {
                        viewModel.getAllDataFromServer()
                    }

                    TopSlider()

                    ShowcaseSection(navController)

                    AmazingOfferSection(navHostController = navController)

                    ProposalCardSection()

                    SuperMarketOfferSection(navHostController = navController)

                    CategoryListSection()

                    BestSellerOfferSection()

                    MostVisitedOfferSection()

                    MostDiscountedSection(navHostController = navController)

                    CenterBannerItem(1)

                    TheMostFavoriteProductSection()

                    ExitFromApp()

                }
            }


        }
    } else {
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
        }
    }

}


@Composable
@Preview
fun HomeScreenLightPreview() {
//    Home()
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun HomeScreenDarkPreview() {
//    Home()
}




//For Exit From App
sealed class BackPress {
    object Idle : BackPress()
    object InitialTouch : BackPress()
}

@Composable
private fun ExitFromApp() {
    var showToast by remember { mutableStateOf(false) }

    var backPressState by remember { mutableStateOf<BackPress>(BackPress.Idle) }
    val context = LocalContext.current

    if(showToast){
        Toast.makeText(context, "برای خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show()
        showToast= false
    }


    LaunchedEffect(key1 = backPressState) {
        if (backPressState == BackPress.InitialTouch) {
            delay(2000)
            backPressState = BackPress.Idle
        }
    }

    BackHandler(backPressState == BackPress.Idle) {
        backPressState = BackPress.InitialTouch
        showToast = true
    }
}



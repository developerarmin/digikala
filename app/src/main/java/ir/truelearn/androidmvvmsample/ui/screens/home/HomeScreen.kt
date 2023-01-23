package ir.truelearn.androidmvvmsample.ui.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.*

@Composable
fun HomeScreen(navController: NavHostController) {
    Home()
}


@Composable
fun Home(viewModel: HomeViewModel = hiltViewModel()) {
    if (!isSystemInDarkTheme()) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {

            SearchBar()

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

                    ShowcaseSection()

                    AmazingOfferSection()

                    ProposalCardSection()

                    CategoryListSection()

                    SuperMarketOfferSection()

                    BestSellerOfferSection()
                    MostVisitedOfferSection()
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
    Home()
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun HomeScreenDarkPreview() {
    Home()
}
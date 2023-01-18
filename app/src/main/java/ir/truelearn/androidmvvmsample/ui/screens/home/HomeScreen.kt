package ir.truelearn.androidmvvmsample.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.AmazingItem
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.*
import ir.truelearn.androidmvvmsample.ui.screens.home.AmazingItem
import ir.truelearn.androidmvvmsample.ui.screens.home.SearchBar
import ir.truelearn.androidmvvmsample.ui.screens.home.ShowMoreItem
import ir.truelearn.androidmvvmsample.ui.theme.DigikalaLightRed
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest

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

            val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
            SwipeRefresh(state = swipeRefreshState, onRefresh = { /*TODO*/ }) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    // connect to server and get all data
                    LaunchedEffect(key1 = true) {
                        viewModel.getAllDataFromServer()
                    }
                    InitAmazingItems()

                    ProposalCards()
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
fun OfferItems() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 12.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        ) {
            RoundedIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "دیجی کالا جت"
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "حراج استایل"
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "خرید اقساطی"
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "دیجی کالا مهر"
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {
            CircularIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "پیشنهاد روز زن"
            )
            CircularIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "کارت هدیه"
            )
            CircularIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "حراج طلا"
            )
            CircularIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "بیشتر"
            )
        }
    }
}

@Composable
fun ProposalCards() {
    val urlList = listOf(
        "https://dkstatics-public.digikala.com/digikala-adservice-banners/4f58b192407ed83e4271555cf8f4213409229189_1672864993.jpg?x-oss-process=image/quality,q_95",
        "https://dkstatics-public.digikala.com/digikala-adservice-banners/4355945a3ff60f3dbe6a6d31fdb86bba0281aaa6_1668268672.jpg?x-oss-process=image/quality,q_95",
        "https://dkstatics-public.digikala.com/digikala-adservice-banners/e2023fd29340b5a4e0569a13651d2a9af34ff87d_1672834922.jpg?x-oss-process=image/quality,q_95",
        "https://dkstatics-public.digikala.com/digikala-adservice-banners/4244d085416507f88a92e433ded27e05690e5f6b_1672865205.jpg?x-oss-process=image/quality,q_95"
    )
    ir.truelearn.androidmvvmsample.ui.screens.home.ProposalCards(urlProposalList = urlList)
}

@Composable
private fun InitAmazingItems(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var list by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = true) {

        viewModel.amazingItems.collectLatest {
            when (it) {
                is NetworkResult.Success -> {
                    withContext(Dispatchers.Main) {
                        list = it.data!!
                        loading = false
                    }
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.d("2121", "InitAmazingItems error:${it.message} ")
                    // show error message
                }
                is NetworkResult.Loading -> {

                    withContext(Dispatchers.Main) {
                        loading = true
                    }
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.DigikalaLightRed)
    ) {
        //Spacer(modifier = Modifier.weight(1f))
        if (loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Loading3Dots()
            }
        } else {
            LazyRow(modifier = Modifier.background(MaterialTheme.colors.DigikalaLightRed)) {
                items(list) { item ->
                    AmazingItem(item)
                }
                item {
                    ShowMoreItem()
                }
            }
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
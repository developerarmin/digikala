package ir.truelearn.androidmvvmsample.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.component.AmazingItem
import ir.truelearn.androidmvvmsample.ui.component.ProposalCards
import ir.truelearn.androidmvvmsample.ui.component.SearchBar
import ir.truelearn.androidmvvmsample.ui.component.ShowMoreItem
import ir.truelearn.androidmvvmsample.ui.theme.DigikalaLightRed
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.ui.theme.unSelectedBottomBar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController) {
    Home()
}


@Composable
fun Home() {
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

                    Amazing()

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
fun ProposalCards(){
    val urlList = listOf(
        "https://dkstatics-public.digikala.com/digikala-adservice-banners/4f58b192407ed83e4271555cf8f4213409229189_1672864993.jpg?x-oss-process=image/quality,q_95",
        "https://dkstatics-public.digikala.com/digikala-adservice-banners/4355945a3ff60f3dbe6a6d31fdb86bba0281aaa6_1668268672.jpg?x-oss-process=image/quality,q_95",
        "https://dkstatics-public.digikala.com/digikala-adservice-banners/e2023fd29340b5a4e0569a13651d2a9af34ff87d_1672834922.jpg?x-oss-process=image/quality,q_95",
        "https://dkstatics-public.digikala.com/digikala-adservice-banners/4244d085416507f88a92e433ded27e05690e5f6b_1672865205.jpg?x-oss-process=image/quality,q_95"
    )
    ProposalCards(urlList)
}
@Composable
private fun Amazing() {
    Column(modifier = Modifier.fillMaxSize()) {
        //Spacer(modifier = Modifier.weight(1f))
        LazyRow(modifier = Modifier.background(MaterialTheme.colors.DigikalaLightRed)) {
            items(20) {
                AmazingItem()
            }
            item {
                ShowMoreItem()
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
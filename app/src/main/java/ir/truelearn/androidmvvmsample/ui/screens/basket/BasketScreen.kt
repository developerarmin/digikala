package ir.truelearn.androidmvvmsample.ui.screens.basket

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.digikalaRed
import ir.truelearn.androidmvvmsample.util.DigitHelper

@Composable
fun BasketScreen(navController: NavHostController) {
    Basket(shopingListCounter=2,nextShopingListCounter=24)
}

@Composable
fun Basket(shopingListCounter:Int,nextShopingListCounter:Int) {
    if (!isSystemInDarkTheme()) {
        var tabIndex by remember { mutableStateOf(0) } // 1.
        val tabTitles = listOf("سبد خرید", "لیست خرید بعدی")
        var counterState = 0

        Column {
            TabRow(
                backgroundColor = Color.White,
                contentColor = MaterialTheme.colors.digikalaRed,
                selectedTabIndex = tabIndex,
                indicator = { line ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(line[tabIndex])
                            .height(3.dp)
                            .background(color = Color.Red)
                    )
                }

            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = tabIndex == index,
                        selectedContentColor = MaterialTheme.colors.digikalaRed,
                        unselectedContentColor = Color.Gray,
                        onClick = { tabIndex = index },
                        text = {
                            Row() {
                                Text(text = title,
                                    style = MaterialTheme.typography.h6,
                                    fontWeight = FontWeight.SemiBold,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Spacer(modifier = Modifier.width(15.dp))

                                if (index == 0)
                                    counterState = shopingListCounter
                                else
                                    counterState = nextShopingListCounter

                                if (counterState > 0) {
                                    if (tabIndex == index) {
                                        Column(
                                            modifier = Modifier,
                                            // .background(color = MaterialTheme.colors.digikalaRed),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center

                                        ) {
                                            Text(
                                                text ="${DigitHelper.digitBySeparator(DigitHelper.digitByLocate(counterState.toString()))} ",
                                                modifier = Modifier
                                                    .background(color = MaterialTheme.colors.digikalaRed)
                                                    .padding(top=0.dp, bottom = 0.dp, start = 5.dp, end = 1.dp),
                                                textAlign = TextAlign.Center,
                                                style = MaterialTheme.typography.h6,
                                                fontWeight = FontWeight.SemiBold,
                                                color = Color.White,
                                            )
                                        }
                                    } else {

                                        Column(
                                            modifier = Modifier,
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center

                                        ) {
                                            Text(
                                                text ="${DigitHelper.digitBySeparator(DigitHelper.digitByLocate(counterState.toString()))} ",
                                                modifier = Modifier
                                                    .background(color =Color.Gray)
                                                    .padding(top=0.dp, bottom = 0.dp, start = 5.dp, end = 1.dp),
                                                textAlign = TextAlign.Center,
                                                style = MaterialTheme.typography.h6,
                                                fontWeight = FontWeight.SemiBold,
                                                color = Color.White,
                                                )
                                        }
                                    }
                                }
                            }
                        },
                        )
                }
            }
            when (tabIndex) {
                0 -> ShoppingBasket()
                1 -> NextShoppingList()
            }
        }
    } else {
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "BasketScreen",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }

}


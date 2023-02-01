package ir.truelearn.androidmvvmsample.ui.screens.basket

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.digikalaRed
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel

@Composable
fun BasketScreen(
    navController: NavHostController,
    viewModel: CartViewModel = hiltViewModel()
) {
    val cartItem = viewModel.cartItemCounter
    val nextCartItem = viewModel.nextCartItemCounter
    Basket(shopingListCounter = cartItem.value, nextShopingListCounter = nextCartItem.value)
}

@Composable
fun Basket(shopingListCounter: Int, nextShopingListCounter: Int) {
    if (!isSystemInDarkTheme()) {
        var selectedTabIndex by remember { mutableStateOf(0) } // 1.
        val tabTitles = listOf(stringResource(R.string.cart),stringResource(R.string.next_cart_list))
        var counterState = 0

        Column {
            TabRow(
                modifier = Modifier
                    .padding(start = MaterialTheme.spacing.medium, end =MaterialTheme.spacing.medium),
                        backgroundColor = Color.White,
                contentColor = MaterialTheme.colors.digikalaRed,
                selectedTabIndex = selectedTabIndex,
                indicator = { line ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(line[selectedTabIndex])
                            .height(3.dp)
                            .background(color = Color.Red)
                    ,
                    )
                }

            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        selectedContentColor = MaterialTheme.colors.digikalaRed,
                        unselectedContentColor = Color.Gray,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Row() {
                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.h6,
                                    fontWeight = FontWeight.SemiBold,
                                    overflow = TextOverflow.Ellipsis
                                )
                                if (index == 0)
                                    counterState = shopingListCounter
                                else
                                    counterState = nextShopingListCounter

                                if (counterState > 0) {
                                    Spacer(modifier = Modifier.width(10.dp))
                                    SetBadgeToTab(
                                        selectedTabIndex = selectedTabIndex,
                                        index = index,
                                        badge = counterState
                                    )
                                }
                            }
                        },
                    )
                }
            }
            when (selectedTabIndex) {
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


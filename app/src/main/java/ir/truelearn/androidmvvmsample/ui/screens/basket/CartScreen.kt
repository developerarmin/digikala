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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.digikalaRed
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CartScreen(
    navController: NavHostController,
) {
    Cart(navController = navController)
}

@Composable
fun Cart(
    navController: NavController,
    viewModel: CartViewModel = hiltViewModel()
) {
    val currentCartItemsCount = remember {
        mutableStateOf(0)
    }
    val nextCartItemsCount = remember {
        mutableStateOf(0)
    }
    LaunchedEffect(key1 = true) {
        viewModel.currentCartItemsCount.collectLatest { count ->
            currentCartItemsCount.value = count
        }
    }
    LaunchedEffect(key1 = true) {
        viewModel.nextCartItemsCount.collectLatest { count ->
            nextCartItemsCount.value = count
        }
    }

    if (!isSystemInDarkTheme()) {
        var selectedTabIndex by remember { mutableStateOf(0) } // 1.
        val tabTitles =
            listOf(stringResource(R.string.cart), stringResource(R.string.next_cart_list))
        var counterState = 0

        Column {
            TabRow(
                modifier = Modifier
                    .padding(
                        start = MaterialTheme.spacing.medium,
                        end = MaterialTheme.spacing.medium
                    ),
                backgroundColor = Color.White,
                contentColor = MaterialTheme.colors.digikalaRed,
                selectedTabIndex = selectedTabIndex,
                indicator = { line ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(line[selectedTabIndex])
                            .height(3.dp)
                            .background(color = Color.Red),
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
                                counterState = if (index == 0)
                                    currentCartItemsCount.value
                                else
                                    nextCartItemsCount.value

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
                0 -> ShoppingCart(navController = navController)
                1 -> NextShoppingList(navController)
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


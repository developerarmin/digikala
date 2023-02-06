package ir.truelearn.androidmvvmsample.ui.screens.basket

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartItemCallbacks
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.util.Dimension
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@SuppressLint("RememberReturnType")
@Composable
fun ShoppingBasket(
    navController: NavController,
    viewModel: CartViewModel = hiltViewModel()
) {
    val currentCartItems = remember {
        mutableStateOf(emptyList<CartItem>())
    }
    val isLogin = remember {
        mutableStateOf(MainActivity.USER_TOKEN)
    }
    LaunchedEffect(true) {
        viewModel.currentCartItems.collectLatest { list ->
            currentCartItems.value = list
        }
    }
    val cartDetail = viewModel.cartDetail.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight()
                .padding(bottom = 166.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            item {
                if (isLogin.value == "null" || isLogin.value.isEmpty()) {
                    LoginOrRegisterState()
                }
            }

            if (currentCartItems.value.isEmpty()) {
                item {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                    ) {
                        EmptyBasketShopping()
                    }

                }
                item {
                    SuggestListSection()
                }

            } else {

                //display cart list
                items(currentCartItems.value) { item ->
                    BasketItem(item = item, object : CartItemCallbacks {
                        override fun onRemoveCartItem(cart: CartItem) {
                            viewModel.removeFromCart(cart)
                        }

                        override fun onIncreaseCartItem(
                            itemID: String,
                            newCount: Int
                        ) {
                            viewModel.increaseCartItem(itemID, newCount)
                        }

                        override fun onDecreaseCartItem(
                            itemID: String,
                            newCount: Int
                        ) {
                            viewModel.decreaseCartItem(itemID, newCount)
                        }

                        override fun onChangeStatusCart(
                            itemID: String,
                            newStatus: CartStatus
                        ) {
                            viewModel.changeStatusCart(itemID, newStatus)
                        }

                    })
                }
//
                item {
                    CartDetailCard(
                        cartDetail.value.totalPrice.toString(),
                        "0",
                        cartDetail.value.payablePrice.toString()
                    )
                }
            }
        }
//-------------------------------------------------------------------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 56.dp)
        ) {
            AnimatedVisibility(visible = currentCartItems.value.isNotEmpty()) {
                BuyProcessContinue(price = cartDetail.value.payablePrice.toString()) {
                    if (isLogin.value == "null" || isLogin.value.isEmpty()) {
                        navController.navigate(Screen.Profile.route)
                    } else {
                        navController.navigate(Screen.CartCheckout.route)
                    }
                }
            }
        }

    }
}








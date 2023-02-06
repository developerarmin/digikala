package ir.truelearn.androidmvvmsample.ui.screens.basket

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartItemCallbacks
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.collectLatest

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
                .padding(bottom = 56.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            item {
                if (isLogin.value == "null" || isLogin.value.isEmpty()) {
                    LoginOrRegisterState(navController)
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
                    CartItemCard(item = item, object : CartItemCallbacks {
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
                    CartPriceDetailSection(
                        cartDetail.value.totalPrice.toString(),
                        cartDetail.value.discount,
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








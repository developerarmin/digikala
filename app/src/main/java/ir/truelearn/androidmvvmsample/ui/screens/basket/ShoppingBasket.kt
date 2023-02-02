package ir.truelearn.androidmvvmsample.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.ui.screens.home.AmazingOfferSection
import ir.truelearn.androidmvvmsample.ui.screens.home.ProposalCardSection
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun ShoppingBasket(viewModel: CartViewModel = hiltViewModel()) {
    val currentCartItems = remember {
        mutableStateOf(emptyList<CartItem>())
    }
//todo is login Check properly
    val isLogin = false
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            if (!isLogin)
                LoginOrRegisterState()

            val refreshScope = rememberCoroutineScope()
            val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
            SwipeRefresh(state = swipeRefreshState, onRefresh = {
                refreshScope.launch {
                    //todo set refresh scope

                    //  viewModel.getAllDataFromServer()
//Log.e("3636", "call again Api!")
                }
            }) {

                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 140.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    LaunchedEffect(true) {
                        viewModel.currentCartItems.collectLatest { list ->
                            currentCartItems.value = list
                        }
                    }

                    if (currentCartItems.value.isEmpty()) {
                        EmptyBasketShopping()
                            SuggestListSection()
                    } else {
                        //cart list
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(.4f)
                        ) {
                            //display cart item
                        }
                    }
                }
            }
        }
//-------------------------------------------------------------------------------------------
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 56.dp)
//                .align(Alignment.BottomCenter)
//        ) {
//            if (true)
//                BuyProcessContinue("21990") {
//                    Log.e("3636", "ادامه فرایند خرید")
//                }
//        }
    }
}








package ir.truelearn.androidmvvmsample.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun ShoppingBasket(viewModel: HomeViewModel = hiltViewModel()) {

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column {
                if (true)
                    LoginOrRegisterState()

                val refreshScope = rememberCoroutineScope()
                val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
                SwipeRefresh(state = swipeRefreshState, onRefresh = {
                    refreshScope.launch {
                        viewModel.getAllDataFromServer()
                        Log.e("3636", "call again Api!")
                    }
                }) {

                    Column(
                        modifier = Modifier
                            // .background(Color.Cyan)
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(bottom = 140.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        LaunchedEffect(true) {
                            viewModel.getAllDataFromServer()
                            Log.e("3636", "call Api!")
                        }

                        if (true)
                            EmptyBasketShopping()
                    }
                }
            }
//-------------------------------------------------------------------------------------------
            Row(
                modifier = Modifier
                    //.weight(1f, false) // in column be work and be in bottom
                    .fillMaxWidth()
                    .padding(bottom = 56.dp)
                    .align(Alignment.BottomCenter)
            ) {
                if (true)
                BuyProcessContinue("23652") {
                    Log.e("3636", "ادامه فرایند خرید")
                }
            }
        }
    }








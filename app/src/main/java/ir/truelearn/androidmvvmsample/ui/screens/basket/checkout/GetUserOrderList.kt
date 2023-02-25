package ir.truelearn.androidmvvmsample.ui.screens.basket.checkout

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
  import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.data.model.address.UserAddressResponse
import ir.truelearn.androidmvvmsample.data.model.basket.UserOrdersResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.screens.basket.address.CartShippingAddressAndTime
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.viewmodel.AddressListViewModel
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun GetUserOrderList(
    cartViewModel: CartViewModel
) {
    Log.e("36360", "GetUserOrderList start ")
    val orderList = remember { mutableStateOf<List<UserOrdersResponse>>(emptyList()) }
    var loading1 by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = true) {
        cartViewModel.getUserOrderList(MainActivity.MY_TOKEN)
        cartViewModel.userOrderList.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let { list ->
                        orderList.value = list
                        Log.e("36361", "from GetUserOrderlist:\n${result.data} ")
                    }
                    loading1 = false
                }
                is NetworkResult.Error -> {
                    loading1 = false

                    Log.e("36361", "from GetUserOrderlist: error:\n${result.message} ")
                }
                is NetworkResult.Loading -> {
                    loading1 = true

                }
            }
        }
    }

    if (loading1) {
            Loading3Dots(isDark = false)
    } else {

       orderList.value.forEach{
           cartViewModel.GetOrderState.value = false
           cartViewModel.orderId.value = it._id
           cartViewModel.transactionId.value = it.transactionId
           Log.d("3636_2", "id:  ${cartViewModel.orderId.value }  tr: ${cartViewModel.transactionId.value } ")

       }
    }
}
package ir.truelearn.androidmvvmsample.ui.screens.basket.checkout

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.App
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.basket.ConfirmPurchase
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.component.WaitingDialog
import ir.truelearn.androidmvvmsample.ui.component.displayToast
import ir.truelearn.androidmvvmsample.ui.theme.digikalaRed
import ir.truelearn.androidmvvmsample.ui.theme.roundedShape
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper
import ir.truelearn.androidmvvmsample.util.ZarinpalPurchase
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun ConfirmPurchaseScreen(
    navController: NavController,
) {
    val context = LocalContext.current
    val backStackEntry = remember {
        navController.getBackStackEntry(Screen.CartCheckout.route)
    }
    val cartViewModel: CartViewModel = hiltViewModel(backStackEntry)
    var message by remember { mutableStateOf("") }
    var waitingDialogState by remember { mutableStateOf(false) }
    // add new order
    LaunchedEffect(key1 = true) {
        cartViewModel.orderDetail.value?.let { cartViewModel.addNewOrder(it) }
        cartViewModel.orderResponse.collectLatest { result ->
            result?.let {
                when (result) {
                    is NetworkResult.Success -> {
                        displayToast(context, result.message)
                        waitingDialogState = false
                        Log.d("level8", "message:${result.message} ")
                        Log.d("level8", "data:${result.data} ")
                        result.data?.let {
                            //clear shopping cart
                            waitingDialogState = true
                            cartViewModel.confirmPurchase(
                                ConfirmPurchase(
                                    result.data,
                                    MainActivity.MY_TOKEN,
                                    "342"
                                )
                            )
                            cartViewModel.clearShoppingCart()

//                            ZarinpalPurchase.purchase(
//                                App.getCurrentActivity(),
//                                2000,
//                                "test"
//                            ) { transactionID ->
//
//                            }
                        }

                    }
                    is NetworkResult.Error -> {
                        waitingDialogState = false
                        Log.e("level8", "error:${result.message} ")
                        displayToast(context, result.message)
                    }

                    is NetworkResult.Loading -> {
                        waitingDialogState = true
                    }
                }
            }
        }
    }
    //purchase response
    LaunchedEffect(key1 = true) {
        cartViewModel.purchaseResponse.collectLatest { result ->
            result?.let {
                when (result) {
                    is NetworkResult.Success -> {
                        message = result.message.toString()
                        Log.d("level8", "purchase message:$message ")
                        waitingDialogState = false
                    }
                    is NetworkResult.Error -> {
                        waitingDialogState = false
                        message = result.message.toString()
                    }

                    is NetworkResult.Loading -> {
                        waitingDialogState = true
                    }
                }
            }

        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                MaterialTheme.spacing.extraSmall,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = message)
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "وضعیت سفارش")
            Text(text = message)
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(id = R.string.payable_price))
            var price = "..."
            cartViewModel.orderDetail.value?.let {
                price = it.orderTotalPrice.toString()
            }
            Text(text = DigitHelper.digitBySeparator(DigitHelper.digitByLocate(price)))
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
        Button(
            onClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) {
                        inclusive = true
                    }
                }
            },
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.digikalaRed),
            shape = MaterialTheme.roundedShape.small,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        MaterialTheme.spacing.small,
                    ),
                text = stringResource(id = R.string.return_to_home_page),
                color = MaterialTheme.colors.digikalaRed,
                fontWeight = FontWeight.Bold,
            )

        }
    }
    if (waitingDialogState) {
        WaitingDialog() {
            waitingDialogState = it
        }
    }
    BackHandler {
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Home.route) {
                inclusive = true
            }
        }
    }
}
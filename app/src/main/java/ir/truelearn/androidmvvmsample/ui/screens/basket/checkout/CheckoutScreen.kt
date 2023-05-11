package ir.truelearn.androidmvvmsample.ui.screens.basket.checkout


import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.gson.Gson
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.MainActivity.Companion.USER_TOKEN
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.address.UserAddressResponse
import ir.truelearn.androidmvvmsample.data.model.basket.ConfirmPurchase
import ir.truelearn.androidmvvmsample.data.model.basket.OrderDetail
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.component.displayToast
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.component.WaitingDialog
import ir.truelearn.androidmvvmsample.ui.screens.basket.BuyProcessContinue
import ir.truelearn.androidmvvmsample.ui.screens.basket.CartInfoBox
import ir.truelearn.androidmvvmsample.ui.screens.basket.address.CartShippingAddressAndTime
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.Dimension
import ir.truelearn.androidmvvmsample.viewmodel.AddressListViewModel
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CheckoutScreen(
    navController: NavHostController,
    cartViewModel: CartViewModel = hiltViewModel()
) {
    var waitingDialogState by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val viewModel: AddressListViewModel = viewModel(LocalContext.current as ComponentActivity)
    val addressList = remember {
        mutableStateOf<List<UserAddressResponse>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
// set default Address
    LaunchedEffect(key1 = true) {
        if (viewModel.defaultAddress.value == null) {
            Log.d("level5", "token:${USER_TOKEN} ")
            viewModel.getAddressList(USER_TOKEN)
        }
        viewModel.userAddressList.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let { list ->
                        addressList.value = list
                        if (viewModel.defaultAddress.value == null && list.isNotEmpty()) {
                            viewModel.setDefaultAddress(addressList.value[0])
                        }
                    }
                    loading = false
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.e("level1", "CheckoutScreen: error=${result.message} ")
                    displayToast(context, result.message)
                }

                is NetworkResult.Loading -> {
                    loading = true
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            //top bar
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(MaterialTheme.spacing.medium),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back2),
                        contentDescription = "",
                        modifier = Modifier
                            .clickable {
                                navController.popBackStack()
                            }
                            .width(Dimension.width(15f).dp)
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(Dimension.width(85f).dp),
                        text = "آدرس و زمان ارسال",
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.h2,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.darkText,
                        //fontFamily = font_bold,
                    )
                }

                Spacer(
                    modifier = Modifier.fillMaxWidth()
                        .height(MaterialTheme.spacing.extraSmall)
                        .background(MaterialTheme.colors.searchBarBg)
                )

                if (loading) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colors.searchBarBg)
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Loading3Dots(isDark = false)
                    }
                } else {
                    CartShippingAddressAndTime(
                        navController = navController
                    ) {
                        navController.navigate(Screen.selectAddress.route)//AddressListScreen
                    }
                }


            }

            Spacer(
                modifier = Modifier.fillMaxWidth()
                    .height(MaterialTheme.spacing.small)
                    .background(MaterialTheme.colors.searchBarBg)
            )

            //-----------------------------------------------------------------------------
// display order post list here
            DeliveryMethodSection()
            //------------------------------------------------------------------

            CartInfoBox(
                msg = "شما می توانید فاکتور خرید خود را پس از تحویل سفارش از بخش جزییات سفارش در حساب کاربری خود دریافت نمایید.",
                icon = painterResource(id = R.drawable.info)
            )
            CheckoutPriceDetails()
        }
//-------------------------------------------------------------------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 1.dp)
                .align(Alignment.BottomCenter)
        ) {


            val cartDetail = cartViewModel.cartDetail.collectAsState()
            BuyProcessContinue(
                price = (cartDetail.value.payablePrice + cartDetail.value.shippingCost).toString(),
                flag = "",
                timeState = false
            ) {
                val orderProductsList = cartViewModel.getOrderList()
                val newOrder = OrderDetail(
                    orderAddress = viewModel.defaultAddress.value!!.address,
                    orderDate = viewModel.defaultAddress.value!!.updatedAt,
                    orderProducts = orderProductsList,
                    orderTotalDiscount = cartDetail.value.discount,
                    orderTotalPrice = cartDetail.value.payablePrice + cartDetail.value.shippingCost,
                    orderUserName = viewModel.defaultAddress.value!!.name,
                    orderUserPhone = viewModel.defaultAddress.value!!.phone,
                    token = USER_TOKEN
                )
                cartViewModel.orderDetail.value = newOrder
                navController.navigate(Screen.ConfirmPurchase.route)
//                waitingDialogState = true
//                cartViewModel.addNewOrder(cartOrderDetail = newOrder)
            }
        }



        if (showBottomSheet.value) Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) { MyBottomSheet() }

    }
    if (waitingDialogState) {
        WaitingDialog() {
            waitingDialogState = it
        }
    }

}






package ir.truelearn.androidmvvmsample.ui.screens.basket.checkout


import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
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
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.address.UserAddressResponse
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartOrderDetail
import ir.truelearn.androidmvvmsample.data.model.basket.OrderProduct
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.screens.basket.BuyProcessContinue
import ir.truelearn.androidmvvmsample.ui.screens.basket.CartInfoBox
import ir.truelearn.androidmvvmsample.ui.screens.basket.address.CartShippingAddressAndTime
import ir.truelearn.androidmvvmsample.ui.screens.basket.address.InitSelectableAddressList
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.font_bold
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.Dimension
import ir.truelearn.androidmvvmsample.viewmodel.AddressListViewModel
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.collectLatest


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CheckoutScreen(
    navController: NavHostController,
    cartViewModel: CartViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val viewModel: AddressListViewModel = viewModel(LocalContext.current as ComponentActivity)
    val addressList = remember {
        mutableStateOf<List<UserAddressResponse>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = true) {
        if (viewModel.defaultAddress.value == null) {
            Log.d("level2", "CheckoutScreen: ")
            viewModel.getAddressList(MainActivity.MY_TOKEN)
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
                    Toast.makeText(
                        context,
                        "from CheckoutScreen:\n" + result.message,
                        Toast.LENGTH_SHORT
                    ).show()

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
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.darkText,
                        fontFamily = font_bold,
                    )
                }
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
                        Log.d("level3", "go to seelcted addres: ")
                        navController.navigate(Screen.selectAddress.route)//AddressListScreen
                    }
                }


            }
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


            val orderProductsList = getOrderList(cartViewModel)


            val cartDetail = cartViewModel.cartDetail.collectAsState()
            BuyProcessContinue(
                price = (cartDetail.value.payablePrice + cartDetail.value.shippingCost).toString(),
                flag = "",
                timeState = false
            ) {
                val newOrder = CartOrderDetail(
                    orderAddress = viewModel.defaultAddress.value!!.address,
                    orderDate = viewModel.defaultAddress.value!!.updatedAt,
                    orderProducts = orderProductsList,
                    orderTotalDiscount = cartDetail.value.discount,
                    orderTotalPrice = cartDetail.value.payablePrice + cartDetail.value.shippingCost,
                    orderUserName = viewModel.defaultAddress.value!!.name,
                    orderUserPhone = viewModel.defaultAddress.value!!.phone,
                    token = MainActivity.MY_TOKEN
                )
                cartViewModel.addNewOrder(cartOrderDetail = newOrder)
            }
        }
    }

}


@Composable
fun getOrderList(viewModel: CartViewModel): List<OrderProduct> {

    val currentCartItems = remember {
        mutableStateOf(emptyList<CartItem>())
    }
    LaunchedEffect(true) {
        viewModel.currentCartItems.collectLatest { list ->
            currentCartItems.value = list
        }
    }
            val updatedList = currentCartItems.value.map { item ->
                OrderProduct(
                    count = item.count,
                    discountPercent = item.discountPercent,
                    image = item.image,
                    name = item.name,
                    price = item.price,
                    productId = item.itemID,
                    seller = item.seller
                )
            }

    return updatedList

}

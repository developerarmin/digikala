package ir.truelearn.androidmvvmsample.ui.screens.checkout


import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.PersonInfo
import ir.truelearn.androidmvvmsample.data.model.basket.TokenBody
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.screens.basket.BuyProcessContinue
import ir.truelearn.androidmvvmsample.ui.screens.basket.CartInfoBox
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.font_bold
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.Dimension
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.collectLatest


@Composable
fun CheckoutScreen(
    navController: NavHostController,
    viewModel: CartViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val personInfoList = remember {
        mutableStateOf<List<PersonInfo>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    val determineTime = false
    val isLogin = false
    LaunchedEffect(key1 = true) {
        viewModel.getUserAddress(MainActivity.USER_TOKEN)
        viewModel.personInfoList.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let { list ->
                        personInfoList.value = list
                    }
                    loading = false
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.d("level1", "CheckoutScreen: error=${result.message} ")
                    Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()

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
            if (!isLogin)

            //top bar
                Column() {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(MaterialTheme.spacing.medium),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {

                        Column(
                            modifier = Modifier
                                .width(Dimension.width(15f).dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top,
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_back2),
                                contentDescription = "",
                                modifier = Modifier
                                    .clickable {
                                        navController.popBackStack()
                                    }
                            )

                        }

                        Spacer(modifier = Modifier.width(5.dp))

                        Column(
                            modifier = Modifier
                                .width(Dimension.width(85f).dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center,
                        ) {

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = "آدرس و زمان ارسال",
                                textAlign = TextAlign.Start,
                                style = MaterialTheme.typography.h4,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colors.darkText,
                                fontFamily = font_bold,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

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
                        var address = "not set"
                        var name = "not set"
                        if (personInfoList.value.isNotEmpty()
                        ) {
                            address = personInfoList.value[0].address
                            name = personInfoList.value[0].address
                        }
                        CartShippingAddressAndTime(
                            navController = navController,
                            address = address,
                            name = name
                        )
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
            val cartDetail = viewModel.cartDetail.collectAsState()
            BuyProcessContinue(
                price = (cartDetail.value.payablePrice + cartDetail.value.shippingCost).toString(),
                flag = "",
                timeState = determineTime
            ) {
                Log.e("3636", "ادامه فرایند خرید")
            }
        }
    }

}



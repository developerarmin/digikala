package ir.truelearn.androidmvvmsample.ui.screens.checkout


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.screens.basket.BuyProcessContinue
import ir.truelearn.androidmvvmsample.ui.screens.basket.CartInfoBox
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.font_bold
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.Dimension
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel


@Composable
fun CheckoutScreen(
    navController: NavHostController,
    viewModel: CartViewModel = hiltViewModel()
) {
    val determineTime = false
    val isLogin = false

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
                    CartShippingAddressAndTime(
                        address = "اردبیل، اردبیل، اردبیل - خیابان شهید باکری - خیابان فردوسی۱ - نبش کوچه فردوسی۱ - پلاک ۹",
                        name = "مهدی ایمانی"
                    )


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



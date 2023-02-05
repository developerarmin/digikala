package ir.truelearn.androidmvvmsample.ui.screens.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.font_standard
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DeliveryMethodSection(
    shippingConst: String = "20000"
) {
//    val currentCartItems = remember {
//        mutableStateOf(emptyList<CartItem>())
//    }
//    LaunchedEffect(true) {
//        viewModel.currentCartItems.collectLatest { list ->
//            currentCartItems.value = list
//        }
//    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 4.dp),
        horizontalAlignment = End
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "شیوه و زمان ارسال",
            fontWeight = FontWeight.Bold,
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 8.dp),
                horizontalAlignment = End
            ) {
                Text(
                    text = "مرسوله 1 از 1",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.darkText,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "4 کالا")
//                    Icon(painter = painterResource(id = ), contentDescription = "")
                    Text(text = "ارسال عادی")
//                    Icon(painter = painterResource(id = ), contentDescription = "")
                }
                LazyRow {
                    items(5){
                        CheckoutProductCard(item = null)
                    }
//                    items(currentCartItems.value) { item ->
//                        CheckoutProductCard(item = item)
//                    }
                }
                Text(text = "آماده ارسال")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier,
                        text = "هزینه ارسال",
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray,
                        fontFamily = font_standard,
                    )
                    Row() {
                        Text(
                            text = DigitHelper.digitByLocate(shippingConst),
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )

                        Image(
                            painter = painterResource(id = R.drawable.toman),
                            contentDescription = "",
                            modifier = Modifier
                                .size(MaterialTheme.spacing.semiLarge)
                                .padding(horizontal = MaterialTheme.spacing.extraSmall)
                        )

                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowLeft, contentDescription = "",
                        modifier = Modifier,
                        colorResource(id = R.color.iconColor)
                    )


                    Text(
                        text = "انتخاب زمان ارسال",
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.h6,
                        color = colorResource(id = R.color.iconColor)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Display1() {
    DeliveryMethodSection()
}
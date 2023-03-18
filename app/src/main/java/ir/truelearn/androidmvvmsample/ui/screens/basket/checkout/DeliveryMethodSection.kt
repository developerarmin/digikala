package ir.truelearn.androidmvvmsample.ui.screens.basket.checkout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DeliveryMethodSection(
    shippingConst: String = "20000",
    viewModel: CartViewModel = hiltViewModel()
) {
    val currentCartItems = remember {
        mutableStateOf(emptyList<CartItem>())
    }
    LaunchedEffect(true) {
        viewModel.currentCartItems.collectLatest { list ->
            currentCartItems.value = list
        }
    }
    var marsoleh = ""
    val x1 = DigitHelper.digitByLocate("2")
    var x2 = DigitHelper.digitByLocate("3")
    marsoleh = "مرسوله ${x1} از ${x2}  "

    val sendingType = "ارسال عادی"
    val objectCoun = DigitHelper.digitByLocate("4")
    val readyToSend = "اماده ارسال"

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        //.padding(MaterialTheme.spacing.extraSmall),
        horizontalAlignment = End
    ) {
        Text(
            modifier = Modifier
                .padding(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.small
                )
                .align(Alignment.Start),
            text = String.format(stringResource(id = R.string.deliveryAndTimeMethod)),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.subtitle2,
            color = Color.Black,
            fontFamily = font_bold,

            )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = MaterialTheme.spacing.medium,
                    horizontal = MaterialTheme.spacing.small,
                ),
            shape = RoundedCornerShape(3.dp),
            elevation = 5.dp,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = MaterialTheme.spacing.small
                    ),
                horizontalAlignment = End
            ) {
                Text(
                    text = marsoleh,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.Black,
                    fontFamily = font_bold,
                    modifier = Modifier
                        .align(Alignment.Start)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(20.dp),
                        tint = MaterialTheme.colors.RedColor,
                        painter = painterResource(id = R.drawable.truck_red),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
                    Text(
                        text = sendingType,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.overline,
                        color = MaterialTheme.colors.RedColor,
                        fontFamily = font_bold
                    )

                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))
                    Text(
                        text = " ${objectCoun} کالا ",
                        Modifier.padding(MaterialTheme.spacing.small),
                        style = MaterialTheme.typography.caption,
                        color = Color.Gray,
                        fontFamily = font_bold
                    )
                }
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(currentCartItems.value) { item ->
                        CheckoutProductCard(item = item)
                    }
                }
                Text(
                    text = readyToSend,
                    style = MaterialTheme.typography.caption,
                    color = Color.Gray,
                    fontFamily = font_bold,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(vertical = MaterialTheme.spacing.medium),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = MaterialTheme.spacing.medium),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = String.format(stringResource(id = R.string.choseTimeSend)),
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.caption,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.CartCyan,
                        fontFamily = font_standard,
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "",
                        tint = MaterialTheme.colors.CartCyan,
                        modifier = Modifier
                            .size(12.dp, 12.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}


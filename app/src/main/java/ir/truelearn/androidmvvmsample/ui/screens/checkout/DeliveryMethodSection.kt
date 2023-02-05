package ir.truelearn.androidmvvmsample.ui.screens.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.font_medium
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
            .padding(
                top = MaterialTheme.spacing.small,
                bottom = MaterialTheme.spacing.small,
                start = MaterialTheme.spacing.small,
                end = MaterialTheme.spacing.small
            ),
        horizontalAlignment = End
    ) {
        Text(
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.mediumTwo),
            text = String.format(stringResource(id = R.string.deliveryAndTimeMethod)),
            fontWeight = FontWeight.Bold,
            fontFamily = font_medium
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = MaterialTheme.spacing.medium,
                    horizontal = MaterialTheme.spacing.small
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = MaterialTheme.spacing.medium,
                        horizontal = MaterialTheme.spacing.medium
                    ),
                horizontalAlignment = End
            ) {
                Text(
                    text = String.format(stringResource(id = R.string.consignment)),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.darkText,
                    fontFamily = font_medium
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = String.format(stringResource(id = R.string.commodity2))
                        ,Modifier.padding(MaterialTheme.spacing.small),
                    fontFamily = font_medium)
                    Icon(modifier = Modifier
                        .size(8.dp),
                        painter = painterResource(id = R.drawable.ic_baseline_circle_24),
                        contentDescription = "")
                    Text(text = String.format(stringResource(id = R.string.normalDelivery)),
                        Modifier.padding(MaterialTheme.spacing.small),
                    fontFamily = font_medium,)
                    Icon(modifier = Modifier
                        .size(20.dp),
                        painter = painterResource(id = R.drawable.delivery_truck),
                        contentDescription = "")
                }
                LazyRow {
                    items(5){
                        CheckoutProductCard(item = null)
                    }
//                    items(currentCartItems.value) { item ->
//                        CheckoutProductCard(item = item)
//                    }
                }
                Text(text = String.format(stringResource(id = R.string.readyToSend)),
                fontFamily = font_medium)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = MaterialTheme.spacing.small),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End) {
                        Image(
                            painter = painterResource(id = R.drawable.toman),
                            contentDescription = "",
                            modifier = Modifier
                                .size(MaterialTheme.spacing.semiLarge)
                                .padding(horizontal = MaterialTheme.spacing.extraSmall)
                        )
                        Text(
                            text = DigitHelper.digitByLocate(shippingConst),
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                        Text(
                            modifier = Modifier,
                            text = String.format(stringResource(id = R.string.costSend)),
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                            fontFamily = font_standard
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
                        text = String.format(stringResource(id = R.string.choseTimeSend)),
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
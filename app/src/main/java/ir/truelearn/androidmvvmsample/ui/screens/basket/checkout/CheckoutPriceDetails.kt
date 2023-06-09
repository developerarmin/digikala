package ir.truelearn.androidmvvmsample.ui.screens.basket.checkout

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.screens.basket.DigiKlabScore
import ir.truelearn.androidmvvmsample.ui.theme.font_medium
import ir.truelearn.androidmvvmsample.ui.theme.font_standard
import ir.truelearn.androidmvvmsample.ui.theme.infoBox
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel

@Composable
fun CheckoutPriceDetails(viewModel: CartViewModel = hiltViewModel()) {

    val cartDetail = viewModel.cartDetail.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = MaterialTheme.spacing.medium,
                horizontal = MaterialTheme.spacing.medium,
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MaterialTheme.spacing.mediumTwo),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier,
                text = "جزئیات قیمت",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = font_medium,

                )
            Text(
                modifier = Modifier,
                text = "${DigitHelper.digitByLocate(3.toString())} کالا ",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                fontFamily = font_standard,
            )
        }

        InitPriceRow(title = "قیمت کالا ها", price = cartDetail.value.totalPrice.toString())
        //---------------------------------------------------------------------------------
        InitPriceRow(
            title = "تخفیف کالا ها",
            price = cartDetail.value.totalPrice.toString(),
            discount = cartDetail.value.discount.toString()
        )
        //---------------------------------------------------------------------------------
        InitPriceRow(title = "جمع سبد خرید", price = cartDetail.value.payablePrice.toString())

        Divider(
            color = infoBox,
            thickness = 1.dp,
            modifier = Modifier
                .padding(
                    vertical = MaterialTheme.spacing.mediumTwo,
                    horizontal = MaterialTheme.spacing.medium
                )
        )
        InitPriceRow(title = "هزینه ارسال", price = cartDetail.value.shippingCost.toString())
        //---------------------------------------------------------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                painter = painterResource(id = R.drawable.circle),
                contentDescription = "",
                tint = Color.Gray,
                modifier = Modifier
                    .size(5.dp, 15.dp)
                    .padding(top = 9.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "محاسبه شده بر اساس آدرس، زمان تحویل، وزن و حجم مرسوله شما",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                fontFamily = font_standard,
            )
        }
        InitPriceRow(
            title = "مبلغ قابل پرداخت",
            price = (cartDetail.value.payablePrice + cartDetail.value.shippingCost).toString()
        )
        DigiKlabScore(viewModel.digiKlabScore)

    }

}
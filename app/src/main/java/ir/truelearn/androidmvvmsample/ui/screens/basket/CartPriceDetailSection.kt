package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.screens.checkout.InitPriceRow
import ir.truelearn.androidmvvmsample.ui.theme.infoBox
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitBySeparator

@Composable
fun CartPriceDetailSection(totalPrice: String, discount: Int, payablePrice: String) {

    Column(modifier = Modifier.padding(MaterialTheme.spacing.medium)) {
        Row() {
            Text(
                text = stringResource(R.string.basket_summary),
                fontFamily = FontFamily(Font(R.font.iranyekanbold)),
                style = TextStyle(
                    textDirection = TextDirection.ContentOrRtl,
                    color = Color.Black
                ), fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = String.format(
                    stringResource(R.string.count_product_cart),
                    digitBySeparator("4")
                ),
                fontFamily = FontFamily(Font(R.font.iranyekan)),
                style = TextStyle(
                    textDirection = TextDirection.ContentOrRtl,
                    color = Color.Gray
                )
            )
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.semiLarge))
        InitPriceRow(title = "قیمت کالا ها", price = totalPrice)
        //---------------------------------------------------------------------------------


        InitPriceRow(title = "تخفیف کالا ها", price = totalPrice, discount = discount.toString())
        //---------------------------------------------------------------------------------
        InitPriceRow(title = "جمع سبد خرید", price = payablePrice)


        Divider(
            color = infoBox,
            thickness = 1.dp,
            modifier = Modifier
                .padding(
                    vertical = MaterialTheme.spacing.mediumTwo,
                    horizontal = MaterialTheme.spacing.medium
                )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.dot_bullet),
                fontFamily = FontFamily(Font(R.font.iranyekan)),
                style = TextStyle(
                    textDirection = TextDirection.ContentOrRtl,
                    color = Color.Gray,
                    fontSize = 32.sp,
                ),
                modifier = Modifier.padding(end = MaterialTheme.spacing.extraSmall)/*.weight(0.05f)*/
            )
            Text(
                text = stringResource(R.string.shipping_cost_alert),
                fontFamily = FontFamily(Font(R.font.iranyekan)),
                style = TextStyle(
                    textDirection = TextDirection.ContentOrRtl,
                    color = Color.Gray
                ), modifier = Modifier.weight(1f)
            )
        }

        DigiKlabScore("150")


    }
    CartInfoBox(
        msg = "کالاهای موجود در سبد شما ثبت و رزرو نشده‌اند، برای ثبت سفارش مراحل بعدی را تکمیل نمایید ",
        icon = painterResource(id = R.drawable.info)
    )
}


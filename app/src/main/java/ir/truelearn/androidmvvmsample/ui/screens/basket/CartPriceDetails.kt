package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper
import ir.truelearn.androidmvvmsample.util.Dimension

@Composable
fun CartPriceDetails(
    msg: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
//        .background(Color.LightGray)
            .padding(
                top = MaterialTheme.spacing.medium,
                bottom = MaterialTheme.spacing.small,
                start = MaterialTheme.spacing.medium,
                end = MaterialTheme.spacing.medium
            ),

        ) {
        Row(
            modifier = Modifier

                .fillMaxWidth()
                .padding(

                    bottom = MaterialTheme.spacing.mediumTwo

                )
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row() {
                Text(
                    modifier = Modifier,
                    text = "جزئیات قیمت",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontFamily = font_medium,

                )
            }
            Row() {
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
        }

        //---------------------------------------------------------------------------------

        CartPriceRow(title = "قیمت کالا ها", price = 470000)
        //---------------------------------------------------------------------------------
        CartPriceRow(title = "تخفیف کالا ها", price = 225000, discount = 48)
        //---------------------------------------------------------------------------------
        CartPriceRow(title = "جمع سبد خرید", price = 245000)

        Divider(
            color = infoBox,
            thickness = 1.dp,
            modifier = Modifier
                .padding(
                    top = MaterialTheme.spacing.mediumTwo,
                    bottom = MaterialTheme.spacing.mediumTwo,
                    start = MaterialTheme.spacing.medium,
                    end = MaterialTheme.spacing.medium
                )

        )

        CartPriceRow(title = "هزینه ارسال", price = 29000)
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
                    modifier = Modifier.size(5.dp, 15.dp)
                        .padding(top =9.dp)

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
        CartPriceRow(title = "مبلغ قابل پرداخت", price = 245000)

        Divider(
            color = infoBox,
            thickness = 1.dp,
            modifier = Modifier
                .padding(
                    top = MaterialTheme.spacing.mediumTwo,
                    bottom = MaterialTheme.spacing.mediumTwo,
                    start = MaterialTheme.spacing.medium,
                    end = MaterialTheme.spacing.medium
                )

        )
        //---------------------------------------------------------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.digi_score),
                    contentDescription = "",
                    modifier = Modifier.size(18.dp, 18.dp)
                )
                Spacer(modifier = Modifier.width(Dimension.width(1f).dp))
                Text(
                    text = "امتیاز دیجی‌کلاب",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    fontFamily = font_standard,
                )
            }

            Row() {
                Text(
                    modifier = Modifier,
                    text = "${DigitHelper.digitByLocate(25.toString())} امتیاز ",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }
        }
        //---------------------------------------------------------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(   modifier = Modifier
                .padding(
                    top = MaterialTheme.spacing.medium,
                    bottom = MaterialTheme.spacing.medium,
                    start = MaterialTheme.spacing.mediumTwo,
                    end = MaterialTheme.spacing.mediumTwo
                )) {
                Text(
                    modifier = Modifier,
                    text = "بعد از پایان مهلت مرجوعی، برای دریافت امتیاز به صفحه ماموریت‌های کلابی سر بزنید.",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    fontFamily = font_standard,
                )
            }
        }
        //---------------------------------------------------------------------------------
        //متن
        //---------------------------------------------------------------------------------

        //---------------------------------------------------------------------------------
    }

}
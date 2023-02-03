package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.RedColor
import ir.truelearn.androidmvvmsample.util.DigitHelper
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitByLocate
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitBySeparator

@Preview
@Composable
fun CartDetailCard() {
    val countProductCart by remember {
        mutableStateOf(1)
    }
    val discountPercent by remember {
        mutableStateOf(0)
    }
    val discountPrice by remember {
        mutableStateOf(6)
    }
    val totalShoppingCart by remember {
        mutableStateOf(18670)
    }
    val productPrice by remember {
        mutableStateOf(18676)
    }
    Column(modifier = Modifier.padding(16.dp)) {
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
                    digitByLocate(countProductCart.toString())
                ),
                fontFamily = FontFamily(Font(R.font.iranyekan)),
                style = TextStyle(
                    textDirection = TextDirection.ContentOrRtl,
                    color = Color.Gray
                )
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(R.string.products_price),
                fontFamily = FontFamily(Font(R.font.iranyekan)),
                style = TextStyle(
                    textDirection = TextDirection.ContentOrRtl,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = digitByLocate(digitBySeparator(productPrice.toString())),
                fontFamily = FontFamily(Font(R.font.iranyekan)),
                style = TextStyle(
                    textDirection = TextDirection.ContentOrRtl,
                    color = Color.Black
                )
            )
            Image(
                painter = painterResource(id = R.drawable.toman),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(R.string.products_discount),
                fontFamily = FontFamily(Font(R.font.iranyekan)),
                style = TextStyle(
                    textDirection = TextDirection.ContentOrRtl,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = "(${digitByLocate(discountPercent.toString())}٪)${digitByLocate(discountPrice.toString())}",
                fontFamily = FontFamily(Font(R.font.iranyekan)),
                style = TextStyle(
                    textDirection = TextDirection.ContentOrRtl,
                    color = MaterialTheme.colors.RedColor
                )
            )
            Image(
                painter = painterResource(id = R.drawable.toman),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(
                    MaterialTheme.colors.RedColor
                )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.total_shopping_cart),
                fontFamily = FontFamily(Font(R.font.iranyekan)),
                style = TextStyle(
                    textDirection = TextDirection.ContentOrRtl,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = digitByLocate(digitBySeparator(totalShoppingCart.toString())),
                fontFamily = FontFamily(Font(R.font.iranyekan)),
                style = TextStyle(
                    textDirection = TextDirection.ContentOrRtl,
                    color = Color.Black
                )
            )
            Image(
                painter = painterResource(id = R.drawable.toman),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row() {
                Text(
                    text = "•",
                    fontFamily = FontFamily(Font(R.font.iranyekan)),
                    style = TextStyle(
                        textDirection = TextDirection.ContentOrRtl,
                        color = Color.Gray,
                        fontSize = 32.sp,
                    ), modifier = Modifier.padding(end = 16.dp)
                )

            }
            Row() {
                Text(
                    text = stringResource(R.string.shipping_cost_alert),
                    fontFamily = FontFamily(Font(R.font.iranyekan)),
                    style = TextStyle(
                        textDirection = TextDirection.ContentOrRtl,
                        color = Color.Gray
                    )
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
    Divider(modifier = Modifier.background(Color.LightGray))
}


package ir.truelearn.androidmvvmsample.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.R

@Composable
fun AmazingItem() {
    val categoryTitle = "شگفت انگیز اختصاصی اپ"
    val productTitle =
        "دوربین فیلمبرداری ورزشی اینستا 360 مدل one Rss"
    val status = "موجود در انبار دیجی کالا"
    val previousPrice = "100,000"
    val discount = 43
    val currentPrice = "33,000"

    Card(
        modifier = Modifier
            .width(170.dp)
            .padding(top = 16.dp, bottom = 16.dp, start = 4.dp, end = 4.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = 4.dp
    ) {
        //root
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp)
        ) {

            //title && image
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp)
            ) {
                Text(
                    text = categoryTitle,
                    style = MaterialTheme.typography.body2,
                    color = colorResource(id = R.color.red_amazing),
                )
                Spacer(modifier = Modifier.height(10.dp))
                //image
                Image(
                    painterResource(id = R.drawable.place_holder),
                    contentDescription = "product image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            //info
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = productTitle,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(10.dp))
                //status
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = status,
                        style = MaterialTheme.typography.body2,
                        color = Color.Gray,
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
//price
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column() {
                        Text(
                            text ="$currentPrice ${stringResource(id = R.string.price_unit)}",
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(
                            text = previousPrice,
                            color = Color.LightGray,
                            style = MaterialTheme.typography.body2,
                            textDecoration = TextDecoration.LineThrough,
                        )
                    }

                    Box(
                        modifier = Modifier
                            .width(32.dp)
                            .height(24.dp)
                            .background(
                                color = colorResource(id = R.color.red_dark),
                                shape = CircleShape
                            )
                            .wrapContentWidth(Alignment.CenterHorizontally)
                            .wrapContentHeight(Alignment.CenterVertically),

                        ) {
                        Text(
                            text = "${discount}%",
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                            ,
                            fontSize = 10.sp
                        )
                    }
                }
            }


        }
    }
}
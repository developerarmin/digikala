package ir.truelearn.androidmvvmsample.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.Dimension


@Composable
fun CartReceiveInPersonAddress(

    action: () -> Unit = {},


    ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
            .clickable { Log.e("3636", "chart checkout") },
        shape = RoundedCornerShape(7.dp),
        elevation = 1.dp,
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.CartCyan),

        ) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//
//            Image(
//                painter = painterResource(id = R.drawable.map_address_bg),
//                contentDescription = null,
//                contentScale = ContentScale.None,
//                modifier = Modifier.matchParentSize()
//            )

        Column(
            modifier = Modifier
                .background(infoBox)
        ) {
            Row(
                modifier = Modifier
                    .padding(
                        top = MaterialTheme.spacing.medium,
                        bottom = MaterialTheme.spacing.small,
                        start = MaterialTheme.spacing.medium,
                        end = MaterialTheme.spacing.medium
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .width(Dimension.width(80f).dp),
                )
                {
                    Text(
                        modifier = Modifier,
                        text = "مراکز دریافت حضوری نزدیک این آدرس",
                        textAlign = TextAlign.Start,
                        color = Color.Black,
                        style = MaterialTheme.typography.h6,
                        fontFamily = font_medium,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Row(
                    modifier = Modifier
                        .width(Dimension.width(10f).dp), horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(12.dp, 12.dp)


                    )
                }

            }
            Row(
                modifier = Modifier
                    .padding(
                        top = MaterialTheme.spacing.small,
                        bottom = MaterialTheme.spacing.small,
                        start = MaterialTheme.spacing.medium,
                        end = MaterialTheme.spacing.medium
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.wallet),
                        contentDescription = "",
                        modifier = Modifier.size(18.dp, 18.dp)
                    )
                    Spacer(modifier = Modifier.width(Dimension.width(1f).dp))
                    Text(
                        modifier = Modifier,
                        text = "هزینه ارسال کمتر",
                        textAlign = TextAlign.Start,
                        color = Color.Gray,
                        fontSize = 9.sp,
                        fontFamily = font_bold,
                        fontWeight = FontWeight.Medium,

                        )
                }
//                            Spacer(modifier = Modifier.width(Dimension.width(10f).dp))


                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.signpost),
                        contentDescription = "",
                        modifier = Modifier.size(18.dp, 18.dp)
                    )
                    Spacer(modifier = Modifier.width(Dimension.width(1f).dp))
                    Text(
                        modifier = Modifier,
                        text = "مکان های مختلف",
                        textAlign = TextAlign.Start,
                        color = Color.Gray,
                        fontSize = 9.sp,
                        fontFamily = font_bold,
                        fontWeight = FontWeight.Medium,
                    )
                }
//                            Spacer(modifier = Modifier.width(Dimension.width(10f).dp))

                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.clock),
                        contentDescription = "",
                        modifier = Modifier.size(18.dp, 18.dp)
                    )
                    Spacer(modifier = Modifier.width(Dimension.width(1f).dp))
                    Text(
                        text = "انعطاف زمانی",
                        textAlign = TextAlign.Start,
                        color = Color.Gray,
                        fontSize = 9.sp,
                        fontFamily = font_bold,
                        fontWeight = FontWeight.Medium,


                        )
                }


            }
        }
//        }
    }
}
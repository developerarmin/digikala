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
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.LightBlue),

        ) {
        Column(
            modifier = Modifier
                .background(infoBox)
        ) {
            Row(
                modifier = Modifier
                    .padding(MaterialTheme.spacing.medium)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(0.95f),
                    text = "مراکز دریافت حضوری نزدیک این آدرس",
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    style = MaterialTheme.typography.h4,
                    fontFamily = font_medium,
                    fontWeight = FontWeight.SemiBold,
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(10.dp, 10.dp)
                        .weight(0.05f),
                )
            }





            Row(
                modifier = Modifier
                    .padding(MaterialTheme.spacing.medium)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.wallet),
                        contentDescription = "",
                        modifier = Modifier.size(18.dp, 18.dp),
                        tint = MaterialTheme.colors.LightBlue
                    )

                    Text(
                        modifier = Modifier,
                        text = " هزینه ارسال کمتر",
                        textAlign = TextAlign.Start,
                        color = Color.Gray,
                        style = MaterialTheme.typography.CartReceive

                        )
                }


                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.signpost),
                        contentDescription = "",
                        modifier = Modifier.size(18.dp, 18.dp),
                        tint = MaterialTheme.colors.LightBlue
                    )

                    Text(
                        modifier = Modifier,
                        text = " مکان های مختلف",
                        textAlign = TextAlign.Start,
                        color = Color.Gray,
                        style = MaterialTheme.typography.CartReceive

                    )
                }

                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Icon(
                        painter = painterResource(id = R.drawable.clock),
                        contentDescription = "",
                        modifier = Modifier.size(18.dp, 18.dp),
                        tint = MaterialTheme.colors.LightBlue
                    )
                    Text(
                        text = " انعطاف زمانی",
                        textAlign = TextAlign.Start,
                        color = Color.Gray,
                        style = MaterialTheme.typography.CartReceive


                        )
                }
            }
        }
    }
}
package ir.truelearn.androidmvvmsample.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.DarkCyan
import ir.truelearn.androidmvvmsample.ui.theme.LightCyan
import ir.truelearn.androidmvvmsample.ui.theme.font_bold
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.Dimension
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel


@Composable
fun CartReceiveInPersonAddress(

    action:()->Unit={},


    ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
            .clickable { Log.e("3636", "chart checkout") },
        shape = RoundedCornerShape(7.dp),
        elevation = 1.dp,
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.DarkCyan),

        ) {
        Column {
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
                Row(modifier = Modifier
                    .width(Dimension.width(85f).dp)

                    ,)
                {
                    Text(
                        modifier = Modifier
                        ,
                        text = "مراکز دریافت حضوری نزدیک این آدرس",
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontFamily = font_bold,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(modifier = Modifier
                    .width(Dimension.width(15f).dp)
                    , horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(18.dp, 18.dp)


                    )
                }

            }
            Row(
                modifier = Modifier
                    .padding(
                        top = MaterialTheme.spacing.medium,
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
                    Icon(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "",
                        tint = MaterialTheme.colors.LightCyan,
                        modifier = Modifier.size(18.dp, 18.dp)
                    )
                    Spacer(modifier = Modifier.width(Dimension.width(1f).dp))
                    Text(
                        modifier = Modifier
                        ,
                        text = "هزینه ارسال کمتر",
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.DarkCyan,
                        fontSize=12.sp,
                        fontFamily = font_bold,

                        overflow = TextOverflow.Ellipsis
                    )
                }
//                            Spacer(modifier = Modifier.width(Dimension.width(10f).dp))


                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "",
                        tint = MaterialTheme.colors.LightCyan,
                        modifier = Modifier.size(18.dp, 18.dp)
                    )
                    Spacer(modifier = Modifier.width(Dimension.width(1f).dp))
                    Text(
                        modifier = Modifier,
                        text = "مکان های مختلف",
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.DarkCyan,
                        fontFamily = font_bold,
                        fontSize = 12.sp,
                        overflow = TextOverflow.Ellipsis
                    )
                }
//                            Spacer(modifier = Modifier.width(Dimension.width(10f).dp))

                Row( modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically)
                {
                    Icon(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "",
                        tint = MaterialTheme.colors.LightCyan,
                        modifier = Modifier.size(18.dp, 18.dp)
                    )
                    Spacer(modifier = Modifier.width(Dimension.width(1f).dp))
                    Text(
                        text = "انعطاف زمانی",
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colors.DarkCyan,
                        fontSize = 12.sp,
                        fontFamily = font_bold,


                        )
                }


            }
        }
    }
}
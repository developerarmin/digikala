package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.Dimension
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel



@Composable
fun DetermineAddressInMap() {
    Card(
        modifier = Modifier.padding(horizontal = 0.dp),
        shape = RoundedCornerShape(3.dp),
        elevation = 0.dp,
       // border = BorderStroke(width = 1.dp, color = Color.LightGray),
    ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = MaterialTheme.spacing.medium,
                        bottom = MaterialTheme.spacing.medium,
                        start = Dimension.width(1f).dp,
                        end = Dimension.width(1f).dp
                    ),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.Top
            ) {

                Column(
                    modifier = Modifier
                        .width(Dimension.width(10f).dp)
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.info),
                        contentDescription = "",
                        tint = MaterialTheme.colors.amber,
                        modifier = Modifier.size(22.dp, 22.dp)
                    )

                }

//                Spacer(modifier = Modifier.width(Dimension.width(2f).dp))

                Column(
                    modifier = Modifier
                        .width(Dimension.width(78f).dp)
                        ,
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                ) {

                    Row() {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "موقعیت این آدرس بر روی نقشه تعیین نشده. برای ادامه وجود موقعیت الزامی است.",
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.amber,
                            fontFamily = font_bold,
                            overflow = TextOverflow.Ellipsis
                        )
                    }


                }

//                Spacer(modifier = Modifier.width(Dimension.width(2f).dp))
                Column(
                    modifier = Modifier
                        .width(Dimension.width(10f).dp)
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "",
                        tint = MaterialTheme.colors.amber,
                        modifier = Modifier.size(22.dp, 22.dp)
                    )
                }
            }

    }
}
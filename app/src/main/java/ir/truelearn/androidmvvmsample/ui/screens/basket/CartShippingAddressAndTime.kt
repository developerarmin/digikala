package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.BorderStroke
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
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.font_bold
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.Dimension
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel


@Composable
fun CartShippingAddressAndTime(
    viewModel: CartViewModel = hiltViewModel(),
    address: String,
    name: String,

    ) {
    Card(
        modifier = Modifier.padding(horizontal = 0.dp),
        shape = RoundedCornerShape(3.dp),
        elevation = 5.dp,
        border = BorderStroke(width = 2.dp, color = Color.LightGray),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()

                .padding(
                    top = MaterialTheme.spacing.medium,
                    bottom = MaterialTheme.spacing.small,
                    start = MaterialTheme.spacing.small,
                    end = MaterialTheme.spacing.small
                ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = MaterialTheme.spacing.medium,
                        bottom = MaterialTheme.spacing.small,
                        start = MaterialTheme.spacing.small,
                        end = MaterialTheme.spacing.small
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {

                Column(
                    modifier = Modifier
                        .width(Dimension.width(10f).dp)
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "",
                        tint = Color.Black,
                        modifier = Modifier.size(22.dp, 22.dp)
                    )

                }

                Spacer(modifier = Modifier.width(5.dp))

                Column(
                    modifier = Modifier
                        .width(Dimension.width(85f).dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                ) {

                    Row() {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "ارسال به",
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.darkText,
                            fontFamily = font_bold,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Row() {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = address,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontFamily = font_bold,
                            overflow = TextOverflow.Ellipsis
                        )
                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        Text(

                            text = name,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontFamily = font_bold,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
                    if (true)
                        DetermineAddressInMap()


                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            modifier = Modifier,
                            text = " تغییر یا ویرایش آدرس",
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.DarkCyan,
                            fontFamily = font_bold,
                            fontSize = 12.sp,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.width(Dimension.width(1f).dp))
                        Icon(

                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "",
                            tint = MaterialTheme.colors.DarkCyan,
                            modifier = Modifier
                                .size(18.dp, 18.dp)
                                .padding(top = 5.dp)
                        )

                    }






            CartReceiveInPersonAddress()

        }
    }
}
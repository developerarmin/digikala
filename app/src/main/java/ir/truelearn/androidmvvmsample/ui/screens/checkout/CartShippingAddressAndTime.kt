package ir.truelearn.androidmvvmsample.ui.screens.checkout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.screens.basket.CartReceiveInPersonAddress
import ir.truelearn.androidmvvmsample.ui.theme.CartCyan
import ir.truelearn.androidmvvmsample.ui.theme.font_standard
import ir.truelearn.androidmvvmsample.ui.theme.infoBox
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel


@Composable
fun CartShippingAddressAndTime(
    navController: NavHostController,
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
                .padding(MaterialTheme.spacing.small),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {

                Image(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = "",
                    modifier = Modifier
                        .size(22.dp, 22.dp)
                        .weight(0.1f)
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(0.025f))
                Column(
                    modifier = Modifier
                        .weight(0.8f),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                ) {


                    Text(
                        text = "ارسال به",
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Gray,
                        fontFamily = font_standard,
                    )


                    Text(
                        text = address,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.Black,
                        fontFamily = font_standard,
                    )

                    Text(
                        text = name,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.Black,
                        fontFamily = font_standard,
                    )
                }
                Spacer(modifier = Modifier.weight(0.025f))
            }
            if (true) {//use map
                Divider(
                    color = infoBox,
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.medium)
                )
                DetermineAddressInMap()

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (true)
                        navController.navigate(Screen.SaveUserAddress.route)
                    }
                    .padding(vertical = MaterialTheme.spacing.medium),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = Modifier
                        .weight(0.925f),
                    text = " تغییر یا ویرایش آدرس",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.CartCyan,
                    fontFamily = font_standard,
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "",
                    tint = MaterialTheme.colors.CartCyan,
                    modifier = Modifier
                        .size(12.dp, 12.dp)
                        .weight(0.05f)
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(0.025f))
            }

            CartReceiveInPersonAddress()

        }
    }
}
package ir.truelearn.androidmvvmsample.ui.screens.basket.address

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.ComponentActivity
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.screens.basket.CartReceiveInPersonAddress
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.viewmodel.AddressListViewModel


@SuppressLint("StateFlowValueCalledInComposition", "ResourceType")
@Composable
fun CartShippingAddressAndTime(
    navController: NavHostController,onClickChangeAddress:()->Unit
) {
    val viewModel: AddressListViewModel = viewModel(LocalContext.current as ComponentActivity)
    Log.d("level3", "shipping:${viewModel.defaultAddress.value?.address} ")
    var address = stringResource(id = R.string.no_address)
    var name = " "
    if (viewModel.defaultAddress.value != null) {
        viewModel.defaultAddress.value?.let {
            address = viewModel.defaultAddress.value!!.address
            name = viewModel.defaultAddress.value!!.name
        }
    }
    Card(
        modifier = Modifier.padding(horizontal = 0.dp),
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
                        text = stringResource(id = R.string.send_to),
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.body2,
                        color = Color.Gray,
                        fontFamily = font_standard,
                    )


                    Text(
                        text = address,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        fontFamily = font_standard,
                        maxLines = 3
                    )

                    Text(
                        text = name,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        fontFamily = font_standard,
                        maxLines = 1
                    )
                }
                Spacer(modifier = Modifier.weight(0.025f))
            }
            //use map
            Divider(
                color = infoBox,
                thickness = 1.dp,
                modifier = Modifier
                    .padding(MaterialTheme.spacing.medium)
            )
            DetermineAddressInMap()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onClickChangeAddress()
                    }
                    .padding(vertical = MaterialTheme.spacing.medium),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = Modifier
                        .weight(0.925f),
                    text = stringResource(id = R.string.add_address),
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.LightBlue,
                    fontFamily = font_standard,
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "",
                    tint = MaterialTheme.colors.LightBlue,
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
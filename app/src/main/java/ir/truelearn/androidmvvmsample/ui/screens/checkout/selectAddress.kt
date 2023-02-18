package ir.truelearn.androidmvvmsample.ui.screens.checkout

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.checkout.CartAddress
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.viewmodel.AddressViewModel
import kotlinx.coroutines.flow.collectLatest


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun selectAddress(
    navController: NavHostController,
    viewModel: AddressViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        topBar = { TopBarAddress1(navController) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = MaterialTheme.colors.DigikalaLightRed,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.check),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            )
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        val addressList = remember {
            mutableStateOf(emptyList<CartAddress>())
        }
        LaunchedEffect(true) {
            viewModel.getAllAddress.collectLatest { list ->
                addressList.value = list
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight()
                .padding(bottom = 56.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {


            items(addressList.value) { item ->
                AddressList(item = item)
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp)
                        .background(infoBox)
                        .clickable {
                            navController.navigate(Screen.SaveUserAddress.route)
                        },
                    verticalAlignment = Alignment.CenterVertically,

                    ) {

                    Icon(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "",
                        modifier = Modifier
                            .weight(0.1f)
                            .size(22.dp)
                    )
                    Text(
                        text = "اضافه کردن آدرس جدید",
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                        fontFamily = font_bold,
                        modifier = Modifier
                            .weight(0.9f)
                            .padding(MaterialTheme.spacing.medium)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "",
                        modifier = Modifier
                            .weight(0.1f)
                            .size(18.dp)
                    )
                }
            }
            item {
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(
                            vertical = MaterialTheme.spacing.small,
                            horizontal = MaterialTheme.spacing.medium
                        )
                )
            }
        }
    }
}

@Composable
fun AddressList(
    item: CartAddress
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MaterialTheme.spacing.extraSmall)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.medium)
            ) {

                Spacer(
                    modifier = Modifier
                        .padding(
                            MaterialTheme.spacing.extraSmall +
                                    MaterialTheme.spacing.small
                        )
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Column(
                        modifier = Modifier
                            .weight(.9f),
                        horizontalAlignment = Alignment.End
                    ) {

                        Text(
                            text = "${item.postalAddress} ${item.number}",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.darkText,
                            maxLines = 2,
                            modifier = Modifier
                                .padding(vertical = MaterialTheme.spacing.extraSmall)
                        )


                        //city
                        AdressRow(
                            icon = painterResource(id = R.drawable.signpost),
                            text = "${item.province} - ${item.city}",
                            color = MaterialTheme.colors.darkText
                        )

                        //postal code
                        AdressRow(
                            icon = painterResource(id = R.drawable.post),
                            text = "${item.postalCode}",
                            color = MaterialTheme.colors.darkText
                        )

                        //phone
                        AdressRow(
                            icon = painterResource(id = R.drawable.call),
                            text = "${item.phone}",
                            color = MaterialTheme.colors.darkText
                        )

                        //name
                        AdressRow(
                            icon = painterResource(id = R.drawable.user_outline),
                            text = "${item.name}",
                            color = MaterialTheme.colors.darkText
                        )


                    }


                    RadioButton(
                        selected = true,
                        onClick = { }
                    )
                }
            }
        }
    }
}


@Composable
private fun AdressRow(icon: Painter, text: String, color: Color) {
    Row(
        modifier = Modifier
            .padding(vertical = MaterialTheme.spacing.extraSmall)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            style = SmallFont.body1,
            color = MaterialTheme.colors.semiDarkText,
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
        Icon(
            painter = icon,
            contentDescription = "",
            modifier = Modifier
                .width(18.dp)
                .height(18.dp),
            tint = color,

            )
    }
}

@Composable
fun TopBarAddress1(navController: NavController) {
    TopAppBar(
        elevation = 4.dp,
        title = { Text(text = "انتخاب آدرس", fontSize = 16.sp) },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowForward, null)
            }
        }
    )

}

package ir.truelearn.androidmvvmsample.ui.screens.profile.address

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.WithHint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.address.UserAddressResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.viewmodel.AddressListViewModel
import kotlinx.coroutines.flow.collectLatest


@SuppressLint(
    "UnusedMaterialScaffoldPaddingParameter", "StateFlowValueCalledInComposition",
    "RememberReturnType", "SuspiciousIndentation"
)
@Composable
fun AddressesScreen(
    navController: NavHostController,
) {
    val context = LocalContext.current
    val viewModel: AddressListViewModel = viewModel(LocalContext.current as ComponentActivity)
    val addressList = remember {
        mutableStateOf<List<UserAddressResponse>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(true)
    }
    Scaffold(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        topBar = { TopBarAddress1(navController) },
        floatingActionButton = {
            if (addressList.value.isNotEmpty()) {
                FloatingActionButton(
                    onClick = {
                        navController.navigate(Screen.SaveUserAddress.route)

                    },
                    backgroundColor = MaterialTheme.colors.DigikalaLightRed,
                    content = {
                               Row(
                                   modifier = Modifier
                                       .width(150.dp)
                                       .height(50.dp)
                                       .clip(RoundedCornerShape(30.dp))
                                       .background(MaterialTheme.colors.DigikalaDarkRed)
                                       .clickable {
                                           navController.navigate(Screen.SaveUserAddress.route)
                                       },
                                   verticalAlignment = Alignment.CenterVertically,
                                   horizontalArrangement = Arrangement.Center
                               ) {
                                   Text(
                                       text = "  آدرس جدید  ",
                                       textAlign = TextAlign.Start,
                                       style = MaterialTheme.typography.h4,
                                       fontWeight = FontWeight.Bold,
                                       fontFamily = font_bold,
                                       color = Color.White
                                   )

                                   Icon(
                                       painter = painterResource(id = R.drawable.location),
                                       contentDescription = "",
                                       modifier = Modifier
                                           .size(20.dp),
                                       tint = Color.White
                                   )

                               }
                    }
                )
            }

        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        LaunchedEffect(true) {
            if (viewModel.defaultAddress.value == null) {
                Log.d("level5", "token:${MainActivity.USER_TOKEN} ")
                viewModel.getAddressList(MainActivity.USER_TOKEN)
            }

            viewModel.userAddressList.collectLatest { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        result.data?.let { list ->
                            addressList.value = list
                        }
                        loading = false
                    }

                    is NetworkResult.Error -> {
                        loading = false
                        Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
                    }

                    is NetworkResult.Loading -> {
                        loading = true
                    }
                }
            }
        }
        if (loading){
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Loading3Dots(isDark = true)
            }
        }else{
            if (addressList.value.isNotEmpty()){

                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    if (loading) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colors.searchBarBg)
                                .align(Alignment.Center)
                                .padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Loading3Dots(isDark = false)
                        }
                    } else {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .height(400.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            if (addressList.value.isNotEmpty()) {
                                InitSelectableAddressList(addressList.value)
                            }
                        }

                    }
                }
            }else{

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {

                    Spacer(modifier = Modifier.height(150.dp))
                    Image(
                        painter = painterResource(id = R.drawable.address_not_found),
                        contentDescription = "",
                        modifier = Modifier.size(250.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "با ثبت آدرس های خود ، روند خرید خود را سریعتر کنید",
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Medium,
                        fontFamily = font_bold,
                        color = MaterialTheme.colors.darkText
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .width(180.dp)
                            .height(50.dp)
                            .border(1.dp, MaterialTheme.colors.DigikalaDarkRed,RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                navController.navigate(Screen.SaveUserAddress.route)
                            },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.location),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp),
                            tint = MaterialTheme.colors.DigikalaDarkRed
                        )
                        Text(
                            text = "  افزودن آدرس جدید  ",
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            fontFamily = font_bold,
                            color = MaterialTheme.colors.DigikalaDarkRed
                        )

                    }

                }
            }
        }



    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun InitSelectableAddressList(
    list: List<UserAddressResponse>,
) {
    val viewModel: AddressListViewModel = viewModel(LocalContext.current as ComponentActivity)
    val selectedAddressID = remember {
        if (viewModel.defaultAddress.value != null) {
            mutableStateOf(viewModel.defaultAddress.value!!._id)
        } else {
            mutableStateOf("")
        }
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height((list.size * 150).dp)
        ) {
            items(list) { addressItem ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (addressItem._id == selectedAddressID.value),
                            onClick = {
                                selectedAddressID.value = addressItem._id
                                viewModel.defaultAddressTemp.value = addressItem
                            }),
                    verticalAlignment = Alignment.Top
                ) {
                    Column(
                        modifier = Modifier
                            .weight(.9f),
                        horizontalAlignment = Alignment.End
                    ) {

                        Text(
                            text = addressItem.address,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.darkText,
                            maxLines = 2,
                            modifier = Modifier
                                .padding(vertical = MaterialTheme.spacing.extraSmall)
                        )


                        //city
                        AddressRow(
                            icon = painterResource(id = R.drawable.signpost),
                            text = "استان-شهر",
                            color = MaterialTheme.colors.darkText
                        )

                        //postal code
                        AddressRow(
                            icon = painterResource(id = R.drawable.post),
                            text = addressItem.postalCode,
                            color = MaterialTheme.colors.darkText
                        )

                        //phone
                        AddressRow(
                            icon = painterResource(id = R.drawable.call),
                            text = addressItem.phone,
                            color = MaterialTheme.colors.darkText
                        )

                        //name
                        AddressRow(
                            icon = painterResource(id = R.drawable.user_outline),
                            text = addressItem.name,
                            color = MaterialTheme.colors.darkText
                        )

                    }


                    RadioButton(
                        selected = (addressItem._id == selectedAddressID.value),
                        onClick = {
                            selectedAddressID.value = addressItem._id
                            viewModel.defaultAddressTemp.value = addressItem
                        }
                    )
                }

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
private fun AddressRow(icon: Painter, text: String, color: Color) {
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

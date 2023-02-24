package ir.truelearn.androidmvvmsample.ui.screens.basket.address

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    "RememberReturnType"
)
@Composable
fun AddressListScreen(
    navController: NavHostController,
) {
    val context = LocalContext.current
    val viewModel: AddressListViewModel = viewModel(LocalContext.current as ComponentActivity)
    val addressList = remember {
        mutableStateOf<List<UserAddressResponse>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
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
                        navController.popBackStack()
                    },
                    backgroundColor = MaterialTheme.colors.DigikalaLightRed,
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.check),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )
            }

        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        LaunchedEffect(true) {
            val addedNewAddress = navController.currentBackStackEntry
                ?.savedStateHandle
                ?.getLiveData<Boolean>("result")?.value
            if (addedNewAddress != null && addedNewAddress) {
                viewModel.getAddressList(MainActivity.MY_TOKEN)
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
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    item {
                        if (addressList.value.isNotEmpty()) {
                            InitSelectableAddressList(addressList.value)
                        }
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

                list.forEach { addressItem ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (addressItem._id == selectedAddressID.value),
                                onClick = {
                                    selectedAddressID.value = addressItem._id
                                    viewModel.defaultAddress.value = addressItem
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
                                viewModel.defaultAddress.value = addressItem
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

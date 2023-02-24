package ir.truelearn.androidmvvmsample.ui.screens.basket.address

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.address.UserAddressRequest
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.viewmodel.SaveAddressViewModel
import kotlinx.coroutines.flow.collectLatest


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SaveUserAddress(
    navController: NavHostController,
    viewModel: SaveAddressViewModel = hiltViewModel(),
) {

    var loading by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.saveAddressResponse.collectLatest { result ->
            result?.let {
                when (result) {
                    is NetworkResult.Success -> {
                        Log.d("saveAddress", "success:${result.message} ")
                        Toast.makeText(context, result.message, Toast.LENGTH_SHORT)
                            .show()
                        loading = false
                        navController.previousBackStackEntry
                            ?.savedStateHandle
                            ?.set("result",true)
                        navController.popBackStack()
                    }
                    is NetworkResult.Error -> {
                        loading = false
                        Log.d("saveAddress", "error:${result.message} ")
                        Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
                    }

                    is NetworkResult.Loading -> {
                        loading = true
                    }
                }
            }
        }
    }
    Log.d("level7", "befor scaffold:${loading} ")
    Scaffold(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        topBar = { TopBarAddress(navController) },
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
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
                InitScreen(navController = navController) {
                    Log.d("saveAddress", "SaveUserAddress:${it} ")
                    viewModel.saveAddressResponse.value = NetworkResult.Loading()
                    viewModel.addNewAddress(it)
                }
            }
        }

    }
}

@Composable
private fun InitScreen(
    navController: NavHostController,
    viewModel: SaveAddressViewModel = hiltViewModel(),
    onSaveAddress: (UserAddressRequest) -> Unit
) {
    val ProvinceName = remember { viewModel.ProvinceName }
    val CityName = remember { viewModel.CityName }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = MaterialTheme.spacing.medium),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,

        ) {


        SetLabel(label = "استان *")
        SelectCity(ProvinceName.value) {
            navController.navigate(Screen.selectCityName.withArgs("1"))
        }

        SetLabel(label = "شهر *")
        SelectCity(CityName.value) {
            navController.navigate(Screen.selectCityName.withArgs("2"))
        }



        SetLabel(label = "آدرس پستی *")
        viewModel.inputPostalAddress =
            SetTextField(str = viewModel.inputPostalAddress, maxLines = 2)


        SetLabel(label = "کد پستی *")
        viewModel.inputPostalCode =
            SetTextField(str = viewModel.inputPostalCode)


        SetLabel(label = "پلاک *")
        viewModel.inputNumber =
            SetTextField(str = viewModel.inputNumber)

        SetLabel(label = "واحد")
        viewModel.inputUnit =
            SetTextField(str = viewModel.inputUnit)


        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier
                .padding(
                    vertical = MaterialTheme.spacing.small,
                    horizontal = MaterialTheme.spacing.medium
                )
        )

        inputCheckbox(viewModel)

        if (!viewModel.inputCheckboxState)
            Column {

                SetLabel("نام و نام خانوادگی گیرنده")
                viewModel.inputRecipientName =
                    SetTextField(str = viewModel.inputRecipientName)


                SetLabel("شماره تلفن همراه گیرنده")
                viewModel.inputRecipientPhone =
                    SetTextField(str = viewModel.inputRecipientPhone)


            }

//                    if (
//                        (
//                                isValidEmpty(viewModel.inputPostalAddress) &&
//                                        isValidNumber(viewModel.inputNumber) &&
//                                        isValidNumber(viewModel.inputUnit) &&
//                                        isValidNumber(viewModel.inputPostalCode) &&
//                                        isValidEmpty(viewModel.inputRecipientName) &&
//                                        isValidPhoneNumber(viewModel.inputRecipientPhone)
//                                )
//                        || (
//                                isValidEmpty(viewModel.inputPostalAddress) &&
//                                        isValidNumber(viewModel.inputNumber) &&
//                                        isValidNumber(viewModel.inputUnit) &&
//                                        isValidNumber(viewModel.inputPostalCode) &&
//                                        viewModel.inputCheckboxState
//                                )
//                    )

        SetAddressButton("ثبت آدرس", MaterialTheme.colors.DigikalaLightRed) {
            saveAddress(viewModel = viewModel) {
                onSaveAddress(it)
            }
        }
//                    else
//                        SetAddressButton("ثبت آدرس", MaterialTheme.colors.unSelectedBottomBar) {
//                            Log.e("3636", "لطفا فیلد ها را کامل پر کنید")
//                        }
    }
}

@Composable
fun SetLabel(label: String) {

    Text(
        text = label,
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.darkText,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = MaterialTheme.spacing.small,
                horizontal = MaterialTheme.spacing.medium
            )
    )
}


//********************************************************************************************
@Composable
fun TopBarAddress(navController: NavController) {
    TopAppBar(
        elevation = 4.dp,
        title = { Text(text = "جزئیات آدرس", fontSize = 16.sp) },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        actions = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.Close, null)
            }
        }
    )

}


@Composable
fun SelectCity(title: String, action: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MaterialTheme.spacing.medium)
            .clickable {
//                dlgTest.value = true
                action()
            }
    ) {
        Row(
            modifier = Modifier
                .background(textFieldBG),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Text(
                text = title,//dlgTest_selected.value,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                fontFamily = font_bold,
                modifier = Modifier
                    .weight(0.9f)
                    .padding(MaterialTheme.spacing.medium)
            )
            Icon(
                painter = painterResource(id = R.drawable.arrow_down),
                contentDescription = "",
                modifier = Modifier
                    .weight(0.1f)
//                            .padding(15.dp)
                    .size(18.dp)
            )
        }
    }
}

private fun saveAddress(viewModel: SaveAddressViewModel, onClick: (UserAddressRequest) -> Unit) {

    val address =
        " ${viewModel.ProvinceName.value} - ${viewModel.CityName.value} - ${viewModel.inputPostalAddress} - ${viewModel.inputNumber} "
    val name =
        if (viewModel.inputCheckboxState) viewModel.inputRecipientName else "from app"
    val phone =
        if (viewModel.inputCheckboxState) MainActivity.USER_PHONE else viewModel.inputRecipientPhone
    val newAdress = UserAddressRequest(
        address = address,
        name = "reza",
        phone = "09195874542",
        postalCode = viewModel.inputPostalCode,
        token = MainActivity.MY_TOKEN
    )
    onClick(newAdress)

}
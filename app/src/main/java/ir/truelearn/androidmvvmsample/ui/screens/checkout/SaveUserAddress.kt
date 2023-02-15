package ir.truelearn.androidmvvmsample.ui.screens.checkout

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.checkout.CartAddress
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.InputValidationUtil.isValidEmpty
import ir.truelearn.androidmvvmsample.util.InputValidationUtil.isValidNumber
import ir.truelearn.androidmvvmsample.util.InputValidationUtil.isValidPhoneNumber
import ir.truelearn.androidmvvmsample.viewmodel.AddressViewModel
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SaveUserAddress(
    navController: NavHostController,
    viewModel: CartViewModel = hiltViewModel(),
    addressViewModel: AddressViewModel = hiltViewModel(),
) {

    val ProvinceName = remember { viewModel.ProvinceName }
    val CityName = remember { viewModel.CityName }
    Scaffold(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        topBar = { TopBarAddress(navController) },
    ) {
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

            if (
                (
                        isValidEmpty(viewModel.inputPostalAddress) &&
                                isValidNumber(viewModel.inputNumber) &&
                                isValidNumber(viewModel.inputUnit) &&
                                isValidNumber(viewModel.inputPostalCode) &&
                                isValidEmpty(viewModel.inputRecipientName) &&
                                isValidPhoneNumber(viewModel.inputRecipientPhone)
                        )
                || (
                        isValidEmpty(viewModel.inputPostalAddress) &&
                                isValidNumber(viewModel.inputNumber) &&
                                isValidNumber(viewModel.inputUnit) &&
                                isValidNumber(viewModel.inputPostalCode) &&
                                viewModel.inputCheckboxState
                        )
            )

                SetAddressButton("ثبت آدرس", MaterialTheme.colors.DigikalaLightRed) {
                    Log.e("3636", "آدرس جدید ثبت شد")

                    addressViewModel.addNewAddress(
                        CartAddress(
                            name = "مهدی ایمانی",
                            phone = "09909290948",
                            province = viewModel.ProvinceName.value,
                            city = viewModel.CityName.value,
                            postalAddress = viewModel.inputPostalAddress,
                            postalCode = viewModel.inputPostalCode,
                            number = viewModel.inputNumber,
                            unit = viewModel.inputUnit,
                            recipientIsMeState = viewModel.inputRecipientPhone,
                            nameRecipient = viewModel.inputRecipientName,
                            phoneRecipient = viewModel.inputRecipientPhone,
                            status = viewModel.inputCheckboxState
                        )

                    )

                }
            else
                SetAddressButton("ثبت آدرس", MaterialTheme.colors.unSelectedBottomBar) {
                    Log.e("3636", "لطفا فیلد ها را کامل پر کنید")
                }
        }
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
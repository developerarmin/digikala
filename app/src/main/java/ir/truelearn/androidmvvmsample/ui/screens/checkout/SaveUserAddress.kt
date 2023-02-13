package ir.truelearn.androidmvvmsample.ui.screens.checkout

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
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.InputValidationUtil.isValidEmpty
import ir.truelearn.androidmvvmsample.util.InputValidationUtil.isValidNumber
import ir.truelearn.androidmvvmsample.util.InputValidationUtil.isValidPhoneNumber
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SaveUserAddress(
    navController: NavHostController,
    viewModel: CartViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),


        ) {
        val dlgProvinceName = remember { viewModel.dlgProvinceName }
        val dlgCityState = remember { viewModel.dlgCityState }
        val dlgCityName = remember { viewModel.dlgCityName }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MaterialTheme.spacing.medium),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,

            ) {

            TopBarAddress(navController)

            SetLabel(label = "استان *")// design by navController
            SelectCity(dlgProvinceName.value) { navController.navigate(Screen.selectCityName.route) }

            SetLabel(label = "شهر *") // design by dialog
            SelectCity(dlgCityName.value) { dlgCityState.value = true }

            if (viewModel.dlgCityState.value) {
                selectCityNameByDialog(viewModel = viewModel, flag = 2) { viewModel.dlgCityState.value = false }
            }


            SetLabel(label = "آدرس پستی *")
            //inputPostalAddressEditText()
            viewModel.inputPostalAddressState =
                SetTextField(str = viewModel.inputPostalAddressState,maxLines=2)


            SetLabel(label = "کد پستی *")
            // zipCodeEditText()
            viewModel.inputZipCodeState =
                SetTextField(str = viewModel.inputZipCodeState)


            SetLabel(label = "پلاک *")
            //inputNumberEditText()
            viewModel.inputNumberState =
                SetTextField(str = viewModel.inputNumberState)

            SetLabel(label = "واحد")
            // inputUnitEditText()
            viewModel.inputUnitState =
                SetTextField(str = viewModel.inputUnitState)


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
                    //inputRecipientNameEditText()
                    viewModel.inputRecipientNameState =
                        SetTextField(str = viewModel.inputRecipientNameState)


                    SetLabel("شماره تلفن همراه گیرنده")
                    //inputRecipientNameEditText()
                    viewModel.inputRecipientPhoneState =
                        SetTextField(str = viewModel.inputRecipientPhoneState)


                }

            if (
                (
                        isValidEmpty(viewModel.inputPostalAddressState) &&
                                isValidNumber(viewModel.inputNumberState) &&
                                isValidNumber(viewModel.inputUnitState) &&
                                isValidNumber(viewModel.inputZipCodeState) &&
                                isValidEmpty(viewModel.inputRecipientNameState) &&
                                isValidPhoneNumber(viewModel.inputRecipientPhoneState)
                        )
                || (
                        isValidEmpty(viewModel.inputPostalAddressState) &&
                                isValidNumber(viewModel.inputNumberState) &&
                                isValidNumber(viewModel.inputUnitState) &&
                                isValidNumber(viewModel.inputZipCodeState) &&
                                viewModel.inputCheckboxState
                        )
            )

                SetAddressButton("ثبت آدرس", MaterialTheme.colors.DigikalaLightRed) {
                    Log.e("3636","آدرس جدید ثبت شد")
                }
            else
                SetAddressButton("ثبت آدرس", MaterialTheme.colors.unSelectedBottomBar) {
                    Log.e("3636","لطفا فیلد ها را کامل پر کنید")
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
fun TopBarAddress( navController: NavController) {
    TopAppBar(
        elevation = 4.dp,
        title = { Text(text = "جزئیات آدرس", fontSize = 16.sp) },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        actions = {
            IconButton(onClick = { navController.popBackStack()}) {
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
package ir.truelearn.androidmvvmsample.ui.screens.profile.my_orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation.AddLegalInformationItem
import ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation.UserAccountItem
import ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation.UserAccountTopBar
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper


@Composable
fun UserAccount(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
    ) {

        UserAccountTopBar(navController=navController)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.smallTwo
                )
        ) {
            Text(
                text = stringResource(id = R.string.person_information),
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.Bold
            )

        }
        LazyColumn(){
            item {
                UserAccountItem(
                    stringResource(id = R.string.name_lastname)
                    ,"-"
                    ,Screen.AddNameandLastname.route
                    ,navController)
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.mediumTwo)
                )
            }
            item {
                UserAccountItem(
                    stringResource(id = R.string.phone_number)
                    , DigitHelper.digitByLocate(MainActivity.USER_PHONE)
                    ,Screen.PhoneNumber.route
                    ,navController)
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.mediumTwo)
                )
            }
            item {
                UserAccountItem(
                    stringResource(id = R.string.national_Code)
                    ,"-"
                    ,Screen.NationalCode.route
                    ,navController)
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.mediumTwo)
                )
            }
            item {
                UserAccountItem(
                    stringResource(id = R.string.refund_Method)
                    ,"-"
                    ,Screen.AddRefundMethode.route
                    ,navController)
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.mediumTwo)
                )
            }
            item {
                UserAccountItem(
                    stringResource(id = R.string.landline_Phone)
                    ,"-"
                    ,Screen.AddNameandLastname.route
                    ,navController)
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.mediumTwo)
                )
            }
            item {
                UserAccountItem(
                    stringResource(id = R.string.post_Address)
                    ,"-"
                    ,Screen.PostAddress.route
                    ,navController)
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.mediumTwo)
                )
            }
            item {
                UserAccountItem(
                    stringResource(id = R.string.password)
                    ,DigitHelper.digitByLocate(MainActivity.USER_PASSWORD)
                    ,Screen.AddPassword.route
                    ,navController)
            }


        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.searchBarBg)
            .height(MaterialTheme.spacing.small)
        )

        AddLegalInformationItem(stringResource(id = R.string.add_Legal_Information),"با تکمیل اطلاعات حقوقی می توانید اقدام به خرید ...")







    }
}
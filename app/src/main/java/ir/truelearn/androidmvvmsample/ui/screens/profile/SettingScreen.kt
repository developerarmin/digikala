package ir.truelearn.androidmvvmsample.ui.screens.profile

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ir.truelearn.androidmvvmsample.BuildConfig
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.component.MenuSectionRowItem
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.Constants
import ir.truelearn.androidmvvmsample.viewmodel.DataStoreViewModel
import ir.truelearn.androidmvvmsample.viewmodel.LoginViewModel

@Composable
fun SettingScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        SettingTop(navController = navController)

        SettingMenuSection(navController = navController)
        Spacer(modifier = Modifier.height(100.dp))
        SettingBottom()
        Spacer(modifier = Modifier.height(20.dp))


    }
}

@Composable
fun SettingBottom() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.width(100.dp),
            painter = painterResource(id = R.drawable.digi_red_english),
            contentDescription = ""
        )
        Text(
            text = stringResource(id = R.string.version_app, BuildConfig.VERSION_NAME),
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.semiDarkText
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Text(
                text = stringResource(id = R.string.truelearn_technical_team),
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.semiDarkText
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.extraSmall))
            Image(
                modifier = Modifier.height(24.dp),
                painter = painterResource(id = R.drawable.truelearn_icon),
                contentDescription = ""
            )
        }

    }
}


@Composable
fun SettingMenuSection(navController: NavHostController, dataStore: DataStoreViewModel= hiltViewModel()) {


    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.repetitive_questions)
            )
        },
        icon = {
            Icon(
                Icons.Outlined.HelpCenter, contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.settingIcon
            )
        },
        isHaveDivider = true,
        modifier = Modifier.clickable {  }
    ) {
        Icon(
            Icons.Outlined.ChevronLeft, contentDescription = "Go to",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.settingArrow
        )
    }
    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.privacy)
            )
        },
        icon = {
            Icon(
                Icons.Outlined.PrivacyTip, contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.settingIcon
            )
        },
        isHaveDivider = true,
        modifier = Modifier.clickable {  }
    ) {
        Icon(
            Icons.Outlined.ChevronLeft, contentDescription = "Go to",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.settingArrow
        )
    }

    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.terms_of_use)
            )
        },
        icon = {
            Icon(
                Icons.Outlined.OtherHouses, contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.settingIcon
            )
        },
        isHaveDivider = true,
        modifier = Modifier.clickable {  }
    ) {
        Icon(
            Icons.Outlined.ChevronLeft, contentDescription = "Go to",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.settingArrow
        )
    }
    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.contact_us)
            )
        },
        icon = {
            Icon(
                Icons.Filled.Call, contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.settingIcon
            )
        },
        isHaveDivider = true,
        modifier = Modifier.clickable {  }
    ) {
        Icon(
            Icons.Outlined.ChevronLeft, contentDescription = "Go to",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.settingArrow
        )
    }
    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.error_report)
            )
        },
        icon = {
            Icon(
                Icons.Outlined.PestControl, contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.settingIcon
            )
        },
        isHaveDivider = true,
        modifier = Modifier.clickable {  }
    ) {
        Icon(
            Icons.Outlined.ChevronLeft, contentDescription = "Go to",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.settingArrow
        )
    }
    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.rating_to_digikal)
            )
        },
        icon = {
            Icon(
                Icons.Outlined.StarRate, contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.settingIcon
            )
        },
        isHaveDivider = true,
        modifier = Modifier.clickable {  }
    ) {
        Icon(
            Icons.Outlined.ChevronLeft, contentDescription = "Go to",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.settingArrow
        )
    }
    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.change_language)
            )
        },
        icon = {
            Icon(
                Icons.Outlined.Language, contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.settingIcon
            )
        },
        isHaveDivider = true,
    ) {
        ChangeLanguage()
    }

//    SettingRowItem(
//        text = {
//            Text(
//                style = MaterialTheme.typography.h5,
//                fontWeight = FontWeight.Bold,
//                text = stringResource(id = R.string.send_information_to_improve_user_experience)
//            )
//        },
//        icon = {
//            Icon(
//                Icons.Outlined.DataExploration, contentDescription = "",
//                modifier = Modifier.size(24.dp),
//            )
//        },
//        isHaveDivider = true,
//    ) {
//        val checkedState = remember { mutableStateOf(true) }
//        Switch(checked = checkedState.value, onCheckedChange = {
//            checkedState.value = !checkedState.value
//        })
//    }
    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.report_error_by_shaking_the_phone)
            )
        },
        icon = {
            Icon(
                Icons.Outlined.NotificationsActive, contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.settingIcon
            )
        },
        isHaveDivider = true,
    ) {
        val checkedState = remember { mutableStateOf(true) }
        Switch(checked = checkedState.value, onCheckedChange = {
            checkedState.value = !checkedState.value
        })
    }
    val loginViewModel:LoginViewModel = hiltViewModel()
    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.sign_out),
                color = MaterialTheme.colors.digikalaRed
            )
        },
        icon = {
            Icon(
                Icons.Outlined.Logout, contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.digikalaRed
            )
        },
        isHaveDivider = false,
        modifier = Modifier.clickable {  logOut(navController = navController, dataStore = dataStore,loginViewModel)}
    )

}

fun logOut(navController: NavHostController,dataStore: DataStoreViewModel,loginViewModel: LoginViewModel){
    dataStore.saveUserToken("")
    dataStore.saveUserId("")
    dataStore.saveUserPhoneNumber("null")
    dataStore.saveUserPassword("null")
    loginViewModel.pageState = ProfilePageState.LOGIN_STATE
    navController.navigate(Screen.Profile.route)
}


@Composable
fun ChangeLanguage(dataStore: DataStoreViewModel = hiltViewModel()) {
    val activity = LocalContext.current as Activity
    Row(verticalAlignment = Alignment.CenterVertically) {
        val lang = dataStore.getUserLanguage()
        val checkedState = remember { mutableStateOf(lang) }
        Text(text = Constants.FA_LANG)
        Switch(checked = checkedState.value == "en", onCheckedChange = {
            dataStore.saveUserLanguage(if (lang == "en") "fa" else "en")
            activity.finish()
            activity.startActivity(Intent(activity, MainActivity::class.java))
        })
        Text(text = Constants.EN_LANG)
    }
}

@Composable
fun SettingTop(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = MaterialTheme.spacing.large, end = MaterialTheme.spacing.small),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold,
            text = stringResource(id = R.string.setting)
        )
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                Icons.Filled.Close, contentDescription = "Close",
                modifier = Modifier
                    .padding(
                        vertical = MaterialTheme.spacing.small,
                        horizontal = MaterialTheme.spacing.small
                    ),
                tint = MaterialTheme.colors.selectedBottomBar
            )
        }

    }
}



@Composable
@Preview
fun SettingScreenPreview() {
    AndroidMvvmSampleTheme {
        SettingScreen(navController = rememberNavController())
    }
}
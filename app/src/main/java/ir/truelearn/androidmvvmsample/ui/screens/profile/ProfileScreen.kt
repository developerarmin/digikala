package ir.truelearn.androidmvvmsample.ui.screens.profile

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.util.LocaleUtils
import ir.truelearn.androidmvvmsample.viewmodel.DataStoreViewModel
import ir.truelearn.androidmvvmsample.viewmodel.LoginViewModel
import ir.truelearn.androidmvvmsample.viewmodel.MainViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    dataStore: DataStoreViewModel = hiltViewModel()
) {


    if (dataStore.getUserToken() != null) {
        Profile()
    } else {
        when (loginViewModel.pageState) {
            ProfilePageState.PROFILE_STATE -> {
                Profile()
            }
            ProfilePageState.LOGIN_STATE -> {
                LoginScreen()
            }
            ProfilePageState.SET_PASSWORD_STATE -> {
                PasswordScreen()
            }
        }

    }

}

@Composable
fun Profile(
    dataStore: DataStoreViewModel = hiltViewModel(),
    mainViewModel: MainViewModel = hiltViewModel()
) {
    if (!isSystemInDarkTheme()) {

        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {

            dataStore.getUserToken()?.let { Text(text = it) }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Fa")
                dataStore.saveUserLanguage("fa")
                mainViewModel.appLanguage = "fa"
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "En")
                dataStore.saveUserLanguage("en")
                mainViewModel.appLanguage = "en"
            }

        }

    } else {
        //TODO dark theme
    }

}

@Composable
@Preview
fun ProfileScreenLightPreview() {
    Profile()
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun ProfileScreenDarkPreview() {
    Profile()
}
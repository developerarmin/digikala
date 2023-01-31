package ir.truelearn.androidmvvmsample.ui.screens.profile

import android.app.Activity
import android.content.Intent
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.viewmodel.DataStoreViewModel
import ir.truelearn.androidmvvmsample.viewmodel.LoginViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    dataStore: DataStoreViewModel = hiltViewModel()
) {


    if (dataStore.getUserToken() != null) {
        Profile(navController)
    } else {
        when (loginViewModel.pageState) {
            ProfilePageState.PROFILE_STATE -> {
                Profile(navController)
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
    navController: NavHostController,
    dataStore: DataStoreViewModel = hiltViewModel()
) {

    val activity = LocalContext.current as Activity

    if (!isSystemInDarkTheme()) {

        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {

            dataStore.getUserToken()?.let { Text(text = it) }

            Button(
                onClick = {
                    dataStore.saveUserLanguage("fa")
                    activity.finish()
                    activity.startActivity(Intent(activity, MainActivity::class.java))
                }) {
                Text(text = "Fa")
            }

            Button(
                onClick = {
                    dataStore.saveUserLanguage("en")
                    activity.finish()
                    activity.startActivity(Intent(activity, MainActivity::class.java))
                }) {
                Text(text = "En")
            }

        }

    } else {
        //TODO dark theme
    }

}

@Composable
@Preview
fun ProfileScreenLightPreview() {
    // Profile()
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun ProfileScreenDarkPreview() {
    //Profile()
}
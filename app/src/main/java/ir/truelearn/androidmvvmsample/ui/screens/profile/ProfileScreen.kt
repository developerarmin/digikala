package ir.truelearn.androidmvvmsample.ui.screens.profile

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R

@Composable
fun ProfileScreen(navController: NavHostController) {
    Profile()
}

@Composable
fun Profile() {
    if (!isSystemInDarkTheme()) {

        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            Login()
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
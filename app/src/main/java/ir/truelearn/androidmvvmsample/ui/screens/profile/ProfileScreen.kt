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
import ir.truelearn.androidmvvmsample.ui.ChangeLanguage

@Composable
fun ProfileScreen(navController: NavHostController) {
    Profile()
}

@Composable
fun Profile() {
    if (!isSystemInDarkTheme()) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.profile_screen),
                    fontSize = 18.sp
                )
                ChangeLanguage()
            }

        }
    } else {
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.profile_screen),
                color = Color.White,
                fontSize = 18.sp
            )
        }
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
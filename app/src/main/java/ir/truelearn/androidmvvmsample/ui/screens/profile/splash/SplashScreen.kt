package ir.truelearn.androidmvvmsample.ui.screens.profile.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.splashBg
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Splash()
    LaunchedEffect(true) {
        delay(3000)
        navController.navigate(Screen.Home.route)
    }


}


@Composable
fun Splash() {
    if (!isSystemInDarkTheme()) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.splashBg)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp),
                painter = painterResource(id = R.drawable.digi_logo),
                contentDescription = ""
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(100.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    modifier = Modifier
                        .height(30.dp),
                    painter = painterResource(id = R.drawable.digi_txt_white),
                    contentDescription = ""
                )

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Loading3Dots(isDark = false)
            }
        }
    } else {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "SplashScreen",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }

}

@Composable
@Preview
fun SplashScreenLightPreview() {
    Splash()
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashScreenDarkPreview() {
    Splash()
}
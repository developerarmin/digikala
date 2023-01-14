package ir.truelearn.androidmvvmsample.ui.screens.basket

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
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
fun BasketScreen(navController: NavHostController) {
    Basket()
}

@Composable
fun Basket() {
    if (!isSystemInDarkTheme()) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.basket ) ,
                color = Color.White,
                fontSize = 18.sp
            )
        }
    } else {
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "BasketScreen",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }

}

@Composable
@Preview
fun BasketScreenLightPreview() {
    Basket()
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun BasketScreenDarkPreview() {
    Basket()
}
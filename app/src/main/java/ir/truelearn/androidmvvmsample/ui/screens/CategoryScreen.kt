package ir.truelearn.androidmvvmsample.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import dagger.hilt.android.scopes.ActivityScoped
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.component.SearchBar
import kotlinx.coroutines.delay

@Composable
fun CategoryScreen(navController: NavHostController) {

    Category()

}

@Composable
fun Category() {
    if (!isSystemInDarkTheme()) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {

            SearchBar()
        }
    } else {
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "CategoryScreen",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }

}

@Composable
@Preview
fun CategoryScreenLightPreview() {
    Category()
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun CategoryScreenDarkPreview() {
    Category()
}
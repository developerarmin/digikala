package ir.truelearn.androidmvvmsample.ui.screens.category

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.screens.home.SearchBar

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
            CategoryItems()
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
private fun CategoryItems(){
    Column(modifier=Modifier.fillMaxSize()) {
        LazyRow(modifier = Modifier.background(colorResource(id = R.color.white))) {
            items(20) {
                CategoryItem()
            }
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
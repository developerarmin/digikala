package ir.truelearn.androidmvvmsample.ui.screens.home.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.screens.home.showSearchResult
import ir.truelearn.androidmvvmsample.ui.theme.font_standard

@Composable
fun AllProductsSearch(productName: String, navController: NavHostController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
            .clickable {
                navController.navigate(Screen.ProductListScreen.route){
                    popUpTo(Screen.Home.route){
                        inclusive = true
                    }
                }
            },
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.all_products_search_icon),
            contentDescription = "all product search icon",
            modifier = Modifier.size(35.dp)
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
        Text(
            text = stringResource(id = R.string.all_products_search_category) + productName,
            fontFamily = font_standard,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            color = Color.DarkGray,
        )
    }
}


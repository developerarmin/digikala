package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun TopAppBarProductDetail(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(horizontal = MaterialTheme.spacing.small),
        //.background(Color.Green),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.weight(0.7f), horizontalArrangement = Arrangement.Start) {
            IconButton(onClick = {navController.popBackStack()}) {
                Icon(
                    painter = painterResource(id = R.drawable.exit),
                    contentDescription = "",
                    modifier = Modifier.size(17.dp),
                    tint = MaterialTheme.colors.darkText
                )
            }
        }

        Row(modifier = Modifier.weight(0.4f)) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.basket),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp),
                    tint = MaterialTheme.colors.darkText
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.faverate),
                    contentDescription = "",
                    modifier = Modifier.size(27.dp),
                    tint = MaterialTheme.colors.darkText
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.menu_dots),
                    contentDescription = "",
                    modifier = Modifier.size(27.dp),
                    tint = MaterialTheme.colors.darkText
                )
            }
        }


    }
}
package ir.truelearn.androidmvvmsample.ui.screens.home.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.*

@Composable
fun HotProductSearch() {

    Row(verticalAlignment = Alignment.CenterVertically) {

        Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

        Icon(
            painter = painterResource(id = R.drawable.hot_deal),
            contentDescription = "hot products",
            tint = Color.Gray,
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
        Text(
            text = stringResource(id = R.string.hot_search_products),
            fontFamily = font_standard,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color.DarkGray
        )
    }
}
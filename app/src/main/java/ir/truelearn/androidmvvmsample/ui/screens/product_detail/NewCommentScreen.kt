package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun NewCommentScreen(
    navController: NavController,
    productDetailImage: String,
    productDetailTitle:String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())

    ) {

        NewCommentHeader(navController,productDetailImage,productDetailTitle)

        ScoreSeekbar()

        NewCommentForm()

        RulesOfDigikala()
    }
}






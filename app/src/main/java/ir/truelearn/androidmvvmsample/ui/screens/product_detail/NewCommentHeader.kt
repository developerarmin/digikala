package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.ui.theme.Gray
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.grayCategory
import ir.truelearn.androidmvvmsample.ui.theme.spacing


@Composable
fun NewCommentHeader(navController: NavController, image: String, title:String) {
    Row(
        modifier = Modifier
            .padding(
                top = MaterialTheme.spacing.extraSmall,
                start = MaterialTheme.spacing.small
            ),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = null,
            )
        }

        Image(
            painter = rememberAsyncImagePainter(image),
            contentDescription = "",
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .padding(horizontal = MaterialTheme.spacing.small)
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "دیدگاه شما",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.darkText
            )
            Text(
                text = title,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.Gray
            )
        }
    }

    Divider(color = MaterialTheme.colors.grayCategory, thickness = 2.dp)

}
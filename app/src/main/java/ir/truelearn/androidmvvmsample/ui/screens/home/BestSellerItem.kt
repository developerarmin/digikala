package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.ui.theme.*


@Composable
fun BestSellerItem(number:String,name:String,url:String) {
    Column(
        modifier = Modifier
            .width(320.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MaterialTheme.spacing.extraSmall),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = rememberAsyncImagePainter(url),
                contentDescription = "best seller image",
                modifier = Modifier
                    .weight(.3f)
                    .fillMaxHeight()
            )
            Text(
                text = number,
                style = MaterialTheme.typography.extraBoldNumber,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.DarkCyan,
                modifier = Modifier.weight(.1f)
            )
            Column(
                modifier = Modifier
                    .weight(.6f)
                    .fillMaxHeight()
                    .padding(vertical = MaterialTheme.spacing.small),
                verticalArrangement = Arrangement.Top
            ) {

                Text(
                    text = name,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.darkText,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = MaterialTheme.spacing.small)

                )
            }
        }
    }
}
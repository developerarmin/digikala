package ir.truelearn.androidmvvmsample.ui.screens.category

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.grayAlpha
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun CategoryImages() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 4), modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        items(18) { index ->
            Card(
                onClick = { /*TODO*/ },
                border = BorderStroke(width = 0.dp, color = MaterialTheme.colors.grayAlpha),
                shape = RectangleShape
            ) {
                Image(
                    painter = painterResource(id = R.drawable.auction),
                    contentDescription = "",
                    modifier = Modifier.padding(
                        MaterialTheme.spacing.medium
                    ),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}
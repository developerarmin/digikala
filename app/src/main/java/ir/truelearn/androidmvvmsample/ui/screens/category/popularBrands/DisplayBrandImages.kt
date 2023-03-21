package ir.truelearn.androidmvvmsample.ui.screens.category.popularBrands

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.data.model.category.BrandsSub
import ir.truelearn.androidmvvmsample.ui.theme.grayAlpha
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun DisplayBrandImages(list: List<BrandsSub>) {
    FlowRow(
        horizontalArrangement = Arrangement.End,
        maxItemsInEachRow = 4,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        for (item in list) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(.25f)
                    .wrapContentHeight(),
                onClick = { /*TODO*/ },
                border = BorderStroke(width = 0.dp, color = MaterialTheme.colors.grayAlpha),
                shape = RectangleShape
            ) {
                Image(
                    painter = rememberAsyncImagePainter(item.image),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(MaterialTheme.spacing.extraSmall),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}
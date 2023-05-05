package ir.truelearn.androidmvvmsample.ui.screens.category.popularBrands

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.airbnb.lottie.model.content.RectangleShape
import ir.truelearn.androidmvvmsample.data.model.category.BrandsSub
import ir.truelearn.androidmvvmsample.ui.theme.grayAlpha
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DisplayBrandsImageUi(item: BrandsSub) {
    Card(
        modifier = Modifier
            .fillMaxWidth(.24f)
            .wrapContentHeight(),
        shape = RoundedCornerShape(0.dp),
        elevation = 0.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.small)
        ) {

            Image(
                painter = rememberAsyncImagePainter(item.image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .padding(MaterialTheme.spacing.extraSmall),
                contentScale = ContentScale.Fit
            )


        }


    }


}


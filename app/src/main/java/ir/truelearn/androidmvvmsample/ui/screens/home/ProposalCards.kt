package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.data.model.home.Slider

@Composable
fun ProposalCardItem(imgLink: Slider) {
    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .size(175.dp, 140.dp)
            .padding(horizontal = 8.dp, vertical = 8.dp),
    ) {
        Image(
            painter = rememberAsyncImagePainter(imgLink.image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}
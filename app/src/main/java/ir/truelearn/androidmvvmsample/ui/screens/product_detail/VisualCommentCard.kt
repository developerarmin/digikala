package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun VisualCommentCard() {

    Card(
        modifier = Modifier
            .padding(
                start = MaterialTheme.spacing.medium,
            )
            .width(80.dp)
            .height(80.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = 1.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.digi_logo),
            contentDescription = ""
        )
    }
}
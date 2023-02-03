package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.Dimension
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel

@Composable
fun CartInfoBox(
    msg: String,
    icon:Painter
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(infoBox)
            .padding(
                top = MaterialTheme.spacing.mediumTwo,
                bottom = MaterialTheme.spacing.mediumTwo,
                start = MaterialTheme.spacing.small,
                end = MaterialTheme.spacing.semiLargeTwo
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier
                .width(Dimension.width(13f).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter =icon,
                contentDescription = "",
                modifier = Modifier.size(26.dp, 26.dp),
            tint=Color.DarkGray
            )

        }

        Spacer(modifier = Modifier.width(Dimension.width(.2f).dp))

        Column(
            modifier = Modifier
                .width(Dimension.width(85f).dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                modifier = Modifier
                    ,
                text = msg,
                textAlign = TextAlign.Start,
                color = Color.DarkGray,
                style = MaterialTheme.typography.caption,
                fontFamily = font_standard,
                fontSize=11.sp,
                overflow = TextOverflow.Ellipsis,

            )
        }

    }
}
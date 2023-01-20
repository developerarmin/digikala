package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.ui.theme.*

@Composable
fun SuperMarketOfferCard() {

    val superMarketOfferTittle = "شگفت\n انگیز\n سوپر مارکتی"
    val seeAll = "مشاهده همه"


    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.DigikalaLightGreen)
            .width(160.dp)
            .height(370.dp)
            .padding(
                vertical = MaterialTheme.spacing.medium,
                horizontal = MaterialTheme.spacing.extraSmall
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp),
            text = superMarketOfferTittle,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            style = MaterialTheme.typography.h1,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )

        Image(
            painterResource(id = R.drawable.fresh),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,

            ) {
            Text(
                text = seeAll,
                style = MaterialTheme.typography.h5,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
            )

            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "",
                tint = Color.White,
            )

        }


    }
}
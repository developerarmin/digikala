package ir.truelearn.androidmvvmsample.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.ui.theme.unSelectedBottomBar

@Composable
fun SearchBar() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(Color.White),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(MaterialTheme.colors.searchBarBg),

            ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    modifier = Modifier
                        .width(80.dp)
                        .padding(end = 5.dp),
                    painter = painterResource(id = R.drawable.digi_red_persian),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .padding(end = 20.dp),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.unSelectedBottomBar,
                    style = MaterialTheme.typography.h2,
                    fontWeight = FontWeight.SemiBold,
                    text = "جستجو در"
                )

                Icon(
                    modifier = Modifier
                        .height(24.dp),
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = ""
                )

            }

        }
    }


}

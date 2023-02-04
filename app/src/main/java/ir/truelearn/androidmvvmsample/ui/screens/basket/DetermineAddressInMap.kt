package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.DarkAmper
import ir.truelearn.androidmvvmsample.ui.theme.font_standard
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.Dimension


@Composable
fun DetermineAddressInMap() {
    Card(
        modifier = Modifier.padding(horizontal = 0.dp),
        shape = RoundedCornerShape(3.dp),
        elevation = 0.dp,
        // border = BorderStroke(width = 1.dp, color = Color.LightGray),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.medium,
                    bottom = MaterialTheme.spacing.medium,
                    start = Dimension.width(1f).dp,
                    end = Dimension.width(1f).dp
                ),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.Top
        ) {

            Column(
                modifier = Modifier
                    .width(Dimension.width(10f).dp)
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.info),
                    contentDescription = "",
                    tint = DarkAmper,
                    modifier = Modifier.size(22.dp, 22.dp)
                )

            }

//                Spacer(modifier = Modifier.width(Dimension.width(2f).dp))

            Column(
                modifier = Modifier
                    .width(Dimension.width(78f).dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
            ) {

                Row() {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "موقعیت این آدرس بر روی نقشه تعیین نشده. برای ادامه وجود موقعیت الزامی است.",
                        textAlign = TextAlign.Start,
                        color = DarkAmper,
                        style = MaterialTheme.typography.body2,
                        fontFamily = font_standard,
                    )
                }

            }

//                Spacer(modifier = Modifier.width(Dimension.width(2f).dp))
            Column(
                modifier = Modifier
                    .width(Dimension.width(10f).dp)
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "",
                    tint = DarkAmper,
                    modifier = Modifier.size(18.dp, 18.dp)
                )
            }
        }

    }
}
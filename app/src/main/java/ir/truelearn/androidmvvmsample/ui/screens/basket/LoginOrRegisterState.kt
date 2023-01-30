package ir.truelearn.androidmvvmsample.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.amber
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.Dimention

@Composable
fun LoginOrRegisterState() {
    Card(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .padding(end = 16.dp, start = 4.dp)
            .clickable { Log.e("3636", "basketLoginOrRegester") },
        shape = RoundedCornerShape(7.dp),
        contentColor = Color.Cyan,
        elevation = 10.dp,

        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.medium,
                    bottom = MaterialTheme.spacing.small,
                    start = MaterialTheme.spacing.small,
                    end = MaterialTheme.spacing.small
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier
                    .width(Dimention.width(15f).dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.show_more),
                    contentDescription = "",
                    tint = MaterialTheme.colors.amber,
                    modifier = Modifier.size(40.dp, 40.dp)
                )

            }

//                Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier
                    .width(Dimention.width(65f).dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "ورود یا ثیت نام",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.darkText,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "برای تجربه بهتر خرید و برسی روش ارسال کالاها لطفا وارد شوید.",
                    textAlign = TextAlign.Start,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.h6,
                    maxLines = 2
                )

            }


            Spacer(modifier = Modifier.width(5.dp))
            Column(
                modifier = Modifier
                    .width(Dimention.width(15f).dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward),
                    contentDescription = "",
                    tint = Color.Gray,
                    modifier = Modifier.size(32.dp, 32.dp)
                )

            }


        }

    }
}
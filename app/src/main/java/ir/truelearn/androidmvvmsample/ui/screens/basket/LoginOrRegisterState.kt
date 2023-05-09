package ir.truelearn.androidmvvmsample.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.*

@Composable
fun LoginOrRegisterState(
    navController: NavController
) {

    Card(
        modifier = Modifier
            .padding(MaterialTheme.spacing.medium)
            .clickable {
                navController.navigate(Screen.Profile.route)
                Log.e("3636", "basketLoginOrRegester") },
        shape = RoundedCornerShape(7.dp),
        elevation = 1.dp,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                painter = painterResource(id = R.drawable.import_96_orenge),
                contentDescription = "",
                tint = MaterialTheme.colors.amber,
                modifier = Modifier
                    .size(25.dp, 25.dp)
                    .weight(0.1f)
                    .align(Alignment.Top)
            )
            Spacer(modifier = Modifier.weight(0.05f))
            Column(

                modifier = Modifier.weight(0.8f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(R.string.login_or_register),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.darkText,
                    fontFamily = font_bold,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(R.string.login_or_register_msg),
                    textAlign = TextAlign.Start,
                    color = Color.Gray,
                    //fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.h4,
                    maxLines = 2
                )
            }
            Spacer(modifier = Modifier.weight(0.05f))

            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "",
                tint = Color.Gray,
                modifier = Modifier
                    .size(13.dp, 13.dp)
                    .weight(0.1f)
                    .align(Alignment.Top)

            )
        }

    }
    Spacer(
        modifier = Modifier.fillMaxWidth()
            .height(MaterialTheme.spacing.extraSmall)
            .background(MaterialTheme.colors.searchBarBg)
    )
}
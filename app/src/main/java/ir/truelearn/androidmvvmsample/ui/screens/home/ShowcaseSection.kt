package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.component.CircularIconBox
import ir.truelearn.androidmvvmsample.ui.component.RoundedIconBox
import ir.truelearn.androidmvvmsample.ui.theme.amber
import ir.truelearn.androidmvvmsample.ui.theme.grayCategory


@Composable
fun ShowcaseSection(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 12.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        ) {
            RoundedIconBox(
                image = painterResource(id = R.drawable.digijet),
                title = stringResource(R.string.digikala_jet),
                onClick = onBoxClick(
                    navController,
                    url ="https://www.digikalajet.com/user/address")
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.auction),
                title = stringResource(R.string.digi_style),
                onClick = onBoxClick(
                    navController,
                    url ="https://www.digistyle.com/sale-landing/?utm_source=digikala&utm_medium=circle_badge&utm_campaign=style&promo_name=style&promo_position=circle_badge")
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digipay),
                title = stringResource(R.string.digi_pay),
                onClick = onBoxClick(
                    navController,
                    url ="https://www.digikala.com/my-digipay/?promo_name=my-digipay&promo_position=circle_badge")
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.pindo),
                title = stringResource(R.string.pindo),
                bgColor = MaterialTheme.colors.amber,
                onClick = onBoxClick(
                    navController,
                    url ="https://www.pindo.ir/?utm_source=digikala&utm_medium=circle_badge&utm_campaign=pindo&promo_name=pindo&promo_position=circle_badge")
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)

        ) {
            CircularIconBox(
                image = painterResource(id = R.drawable.shopping),
                title = "خرید سر ماه",
                onClick = onBoxClick(
                    navController,
                    url ="")

            )
            CircularIconBox(
                image = painterResource(id = R.drawable.giftcard),
                title = stringResource(R.string.gift_card),
                onClick = onBoxClick(
                    navController,
                    url ="https://www.digikala.com/landing/gift-card-landing/?promo_name=gift_landing&promo_position=circle_badge")

            )
            CircularIconBox(
                image = painterResource(id = R.drawable.digiplus),
                title = stringResource(R.string.digi_plus),
                onClick = onBoxClick(
                    navController,
                    url ="https://www.digikala.com/plus/landing/?promo_name=plus&promo_position=circle_badge")

            )
            CircularIconBox(
                image = painterResource(id = R.drawable.more),
                title = stringResource(R.string.more),
                bgColor = MaterialTheme.colors.grayCategory,
                onClick = onMoreClick()
            )
        }
    }
}

@Composable
fun onBoxClick(navController:NavController,url:String): () -> Unit =
    { navController.navigate(route = Screen.WebView.route + "?url=$url ") }


@Composable
fun onMoreClick(): () -> Unit ={

}

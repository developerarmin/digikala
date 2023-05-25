package ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation.itemScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.screens.home.onBoxClick
import ir.truelearn.androidmvvmsample.ui.screens.product_detail.selectedColorItem
import ir.truelearn.androidmvvmsample.ui.theme.LightBlue
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.ui.theme.splashBg

@Composable
fun AddRefundMethode(navController: NavController) {


    val radioOption = listOf(
        stringResource(id = R.string.deposit_to_bank_account),
        stringResource(id = R.string.deposit_to_DigiPy_wallet)
    )
    val (selectedOption, onOptionsSelected) = remember {
        mutableStateOf(radioOption[1])
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = MaterialTheme.spacing.small,
                vertical = MaterialTheme.spacing.smallTwo
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.choise_refund_method),
                style = MaterialTheme.typography.h1,
                fontWeight = FontWeight.ExtraBold
            )
            IconButton(onClick = { navController.navigate(Screen.UserAccountScreen.route) }) {
                Icon(Icons.Filled.Close, contentDescription = null, modifier = Modifier.size(20.dp))
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.considerations_for_returning_money_fromDigikala),
                color = MaterialTheme.colors.LightBlue,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Normal
            )
            IconButton(
                onClick =
                onBoxClick(
                    navController = navController,
                    url = "https://www.digikala.com/faq/question/720/"
                )

            ) {
                Icon(
                    painterResource(id = R.drawable.arrow_left),
                    contentDescription = null,
                    tint = MaterialTheme.colors.LightBlue,
                    modifier = Modifier.size(10.dp)
                )
            }
        }



        radioOption.forEachIndexed { indext, text ->

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption)
                    , onClick = {
                        onOptionsSelected(text)
                    },
                    colors = RadioButtonDefaults.colors(
                        MaterialTheme.colors.LightBlue
                    )
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Normal
                )
            }

            if ( indext == 0){
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MaterialTheme.spacing.mediumTwo)
                )
            }

        }




        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.smallTwo),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.digi_wallet),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(
                    horizontal = MaterialTheme.spacing.smallTwo,
                    vertical = MaterialTheme.spacing.small
                ),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        MaterialTheme.colors.splashBg,
                        shape = RoundedCornerShape(MaterialTheme.spacing.small)
                    ), contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier,
                    text = stringResource(id = R.string.confirmation),
                    style = MaterialTheme.typography.h3,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

    }
}
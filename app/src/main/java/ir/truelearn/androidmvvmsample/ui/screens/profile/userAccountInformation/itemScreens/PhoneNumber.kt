package ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation.itemScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.CursorColor
import ir.truelearn.androidmvvmsample.ui.theme.DarkCyan
import ir.truelearn.androidmvvmsample.ui.theme.roundedShape
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.ui.theme.splashBg
import ir.truelearn.androidmvvmsample.util.DigitHelper

@Composable
fun AddPhoneNumber(
    navController: NavController,
){

    var phoneNumber by remember {
        mutableStateOf(TextFieldValue(DigitHelper.digitByLocate(MainActivity.USER_PHONE)))
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = MaterialTheme.spacing.medium)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            IconButton(onClick = { navController.navigate(Screen.UserAccountScreen.route)}) {
                Icon(Icons.Filled.Close, contentDescription = "close")
            }
        }
        Text(
            text = stringResource(id = R.string.enter_phone_number),
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
            TextField(
                value = phoneNumber
                , onValueChange = {phoneNumber=it}
                , shape = MaterialTheme.roundedShape.small
                , modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                ,colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.searchBarBg,
                    focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
                    unfocusedIndicatorColor = MaterialTheme.colors.searchBarBg,
                    cursorColor = MaterialTheme.colors.CursorColor,
                )
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
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    MaterialTheme.colors.splashBg,
                    shape = RoundedCornerShape(MaterialTheme.spacing.small)
                )
                , contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier,
                    text = stringResource(id = R.string.get_code)
                    , style = MaterialTheme.typography.h3
                    , fontWeight = FontWeight.Bold
                    , color = Color.White
                )
            }
        }





    }
}
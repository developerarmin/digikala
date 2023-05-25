package ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation.itemScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.CursorColor
import ir.truelearn.androidmvvmsample.ui.theme.DarkCyan
import ir.truelearn.androidmvvmsample.ui.theme.DigikalaDarkRed
import ir.truelearn.androidmvvmsample.ui.theme.Green
import ir.truelearn.androidmvvmsample.ui.theme.Orange
import ir.truelearn.androidmvvmsample.ui.theme.digikalaRed
import ir.truelearn.androidmvvmsample.ui.theme.roundedShape
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.ui.theme.splashBg

@Composable
fun AddPassword(navController: NavController) {

    var password by remember {
        mutableStateOf(TextFieldValue())
    }

    var repeatpassword by remember {
        mutableStateOf(TextFieldValue())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = MaterialTheme.spacing.smallTwo,
                vertical = MaterialTheme.spacing.small
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = {
                navController.navigate(Screen.UserAccountScreen.route)
            }) {
                Icon(Icons.Filled.Close, contentDescription = "Back")
            }
        }

        Text(
            text = stringResource(id = R.string.add_password),
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.smallTwo))
        Text(
            text = stringResource(id = R.string.least8_characters_long),
            style = MaterialTheme.typography.h5
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.mediumTwo))

        Column(modifier = Modifier.fillMaxWidth()) {
            if (password.text.length>=11){
                Text(
                    text = stringResource(id = R.string.new_password),
                    style = MaterialTheme.typography.h5,
                    color = Color.Black
                )
            }
            else if (password.text.length<=10){
                Text(
                    text = stringResource(id = R.string.new_password),
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.digikalaRed
                )
            }

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
            TextField(
                value = password,
                onValueChange = { password = it },
                shape = MaterialTheme.roundedShape.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                leadingIcon = {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = MaterialTheme.spacing.small),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Icon(
                            painterResource(id = R.drawable.eye),
                            tint = Color.Gray,
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                                .clickable { },
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.searchBarBg,
                    focusedIndicatorColor = MaterialTheme.colors.digikalaRed,
                    unfocusedIndicatorColor = MaterialTheme.colors.searchBarBg,
                    cursorColor = MaterialTheme.colors.CursorColor,
                )
            )

        }
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

        PasswordCheck(password)

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
        LazyColumn() {
            item {
                ShowText(stringResource(id = R.string.at_least_8_characters))
            }
            item {
                ShowText(stringResource(id = R.string.upper_and_lower_case_letters))
            }
            item {
                ShowText(stringResource(id = R.string.including_the_sign))
            }
            item {
                ShowText(stringResource(id = R.string.including_number))
            }

        }





        Spacer(modifier = Modifier.height(MaterialTheme.spacing.mediumTwo))
        Column(modifier = Modifier.fillMaxWidth()) {
            if (repeatpassword.text.length<1){
                Text(
                    text = stringResource(id = R.string.repeat_the_new_password),
                    style = MaterialTheme.typography.h5,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
                TextField(
                    value = repeatpassword,
                    onValueChange = { repeatpassword = it },
                    shape = MaterialTheme.roundedShape.small,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    leadingIcon = {
                        Row(
                            modifier = Modifier
                                .padding(horizontal = MaterialTheme.spacing.small),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Icon(
                                painterResource(id = R.drawable.eye),
                                tint = Color.Gray,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable { },
                            )
                        }
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.searchBarBg,
                        focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
                        unfocusedIndicatorColor = MaterialTheme.colors.searchBarBg,
                        cursorColor = MaterialTheme.colors.CursorColor,
                    )
                )
            }
            else if (repeatpassword.text.length>=1){
                Text(
                    text = stringResource(id = R.string.repeat_the_new_password),
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.digikalaRed
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
                TextField(
                    value = repeatpassword,
                    onValueChange = { repeatpassword = it },
                    shape = MaterialTheme.roundedShape.small,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    leadingIcon = {
                        Row(
                            modifier = Modifier
                                .padding(horizontal = MaterialTheme.spacing.small),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Icon(
                                painterResource(id = R.drawable.eye),
                                tint = Color.Gray,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable { },
                            )
                        }
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.searchBarBg,
                        focusedIndicatorColor = MaterialTheme.colors.digikalaRed,
                        unfocusedIndicatorColor = MaterialTheme.colors.searchBarBg,
                        cursorColor = MaterialTheme.colors.CursorColor,
                    )
                )
            }


        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.smallTwo))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
            //verticalAlignment = Alignment.Bottom,
            , horizontalArrangement = Arrangement.Center
        ) {
            if (password.text.length<8){
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    border = BorderStroke(1.dp, MaterialTheme.colors.searchBarBg),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier,
                        text = stringResource(id = R.string.add_password),
                        style = MaterialTheme.typography.h3,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                }
            }
            else if (repeatpassword==password){
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
                        text = stringResource(id = R.string.add_password),
                        style = MaterialTheme.typography.h3,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }


        }


    }
}


@Composable
fun ShowText(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painterResource(id = R.drawable.dot),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(6.dp)
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.extraSmall))
        Text(
            text = text,
            style = MaterialTheme.typography.h5,
            color = Color.Gray
        )
    }
}


@Composable
fun PasswordCheck(inputPassword: TextFieldValue) {
    Column(modifier = Modifier.fillMaxWidth()) {
        if (inputPassword.text.length < 8) {
            Text(
                text = stringResource(id = R.string.weak),
                color = MaterialTheme.colors.digikalaRed,
                style = MaterialTheme.typography.h3
            )
        } else if (inputPassword.text.length == 8) {
            Text(
                text = stringResource(id = R.string.normal),
                color = MaterialTheme.colors.Orange,
                style = MaterialTheme.typography.h3
            )
        } else if (inputPassword.text.length == 9) {
            Text(
                text = stringResource(id = R.string.normal),
                color = MaterialTheme.colors.Orange,
                style = MaterialTheme.typography.h3
            )
        } else if (inputPassword.text.length == 10) {
            Text(
                text = stringResource(id = R.string.normal),
                color = MaterialTheme.colors.Orange,
                style = MaterialTheme.typography.h3
            )
        } else if (inputPassword.text.length >= 11) {
            Text(
                text = stringResource(id = R.string.perfect),
                color = MaterialTheme.colors.Green,
                style = MaterialTheme.typography.h3
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))




        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .weight(4f)
                .height(4.dp)
                .background(
                    MaterialTheme.colors.searchBarBg, shape = RoundedCornerShape(16.dp)
                )
            ) {
                if (inputPassword.text.length < 8){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                MaterialTheme.colors.digikalaRed
                                ,shape = RoundedCornerShape(16.dp)
                            )
                    )
                }
                else if (inputPassword.text.length == 8){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                MaterialTheme.colors.Orange
                                ,shape = RoundedCornerShape(16.dp)
                            )
                    )
                }
                else if (inputPassword.text.length == 9){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                MaterialTheme.colors.Orange
                                ,shape = RoundedCornerShape(16.dp)
                            )
                    )
                }
                else if (inputPassword.text.length ==10){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                MaterialTheme.colors.Orange
                                ,shape = RoundedCornerShape(16.dp)
                            )
                    )
                }
                else if (inputPassword.text.length >=11){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                MaterialTheme.colors.Green
                                ,shape = RoundedCornerShape(16.dp)
                            )
                    )
                }


            }


            Spacer(modifier = Modifier.width(MaterialTheme.spacing.miniDp))



            Box(modifier = Modifier
                .weight(4f)
                .height(4.dp)
                .background(
                    MaterialTheme.colors.searchBarBg, shape = RoundedCornerShape(16.dp)
                )
            ){
                if (inputPassword.text.length == 8){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                MaterialTheme.colors.Orange
                                ,shape = RoundedCornerShape(16.dp)
                            )
                    )
                }
                else if (inputPassword.text.length == 9){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                MaterialTheme.colors.Orange
                                ,shape = RoundedCornerShape(16.dp)
                            )
                    )
                }
                else if (inputPassword.text.length == 10){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                MaterialTheme.colors.Orange
                                ,shape = RoundedCornerShape(16.dp)
                            )
                    )
                }
                else if (inputPassword.text.length >=11){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                MaterialTheme.colors.Green
                                ,shape = RoundedCornerShape(16.dp)
                            )
                    )
                }

            }


            Spacer(modifier = Modifier.width(MaterialTheme.spacing.miniDp))
            Box(modifier = Modifier
                .weight(4f)
                .height(4.dp)
                .background(
                    MaterialTheme.colors.searchBarBg, shape = RoundedCornerShape(16.dp)
                )
            ){
                if (inputPassword.text.length >=11){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            MaterialTheme.colors.Green
                            ,shape = RoundedCornerShape(16.dp)
                        )
                )
                }
            }


        }



    }
}

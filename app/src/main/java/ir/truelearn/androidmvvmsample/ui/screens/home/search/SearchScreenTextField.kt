package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.*

@Composable
fun SearchScreenTextField(navController: NavHostController) {

    var textFieldValueState by remember {
        mutableStateOf(
            TextFieldValue(
                text = ""
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

            Icon(
                painter = painterResource(id = R.drawable.arrow_back2),
                contentDescription = "arrow back",
                modifier = Modifier.clickable {
                    showSearchScreen.value = false
                },
                tint = Color.DarkGray
            )
            TextField(
                value = textFieldValueState,
                onValueChange = { textFieldValueState = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        start = MaterialTheme.spacing.small,
                        end = MaterialTheme.spacing.small
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
                    unfocusedIndicatorColor = MaterialTheme.colors.searchBarBg,
                    cursorColor = MaterialTheme.colors.CursorColor
                ),
                placeholder = {
//                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
                    Text(
                        text = stringResource(id = R.string.search_all_products),
                        fontFamily = font_standard,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
//                    }
                },
                textStyle = TextStyle(
                    textDirection = TextDirection.ContentOrRtl
                )
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

            //hot products

        }
    }

}
package ir.truelearn.androidmvvmsample.ui.screens.profile

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.viewmodel.LoginViewModel

@Composable
fun PasswordEditText(
     viewModel: LoginViewModel = hiltViewModel()
) {

    TextField(
        value = viewModel.inputPasswordState, onValueChange = {
            viewModel.inputPasswordState = it
        }, modifier = Modifier
            .fillMaxWidth()
            .height(92.dp)
            .padding(
                start = MaterialTheme.spacing.semiLarge,
                end = MaterialTheme.spacing.semiLarge,
                top = MaterialTheme.spacing.medium,
                bottom = MaterialTheme.spacing.semiLarge
            ),
        shape = MaterialTheme.roundedShape.small,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.searchBarBg,
            focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
            unfocusedIndicatorColor = MaterialTheme.colors.searchBarBg,
            cursorColor = MaterialTheme.colors.CursorColor,
        ),

        placeholder = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {

                Text(
                    text = stringResource(id = R.string.set_password),
                    fontFamily = font_standard,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

        }, textStyle = TextStyle(
            textDirection = TextDirection.ContentOrRtl
        )
    )
}

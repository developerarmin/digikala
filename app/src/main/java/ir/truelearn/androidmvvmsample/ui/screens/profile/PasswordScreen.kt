package ir.truelearn.androidmvvmsample.ui.screens.profile

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import ir.truelearn.androidmvvmsample.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.InputValidationUtil.isValidEmail
import ir.truelearn.androidmvvmsample.util.InputValidationUtil.isValidPassword
import ir.truelearn.androidmvvmsample.util.InputValidationUtil.isValidPhoneNumber
import ir.truelearn.androidmvvmsample.viewmodel.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun PasswordScreen(viewModel: LoginViewModel = hiltViewModel()) {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    if (!isSystemInDarkTheme()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.digi_settings
                        ), contentDescription = "",
                        modifier = Modifier
                            .padding(
                                vertical = MaterialTheme.spacing.small,
                                horizontal = MaterialTheme.spacing.small
                            ),
                        tint = MaterialTheme.colors.selectedBottomBar
                    )
                }

                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Close, contentDescription = "Close",
                        modifier = Modifier
                            .padding(
                                vertical = MaterialTheme.spacing.small,
                                horizontal = MaterialTheme.spacing.small
                            ),
                        tint = MaterialTheme.colors.selectedBottomBar
                    )
                }


            }


            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))

            Text(
                modifier = Modifier.padding(
                    horizontal = MaterialTheme.spacing.semiLarge
                ),
                style = MaterialTheme.typography.h6,
                text = stringResource(id = R.string.set_password_text),
                color = MaterialTheme.colors.darkText,
                fontWeight = FontWeight.Bold
            )

            PhoneEditText()

            PasswordEditText()

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

            DigikalaButton(
                text = stringResource(id = R.string.digikala_login),
                onClick = {
                    if (
                        isValidPassword(viewModel.inputPasswordState) &&
                        (isValidEmail(viewModel.inputPhoneState)
                                || isValidPhoneNumber(viewModel.inputPhoneState))
                    ) {
                        coroutineScope.launch {
                            viewModel.login()
                        }
                    } else {
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = "This is your message",
                                actionLabel = "Do something"
                            )
                        }

                    }
                })

            var loading by remember {
                mutableStateOf(false)
            }

            LaunchedEffect(Dispatchers.Main) {
                viewModel.loginResponse.collectLatest { result ->
                    when (result) {
                        is NetworkResult.Success -> {
                            Log.e("3636", result.message.toString())
                            result.data?.let {
                                if (result.data.role == "user" && result.data.token.isNotEmpty()) {
                                    viewModel.pageState = ProfilePageState.PROFILE_STATE
                                }
                            }

                            loading = false
                        }
                        is NetworkResult.Error -> {
                            loading = false
                        }
                        is NetworkResult.Loading -> {
                            loading = true
                        }
                    }
                }
            }

        }


    }

}

@Preview
@Composable
fun PasswordScreenPreview() {
    PasswordScreen()
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PasswordScreenDarkPreview() {
    PasswordScreen()
}
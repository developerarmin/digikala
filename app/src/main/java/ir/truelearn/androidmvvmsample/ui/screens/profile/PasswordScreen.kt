package ir.truelearn.androidmvvmsample.ui.screens.profile

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import ir.truelearn.androidmvvmsample.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.screens.comment.FROM_COMMENT_SCREEN
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.InputValidationUtil.isValidEmail
import ir.truelearn.androidmvvmsample.util.InputValidationUtil.isValidPassword
import ir.truelearn.androidmvvmsample.util.InputValidationUtil.isValidPhoneNumber
import ir.truelearn.androidmvvmsample.viewmodel.DataStoreViewModel
import ir.truelearn.androidmvvmsample.viewmodel.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun PasswordScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    dataStore: DataStoreViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
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
                        Toast.makeText(
                            context,
                            context.resources.getText(R.string.password_error),
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                })

            var loading by remember {
                mutableStateOf(false)
            }

            LaunchedEffect(Dispatchers.Main) {
                viewModel.loginResponse.collectLatest { result ->
                    when (result) {
                        is NetworkResult.Success -> {

                            Toast.makeText(
                                context,
                                result.message,
                                Toast.LENGTH_SHORT
                            ).show()

                            result.data?.let {
                                if (it.role == "user" && it.token.isNotEmpty()) {
                                    dataStore.saveUserToken(it.token)
                                    dataStore.saveUserId(it.id)
                                    dataStore.saveUserPhoneNumber(it.phone)
                                    dataStore.saveUserPassword(viewModel.inputPasswordState)

                                    if (!FROM_COMMENT_SCREEN){
                                        viewModel.pageState = ProfilePageState.PROFILE_STATE
                                    }
                                    else if (FROM_COMMENT_SCREEN){
                                        viewModel.pageState = ProfilePageState.SET_COMMENT_STATE
                                    }
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
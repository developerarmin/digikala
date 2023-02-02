package ir.truelearn.androidmvvmsample.ui.screens.profile

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.Paint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.MainActivity.Companion.USER_PHONE
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.screens.category.SubCategoryItem
import ir.truelearn.androidmvvmsample.ui.screens.home.CenterBannerItem
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.selectedBottomBar
import ir.truelearn.androidmvvmsample.ui.theme.semiDarkText
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitByLocate
import ir.truelearn.androidmvvmsample.viewmodel.DataStoreViewModel
import ir.truelearn.androidmvvmsample.viewmodel.LoginViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    dataStore: DataStoreViewModel = hiltViewModel()
) {


    if (dataStore.getUserToken() != null) {
        Profile(navController)
    } else {
        when (loginViewModel.pageState) {
            ProfilePageState.PROFILE_STATE -> {
                Profile(navController)
            }
            ProfilePageState.LOGIN_STATE -> {
                LoginScreen()
            }
            ProfilePageState.SET_PASSWORD_STATE -> {
                PasswordScreen()
            }
        }

    }

}

@Composable
fun Profile(
    navController: NavHostController,
    dataStore: DataStoreViewModel = hiltViewModel()
) {

    val activity = LocalContext.current as Activity

    if (!isSystemInDarkTheme()) {

        Column(
            modifier = Modifier
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
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

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.mediumTwo))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "بدون نام",
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = digitByLocate(USER_PHONE),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.semiDarkText
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.mediumTwo))


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) {

                Row(
                    modifier = Modifier.weight(0.49f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(

                        painter = painterResource(id = R.drawable.digi_score),
                        contentDescription = "",
                        modifier = Modifier
                            .size(42.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(
                                horizontal = MaterialTheme.spacing.small +
                                        MaterialTheme.spacing.extraSmall
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(bottom = MaterialTheme.spacing.extraSmall),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                style = MaterialTheme.typography.h5,
                                color = MaterialTheme.colors.semiDarkText,
                                text = "${digitByLocate("975")} "
                            )
                            Text(
                                style = MaterialTheme.typography.h6,
                                color = MaterialTheme.colors.semiDarkText,
                                text = stringResource(R.string.score)
                            )
                        }
                        Text(
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.darkText,
                            fontWeight = FontWeight.Bold,
                            text = stringResource(id = R.string.digikala_score)
                        )
                    }

                }

                Divider(
                    modifier = Modifier
                        .width(2.dp)
                        .height(60.dp)
                        .alpha(0.2f),
                    color = Color.LightGray,
                )

                Column(
                    modifier = Modifier.weight(0.49f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.digi_wallet),
                        contentDescription = "",
                        modifier = Modifier
                            .size(34.dp)
                    )

                    Text(
                        modifier = Modifier.padding(top = MaterialTheme.spacing.small),
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.darkText,
                        text = stringResource(id = R.string.digikala_wallet_active)
                    )
                }
            }

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.semiLarge))

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MaterialTheme.spacing.small)
                    .alpha(0.4f)
                    .shadow(2.dp),
                color = Color.LightGray,
            )

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.mediumTwo)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.digi_user),
                        contentDescription = "",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )
                    Text(
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.semiDarkText,
                        text = stringResource(R.string.auth)
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.digi_club),
                        contentDescription = "",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )
                    Text(
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.semiDarkText,
                        text = stringResource(R.string.club)
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.digi_contact_us),
                        contentDescription = "",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )
                    Text(
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.semiDarkText,
                        text = stringResource(R.string.contact_us)
                    )
                }


            }



            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MaterialTheme.spacing.small)
                    .alpha(0.4f)
                    .shadow(2.dp),
                color = Color.LightGray,
            )


            Text(
                modifier = Modifier.padding(MaterialTheme.spacing.medium),
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.my_orders),
            )

            LazyRow(modifier = Modifier.background(Color.White)) {
                item {
                    MyOrdersItem(
                        text = stringResource(id = R.string.unpaid),
                        painterResource(id = R.drawable.digi_unpaid)
                    )
                }
                item {
                    MyOrdersItem(
                        text = stringResource(id = R.string.processing),
                        painterResource(id = R.drawable.digi_processing)
                    )
                }
                item {
                    MyOrdersItem(
                        text = stringResource(id = R.string.my_orders),
                        painterResource(id = R.drawable.digi_delivered)
                    )
                }
                item {
                    MyOrdersItem(
                        text = stringResource(id = R.string.canceled),
                        painterResource(id = R.drawable.digi_cancel)
                    )
                }
                item {
                    MyOrdersItem(
                        text = stringResource(id = R.string.returned),
                        painterResource(id = R.drawable.digi_returned)
                    )
                }
            }


            CenterBannerItem(painter = painterResource(id = R.drawable.digiclub2))


            Row(
                Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxHeight()
                        .weight(0.1f)
                        .background(Color.Red),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "",
                        modifier = Modifier
                            .size(36.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )
                }
                Column(
                    Modifier
                        .fillMaxHeight()
                        .weight(0.9f)
                        .background(Color.Cyan),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "تست")
                        Image(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "",
                            modifier = Modifier
                                .size(30.dp)
                                .padding(bottom = MaterialTheme.spacing.small)
                        )
                    }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .alpha(0.4f),
                        color = Color.LightGray,
                    )
                }
            }

            CenterBannerItem(painter = painterResource(id = R.drawable.digiclub1))

            Button(
                onClick = {
                    dataStore.saveUserLanguage("fa")
                    activity.finish()
                    activity.startActivity(Intent(activity, MainActivity::class.java))
                }) {
                Text(text = "Fa")
            }

            Button(
                onClick = {
                    dataStore.saveUserLanguage("en")
                    activity.finish()
                    activity.startActivity(Intent(activity, MainActivity::class.java))
                }) {
                Text(text = "En")
            }

        }

    } else {
        //TODO dark theme
    }

}

@Composable
fun MyOrdersItem(text: String, painter: Painter) {
    Row(modifier = Modifier.padding(vertical = MaterialTheme.spacing.mediumTwo)) {
        Column(
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter,
                contentDescription = "",
                modifier = Modifier
                    .size(70.dp)
                    .padding(bottom = MaterialTheme.spacing.small)
            )
            Text(
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.semiDarkText,
                text = text
            )
        }
        Divider(
            modifier = Modifier
                .width(1.dp)
                .height(90.dp)
                .alpha(0.4f),
            color = Color.LightGray,
        )

    }

}

@Composable
@Preview
fun ProfileScreenLightPreview() {
    // Profile()
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun ProfileScreenDarkPreview() {
    //Profile()
}
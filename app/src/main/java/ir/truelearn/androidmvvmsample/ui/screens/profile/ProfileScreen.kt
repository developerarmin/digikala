package ir.truelearn.androidmvvmsample.ui.screens.profile

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.MainActivity.Companion.USER_PHONE
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.component.MenuSectionRowItem
import ir.truelearn.androidmvvmsample.ui.screens.home.CenterBannerItem
import ir.truelearn.androidmvvmsample.ui.screens.home.onBoxClick
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitByLocate
import ir.truelearn.androidmvvmsample.viewmodel.DataStoreViewModel
import ir.truelearn.androidmvvmsample.viewmodel.LoginViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    dataStore: DataStoreViewModel = hiltViewModel()
) {


    if (!dataStore.getUserToken().isNullOrBlank()) {
        Profile(navController)
    } else {
        when (loginViewModel.pageState) {
            ProfilePageState.PROFILE_STATE -> {
                Profile(navController)
            }
            ProfilePageState.LOGIN_STATE -> {
                LoginScreen(navController)
            }
            ProfilePageState.SET_PASSWORD_STATE -> {
                PasswordScreen()
            }
            ProfilePageState.SET_COMMENT_STATE -> {
//                NewCommentScreen()
            }
        }

    }

}

@Composable
fun Profile(
    navController: NavHostController,
    dataStore: DataStoreViewModel = hiltViewModel()
) {


    if (!isSystemInDarkTheme()) {

        Column(
            modifier = Modifier
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {

            ProfileTopBar(navController = navController)
            ProfileHeaderSection(
                digikalaMissionOnClick = {},
                digitWalletOnClick = onBoxClick(
                    navController = navController,
                    url = "https://www.mydigipay.com/"
                )
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MaterialTheme.spacing.small)
                    .alpha(0.4f)
                    .shadow(2.dp),
                color = Color.LightGray,
            )
            ProfileMiddleSection(authOnClick = {}, clubOnClick = {}, contactUsOnClick = onBoxClick(
                navController = navController,
                url = "https://truelearn.ir/contact/"
            )
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MaterialTheme.spacing.small)
                    .alpha(0.4f)
                    .shadow(2.dp),
                color = Color.LightGray,
            )

            ProfileMyOrders(navController = navController)

            CenterBannerItem(painter = painterResource(id = R.drawable.digiclub2))

            ProfileMenuSection(navController = navController)


            CenterBannerItem(painter = painterResource(id = R.drawable.digiclub1))


            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MaterialTheme.spacing.small)
                    .alpha(0.4f)
                    .shadow(2.dp),
                color = Color.LightGray,
            )
            Spacer(modifier = Modifier.height(57.dp))


        }

    } else {
        //TODO dark theme
    }

}

@Composable
fun ProfileTopBar(navController: NavHostController, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.spacing.small),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        IconButton(onClick = {
            navController.navigate(Screen.Setting.route)
        }) {
            Icon(
                painter = painterResource(
                    id = R.drawable.digi_settings
                ), contentDescription = "",
                tint = MaterialTheme.colors.selectedBottomBar
            )
        }

        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(
                Icons.Filled.Close, contentDescription = "Close",
                tint = MaterialTheme.colors.selectedBottomBar
            )
        }
    }
}

fun goToUrl(navController: NavController, url: String) {
    navController.navigate(route = Screen.WebView.route + "?url=$url ")
}

@Composable
fun ProfileHeaderSection(
    digikalaMissionOnClick: () -> Unit,
    digitWalletOnClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(MaterialTheme.spacing.mediumTwo))

    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "",
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
            modifier = Modifier
                .weight(0.49f)
                .clickable {
                    digikalaMissionOnClick()
                },
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
            modifier = Modifier
                .weight(0.49f)
                .clickable {
                    digitWalletOnClick()
                },
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
}

@Composable
fun ProfileMiddleSection(
    authOnClick: () -> Unit,
    clubOnClick: () -> Unit,
    contactUsOnClick: () -> Unit, modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = MaterialTheme.spacing.mediumTwo)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable { authOnClick() }) {
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

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable {
                clubOnClick()
            }) {
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

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable { contactUsOnClick() }) {
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

}

@Composable
fun ProfileMyOrders(navController: NavHostController) {
    Text(
        modifier = Modifier.padding(MaterialTheme.spacing.medium),
        style = MaterialTheme.typography.h3,
        fontWeight = FontWeight.Bold,
        text = stringResource(id = R.string.my_orders),
    )

    LazyRow(modifier = Modifier
        .background(Color.White)
        .clickable { navController.navigate(Screen.TabLayoutScreen.route) }
    ) {
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

}

@Composable
fun ProfileMenuSection(navController: NavHostController) {
    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.digi_plus)
            )
        },
        icon = {
            Image(
                painter = painterResource(id = R.drawable.digi_plus_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .padding(MaterialTheme.spacing.small)
            )
        },
        isHaveDivider = true,
        modifier = Modifier.clickable { }
    ) {
        Icon(
            Icons.Outlined.ChevronLeft, contentDescription = "Go to",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.settingArrow
        )
    }
    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.fav_list)
            )
        },
        icon = {
            Image(
                painter = painterResource(id = R.drawable.digi_fav_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .padding(MaterialTheme.spacing.small)
            )
        },
        isHaveDivider = true,
        modifier = Modifier.clickable {
            navController.navigate(Screen.FavoriteListScreen.route)
        }
    ) {
        Icon(
            Icons.Outlined.ChevronLeft, contentDescription = "Go to",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.settingArrow
        )
    }

    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.my_comments)
            )
        },
        icon = {
            Image(
                painter = painterResource(id = R.drawable.digi_comments_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .padding(MaterialTheme.spacing.small)
            )
        },
        isHaveDivider = true,
        modifier = Modifier.clickable { }
    ) {
        Icon(
            Icons.Outlined.ChevronLeft, contentDescription = "Go to",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.settingArrow
        )
    }
    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.addresses)
            )
        },
        icon = {
            Image(
                painter = painterResource(id = R.drawable.digi_adresses_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .padding(MaterialTheme.spacing.small)
            )
        },
        isHaveDivider = true,
        modifier = Modifier.clickable {
            navController.navigate(Screen.Addresses.route)//AddressListScreen
        }
    ) {
        Icon(
            Icons.Outlined.ChevronLeft, contentDescription = "Go to",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.settingArrow
        )
    }
    MenuSectionRowItem(
        text = {
            Text(
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.profile_data)
            )
        },
        icon = {
            Image(
                painter = painterResource(id = R.drawable.digi_profile_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .padding(MaterialTheme.spacing.small)
            )
        },
        isHaveDivider = true,
        modifier = Modifier.clickable { }
    ) {
        Icon(
            Icons.Outlined.ChevronLeft, contentDescription = "Go to",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.settingArrow
        )
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
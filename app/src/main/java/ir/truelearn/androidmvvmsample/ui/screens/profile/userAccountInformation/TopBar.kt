package ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.ui.theme.selectedBottomBar
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun UserAccountTopBar(navController: NavController){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = MaterialTheme.spacing.small, horizontal = MaterialTheme.spacing.small)
        ) {
            Row(modifier = Modifier
                , verticalAlignment = Alignment.CenterVertically
                , horizontalArrangement = Arrangement.SpaceAround
            ) {

                IconButton(onClick = {navController.navigate(Screen.Profile.route)}
                ) {
                    Icon(
                        Icons.Filled.Close
                        , contentDescription = "Back",
                        tint = MaterialTheme.colors.selectedBottomBar
                    )
                }

                Text(
                    text = stringResource(id = R.string.user_information)
                    , style = MaterialTheme.typography.h2,
                    fontWeight = FontWeight.ExtraBold
                )

            }

        }
        Spacer(modifier = Modifier
            .height(MaterialTheme.spacing.extraSmall)
            .background(MaterialTheme.colors.searchBarBg)
            .fillMaxWidth()
        )
    }

}
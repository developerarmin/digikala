package ir.truelearn.androidmvvmsample.ui.screens.comment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.Gray
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.grayCategory
import ir.truelearn.androidmvvmsample.ui.theme.spacing

var FROM_COMMENT_SCREEN = false

@Composable
fun WriteCommentView(
    image: String,
    name: String,
    id:String,
    navController: NavController,
) {

    Column(
        modifier = Modifier
            .padding(
                horizontal = MaterialTheme.spacing.semiLarge,
                vertical = MaterialTheme.spacing.medium
            )
            .clickable {
                if (MainActivity.USER_TOKEN == "null" || MainActivity.USER_TOKEN.isEmpty()) {
                    FROM_COMMENT_SCREEN = true
                    navController.navigate(Screen.Profile.route)
                } else {
                    navController.navigate(
                        route = Screen.NewComment.route + "?imageUrl=$image?productName=$name?productId=$id"
                    )
                }
            }
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Icon(
                painter = painterResource(
                    id = R.drawable.comment
                ),
                contentDescription = "",
                Modifier.size(20.dp),
            )
            Text(
                text = stringResource(R.string.write_your_comment),
                Modifier
                    .weight(1f)
                    .padding(start = 20.dp),
                color = MaterialTheme.colors.darkText,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h5,
            )
            Icon(
                painter = painterResource(id = R.drawable.expand_left),
                contentDescription = "",
                Modifier.size(24.dp),
                tint = MaterialTheme.colors.Gray
            )
        }

        Text(
            text = stringResource(R.string.comment_desc),
            Modifier
                .padding(start = MaterialTheme.spacing.large + MaterialTheme.spacing.small),
            color = MaterialTheme.colors.Gray,
            style = MaterialTheme.typography.h6,
        )
        Spacer(
            modifier = Modifier
                .padding(
                    start = MaterialTheme.spacing.large + MaterialTheme.spacing.small,
                    top = MaterialTheme.spacing.medium,
                )
                .fillMaxWidth()
                .height(1.dp)
                .background(MaterialTheme.colors.grayCategory)

        )
    }

}
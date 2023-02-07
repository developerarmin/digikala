package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.*

@Composable
fun CommentsPreview() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.semiLarge),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = stringResource(R.string.user_comments),
                color = MaterialTheme.colors.darkText,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h3,
            )
            Text(
                text = "900 " + stringResource(R.string.comment),
                color = MaterialTheme.colors.LightBlue,
                style = MaterialTheme.typography.h4,
            )

        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.small),

            ) {
            items(5) {
                VisualCommentCard()
            }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = MaterialTheme.spacing.medium),

            ) {
            items(4) {
                TextCommentCard(
                    MaterialTheme.colors.Green,
                    R.drawable.like,
                    stringResource(R.string.satisfaction)
                )
            }
            item {
                CommentShowMoreItem()
            }
        }

        WriteCommentView()
    }
}


@Composable
fun VisualCommentCard() {

    Card(
        modifier = Modifier
            .padding(
                start = MaterialTheme.spacing.medium,
            )
            .width(80.dp)
            .height(80.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = 1.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.digi_logo),
            contentDescription = ""
        )
    }
}

@Composable
fun TextCommentCard(
    colorSuggestion: Color,
    iconSuggestion: Int,
    textSuggestion: String
) {

    Card(
        modifier = Modifier
            .padding(
                start = MaterialTheme.spacing.small,
                top = MaterialTheme.spacing.medium,
                bottom = MaterialTheme.spacing.medium,
            )
            .width(260.dp)
            .height(210.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.spacing.medium)
        ) {

            Text(
                text = "عنوان",
                color = MaterialTheme.colors.darkText,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h2,
            )
            Row(
                modifier = Modifier
                    .padding(vertical = MaterialTheme.spacing.small),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    painter = painterResource(id = iconSuggestion),
                    contentDescription = "",
                    Modifier
                        .size(18.dp),
                    tint = colorSuggestion
                )
                Text(
                    text = textSuggestion,
                    Modifier
                        .padding(start = MaterialTheme.spacing.extraSmall),
                    maxLines = 1,
                    style = MaterialTheme.typography.h4,
                    color = colorSuggestion
                )
            }
            Text(
                text = "توضیحات",
                Modifier.weight(1f),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h4,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "یک ماه پیش",
                    color = MaterialTheme.colors.Gray,
                    style = MaterialTheme.typography.h4,
                )

                Icon(
                    painter = painterResource(id = R.drawable.dot),
                    contentDescription = "",
                    Modifier
                        .size(20.dp)
                        .padding(horizontal = MaterialTheme.spacing.small),
                    tint = MaterialTheme.colors.grayAlpha
                )
                Text(
                    text = "نام کاربری",
                    color = MaterialTheme.colors.Gray,
                    style = MaterialTheme.typography.h4,

                    )

            }
        }
    }
}

@Composable
fun WriteCommentView() {
    Column(
        modifier = Modifier
            .padding(
                horizontal = MaterialTheme.spacing.semiLarge,
                vertical = MaterialTheme.spacing.medium
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(
                    id = R.drawable.comment
                ),
                contentDescription = "",
                Modifier.size(24.dp),
            )
            Text(
                text = stringResource(R.string.write_your_comment),
                Modifier
                    .weight(1f)
                    .padding(start = 20.dp),
                color = MaterialTheme.colors.darkText,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h2,
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
            style = MaterialTheme.typography.h4,
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


@Composable
fun CommentShowMoreItem() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .width(180.dp)
            .height(240.dp)
            .padding(vertical = MaterialTheme.spacing.medium)

    ) {
        Icon(
            painter = painterResource(id = ir.truelearn.androidmvvmsample.R.drawable.show_more),
            contentDescription = "",
            tint = MaterialTheme.colors.DarkCyan,
            modifier = Modifier.size(40.dp, 40.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            text = stringResource(R.string.see_all),
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
        )
    }
}
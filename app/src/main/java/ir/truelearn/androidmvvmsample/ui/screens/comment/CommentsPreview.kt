package ir.truelearn.androidmvvmsample.ui.screens.comment


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.comment.CommentResponse
import ir.truelearn.androidmvvmsample.ui.theme.*

@Composable
fun CommentsPreview(
    comments: List<CommentResponse>,
    commentCount: Int
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
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
                text = "$commentCount " + stringResource(R.string.comment),
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
            itemsIndexed(comments) { index, item ->
                TextCommentCard(
                    title = item.title,
                    description = item.description,
                    userName = item.userName,
                    colorSuggestion = MaterialTheme.colors.Green,
                    iconSuggestion = R.drawable.like,
                    textSuggestion = stringResource(id = R.string.satisfaction),
                )
            }
            item {
                CommentShowMoreItem()
            }
        }

    }
}
package ir.truelearn.androidmvvmsample.ui.screens.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.category.Sub
import ir.truelearn.androidmvvmsample.ui.theme.LightCyan
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun CategoryItem(title: String, subList: List<Sub>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = MaterialTheme.spacing.medium,
                bottom = MaterialTheme.spacing.small,
                start = MaterialTheme.spacing.small,
                end = MaterialTheme.spacing.small
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small),
            text = stringResource(id = R.string.see_all),
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.LightCyan
        )
    }
    LazyRow(modifier = Modifier.background(Color.White)) {
        items(subList) { list ->
            SubCategoryItem(list)
        }
    }
}
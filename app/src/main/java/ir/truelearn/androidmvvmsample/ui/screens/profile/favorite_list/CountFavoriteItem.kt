package ir.truelearn.androidmvvmsample.ui.screens.profile.favorite_list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.SmallFont
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.ui.theme.unSelectedBottomBar

@Composable
fun CountFavoriteItem(itemCount:String){
    Row() {
        Text(
            text = stringResource(id = R.string.fav_products),
            color = MaterialTheme.colors.unSelectedBottomBar,
            fontWeight = FontWeight.SemiBold,
            style = SmallFont.body1,
            modifier = Modifier
                .padding(start = MaterialTheme.spacing.extraSmall)
                .weight(0.9f)
        )

        Text(
            text = itemCount + " " + stringResource(id = R.string.product),
            color = MaterialTheme.colors.unSelectedBottomBar,
            fontWeight = FontWeight.SemiBold,
            style = SmallFont.body1,
            modifier = Modifier.weight(0.1f)
        )
    }
}

package ir.truelearn.androidmvvmsample.ui.screens.profile

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.roundedShape
import ir.truelearn.androidmvvmsample.ui.theme.splashBg
import java.util.*

@Composable
fun ChangeLanguage() {

    val context = LocalContext.current
    val currentLang = Locale.getDefault().language
    Log.e("3636", currentLang)

    Row() {
        OutlinedButton(
            onClick = {

            },
            border = BorderStroke(1.dp, MaterialTheme.colors.splashBg),
            modifier = Modifier
                .padding(8.dp)
                .clip(MaterialTheme.roundedShape.small)
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(text = stringResource(id = R.string.change_language))
        }
    }

}


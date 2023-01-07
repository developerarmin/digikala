package ir.truelearn.androidmvvmsample.ui

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.App
import ir.truelearn.androidmvvmsample.LocaleHelper
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.splashBg
import java.util.*

@Composable
fun ChangeLanguage(){

    val context = LocalContext.current
    val currentLang = Locale.getDefault().language


    Row() {
        OutlinedButton(
            onClick = {
//                when(currentLang){
//                    "fa" -> setLanguage("en",context)
//                    "en" -> setLanguage("fa",context)
//                      }

                if(currentLang == "en"){
                    View.LAYOUT_DIRECTION_RTL
                    setLanguage("fa",context)

                } else {
                    View.LAYOUT_DIRECTION_LTR
                    setLanguage("en",context)

                }
            },
            border = BorderStroke(1.dp, MaterialTheme.colors.splashBg),
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(text = stringResource(id = R.string.change_language ))
        }
    }

}
fun setLanguage(lang:String,context: Context){
    LocaleHelper.setLocale(context,lang)
    (context as? Activity)?.recreate()

}


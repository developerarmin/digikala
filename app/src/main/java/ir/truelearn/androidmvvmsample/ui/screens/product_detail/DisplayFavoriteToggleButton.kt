package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import android.util.Log
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.data.model.home.MostDiscountedItem
import ir.truelearn.androidmvvmsample.data.model.product_detail.ProductDetailModel
import ir.truelearn.androidmvvmsample.data.model.profile.FavItem
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.digikalaRed
import ir.truelearn.androidmvvmsample.viewmodel.FavoriteListViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.math.log

@Composable
fun DisplayFavoriteToggleButton(item: FavItem, viewModel: FavoriteListViewModel = hiltViewModel()) {

    var checkedState by remember { mutableStateOf(false)}

    if (!checkedState){
        LaunchedEffect(key1 = true ){
            viewModel.isFavoriteItemExist(item.id).collectLatest {
                checkedState = it
                Log.e("363636", "DisplayFavoriteToggleButton: $it", )
            }
        }
    }

    IconToggleButton(
        checked = checkedState,
        onCheckedChange = {
            checkedState = !checkedState

            if (checkedState){
                viewModel.addFavoriteItem(item)
                Log.e("363636", "item added ${item.id}", )
            }else{
                viewModel.removeFavoriteItem(item)
                Log.e("363636", "item deleted ${item.id}", )

            }
        }
    ) {
        val transition = updateTransition(checkedState, label = "icon transition")
        val tint by transition.animateColor(label = "iconColor") { isChecked ->
            if (isChecked) Color.Red else MaterialTheme.colors.darkText
        }

        Icon(
            imageVector = if (checkedState) {
                Icons.Filled.Favorite
            } else {
                Icons.Filled.FavoriteBorder
            },
            contentDescription = "Icon",
            tint = tint,
            modifier = Modifier
                .size(27.dp)


        )
    }

}

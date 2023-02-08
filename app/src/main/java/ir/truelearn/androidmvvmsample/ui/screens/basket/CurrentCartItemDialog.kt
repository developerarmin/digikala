package ir.truelearn.androidmvvmsample.ui.screens.basket

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ShowBottomSheetDialog(showModalSheet: Boolean) {
//    val showModalSheet = rememberSaveable {
//        mutableStateOf(showModalSheet)
//    }
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = false
    )

    ModalBottomSheetLayout(sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(
            topStart = 12.dp,
            topEnd = 12.dp
        ), sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.save_product_to_cart),
                        contentDescription = null,
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = String.format(
                            stringResource(id = R.string.save_product_to_cart),
                            1
                        )
                    )
                }
                Divider()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.digi_trash),
                        contentDescription = null,
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        colorFilter = ColorFilter.tint(
                            Color(0xffb7214a)
                        )
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = String.format(
                            stringResource(id = R.string.delete_product_from_cart),
                            1
                        )
                    )
                }

            }

        })
    {
        coroutineScope.launch {
            if (showModalSheet)
                modalSheetState.show()
            else
                modalSheetState.hide()
        }
    }
}
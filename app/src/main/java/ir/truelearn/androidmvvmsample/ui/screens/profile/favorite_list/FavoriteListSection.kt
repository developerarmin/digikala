package ir.truelearn.androidmvvmsample.ui.screens.profile.favorite_list

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.profile.FavItem
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.screens.basket.EmptyBasketShopping
import ir.truelearn.androidmvvmsample.ui.screens.basket.LoginOrRegisterState
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.viewmodel.FavoriteListViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteListSection(
    navController: NavHostController,
    viewModel: FavoriteListViewModel = hiltViewModel()
) {
    var selectedItem by remember {
        mutableStateOf(FavItem("", 1, "", "", 1, "", 1.0))
    }

    var allFavoriteItems by remember {
        mutableStateOf(emptyList<FavItem>())
    }


    val isLogin = remember {
        mutableStateOf(MainActivity.USER_TOKEN)
    }

    LaunchedEffect(key1 = true) {
        viewModel.allFavoriteItems.collectLatest {
            allFavoriteItems = it
        }
    }
    val coroutineScope = rememberCoroutineScope()

    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true
    )

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetContent = {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.smallTwo))

                Text(
                    text = stringResource(id = R.string.sure_to_remove_fav_item),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = MaterialTheme.spacing.smallTwo)
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.mediumTwo))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    //remove button
                    OutlinedButton(
                        onClick = {
                            viewModel.removeFavoriteItem(selectedItem)
                            coroutineScope.launch {
                                if (modalSheetState.isVisible) {
                                    modalSheetState.hide()
                                }
                            }
                        },
                        border = BorderStroke(1.dp, color = MaterialTheme.colors.digikalaRed),
                        shape = MaterialTheme.roundedShape.semiSmall,
                        modifier = Modifier.size(width = 150.dp, height = 50.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.remove_fav_item),
                            color = MaterialTheme.colors.DigikalaDarkRed,
                            fontSize = 14.sp,
                            fontFamily = font_medium

                        )
                    }

                    //cancel button
                    OutlinedButton(
                        onClick = {
                            coroutineScope.launch {
                                if (modalSheetState.isVisible) {
                                    modalSheetState.hide()
                                }
                            }
                        },
                        border = BorderStroke(1.dp, color = MaterialTheme.colors.digikalaRed),
                        shape = MaterialTheme.roundedShape.semiSmall,
                        modifier = Modifier.size(width = 150.dp, height = 50.dp)

                    ) {
                        Text(
                            text = stringResource(id = R.string.cancel),
                            color = MaterialTheme.colors.DigikalaDarkRed,
                            fontSize = 14.sp,
                            fontFamily = font_medium
                        )
                    }

                }
            }

        }
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(MaterialTheme.spacing.small)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            item {
                Column() {
                    CountFavoriteItem(itemCount = allFavoriteItems.size.toString())
                }
            }

            if (isLogin.value == "null" || isLogin.value.isEmpty()) {
                navController.navigate(Screen.Profile.route)
            }

            if (allFavoriteItems.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.no_fav_item
                            ),
                            contentScale = ContentScale.Fit,
                            contentDescription = "",
                            modifier = Modifier
                                .height(600.dp)
                                .width(500.dp)
                        )
                    }
                }

            } else { //display fav // list

                items(allFavoriteItems) { favItem ->
                    Column() {
                        FavoriteItemCard(item = favItem, navController = navController)
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(MaterialTheme.spacing.small)
                        ) {


                            Row(
                                modifier = Modifier
                                    .weight(0.7f)
                                    .clickable {
                                        coroutineScope.launch {
                                            if (modalSheetState.isVisible)
                                                modalSheetState.hide()
                                            else
                                                modalSheetState.show()
                                            selectedItem = favItem
                                        }
                                    }
                            ) {

                                Icon(
                                    painter = painterResource(id = R.drawable.digi_trash),
                                    contentDescription = "digi trash",
                                    tint = MaterialTheme.colors.unSelectedBottomBar
                                )

                                Text(
                                    text = stringResource(id = R.string.remove_from_list),
                                    color = MaterialTheme.colors.unSelectedBottomBar,
                                    fontWeight = FontWeight.SemiBold,
                                    style = SmallFont.body1,
                                )
                            }

                            //watch and buy
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .weight(0.3f)
                                    .clickable {
                                        navController.navigate(
                                            Screen.ProductDetail.withArgs(
                                                favItem.id,
                                                true,
                                                favItem.price,
                                                favItem.discountPercent
                                            )
                                        )
                                    }

                            ) {
                                Text(
                                    text = stringResource(R.string.watch_and_buy_product),
                                    fontWeight = FontWeight.Light,
                                    style = MaterialTheme.typography.h6,
                                    color = MaterialTheme.colors.DarkCyan
                                )

                                Icon(
                                    imageVector = Icons.Filled.KeyboardArrowLeft,
                                    contentDescription = "",
                                    tint = MaterialTheme.colors.DarkCyan
                                )
                            }

                        }
                        //divider
                        Divider(
                            modifier = Modifier
                                .alpha(0.2f)
                                .padding(MaterialTheme.spacing.small),
                            color = MaterialTheme.colors.grayAlpha
                        )
                    }

                }
            }


        }

    }

}

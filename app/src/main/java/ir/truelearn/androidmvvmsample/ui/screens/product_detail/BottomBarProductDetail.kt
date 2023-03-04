package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import android.provider.SyncStateContract.Helpers
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.data.model.home.FavoriteProduct
import ir.truelearn.androidmvvmsample.data.model.product_detail.ProductDetailModel
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.DigikalaDarkRed
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper
import ir.truelearn.androidmvvmsample.util.LocaleUtils
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import ir.truelearn.androidmvvmsample.viewmodel.ProductDetailViewModel


@Composable
fun BottomBarProductDetail(
    itemPrice: Int,
    itemDiscount: Int,
    navController: NavController,
    item: ProductDetailModel,
    viewModel: CartViewModel = hiltViewModel()
) {
    val itemPriceResult =
        DigitHelper.digitByLocate(DigitHelper.digitBySeparator(itemPrice.toString()))
    val discountedItem = DigitHelper.applyDiscount(itemPrice, itemDiscount)
    val discountedItemResult =
        DigitHelper.digitByLocate(DigitHelper.digitBySeparator(discountedItem.toString()))
    var showAddToBasket by remember {
        mutableStateOf(true)
    }
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .padding(
                    horizontal = MaterialTheme.spacing.medium
                )
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(modifier = Modifier.weight(0.6f)) {
                Box(
                    modifier = Modifier
                        .width(140.dp)
                        .height(44.dp)
                        .clip(
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable {
                            showAddToBasket = false
                            var itemCart = CartItem(
                                item._id,
                                item.discountPercent,
                                item.imageSlider[0].image,
                                item.name,
                                itemPrice,
                                item.seller,
                                1,
                                CartStatus.CURRENT_CART
                            )
                            viewModel.addNewItem(itemCart)
                        }
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .wrapContentHeight(Alignment.CenterVertically),

                    ) {
                    if (showAddToBasket) {
                        Text(
                            text = "افزودن به سبد خرید",
                            color = Color.White,
                            style = MaterialTheme.typography.h4,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    color = MaterialTheme.colors.DigikalaDarkRed,
                                )
                                .padding(start = 15.dp, top = 8.dp)
                        )
                    } else {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Column(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape)
                                    .background(MaterialTheme.colors.DigikalaDarkRed),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = DigitHelper.digitByLocate("1"),
                                    modifier = Modifier.padding(5.dp),
                                    color = Color.White
                                )
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = "در سبد شما",
                                    modifier = Modifier.padding(0.dp),
                                    color = Color.LightGray,
                                    fontSize = 14.sp
                                )
                                Text(
                                    text = "مشاهده در سبد خرید",
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .clickable {
                                            navController.navigate(Screen.Basket.route)
                                        },
                                    color = MaterialTheme.colors.DigikalaDarkRed,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }
            //Spacer(modifier = Modifier.width(140.dp))
            Column(horizontalAlignment = Alignment.End) {
                Row() {
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(24.dp)
                            .background(
                                color = MaterialTheme.colors.DigikalaDarkRed,
                                shape = CircleShape
                            )
                            .wrapContentWidth(Alignment.CenterHorizontally)
                            .wrapContentHeight(Alignment.CenterVertically),

                        ) {
                        Text(
                            text = "%${DigitHelper.digitByLocate(itemDiscount.toString())}",
                            color = Color.White,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold,

                            )
                    }
                    Spacer(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.extraSmall))

                    Text(
                        text = "${itemPriceResult}${stringResource(id = R.string.price_unit)}",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.body2,
                        textDecoration = TextDecoration.LineThrough,
                    )
                }

                Text(
                    text = "${discountedItemResult}${stringResource(id = R.string.price_unit)}",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                )

            }


        }
    }
}





package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartItemCallbacks
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitByLocate
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitBySeparator

@Composable
fun CartItemCard(item: CartItem, cartItemCallbacks: CartItemCallbacks) {
    val count = remember {
        mutableStateOf(item.count)
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MaterialTheme.spacing.extraSmall)
        ) {
            //root
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.medium)
            ) {
                // more & title & count
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Filled.MoreVert,
                        contentDescription = "More Options",
                        modifier = Modifier,
                        tint = MaterialTheme.colors.darkText
                    )
                    Column(horizontalAlignment = End) {
                        Text(
                            text = stringResource(R.string.superMarketArticles),
                            style = MaterialTheme.typography.h3,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${digitBySeparator(digitByLocate("1"))}  کالا",
                            fontFamily = FontFamily(Font(R.font.iranyekan)),
                            style = TextStyle(
                                textDirection = TextDirection.ContentOrRtl,
                                color = Color.Gray
                            )
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .padding(
                            MaterialTheme.spacing.extraSmall +
                                    MaterialTheme.spacing.small
                        )
                )
                //detail & image
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(.7f),
                        horizontalAlignment = End
                    ) {
                        //product name
                        Text(
                            text = item.name,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.darkText,
                            maxLines = 2,
                            modifier = Modifier
                                .padding(vertical = MaterialTheme.spacing.extraSmall)
                        )


                        //Warranty
                        DetailRow(
                            icon = painterResource(id = R.drawable.warranty),
                            text = stringResource(R.string.articleWarranty),
                            color = MaterialTheme.colors.darkText
                        )

                        //store
                        DetailRow(
                            icon = painterResource(id = R.drawable.store),
                            text = stringResource(R.string.storeName),
                            color = MaterialTheme.colors.darkText
                        )

                        //status
                        DetailRow(
                            icon = painterResource(id = R.drawable.available),
                            text = stringResource(R.string.availableInDigiKala),
                            color = MaterialTheme.colors.DarkCyan
                        )
                        // send  detail
                        Row(modifier = Modifier.padding(end = 7.dp)) {
                            DetailRow(
                                icon = painterResource(id = R.drawable.truck),
                                text = stringResource(R.string.digiKalaSend),
                                color = MaterialTheme.colors.DigikalaDarkRed
                            )
                            Spacer(modifier = Modifier.width(15.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.circle),
                                contentDescription = "",
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .width(8.dp)
                                    .height(8.dp),
                                tint = MaterialTheme.colors.DarkCyan,

                                )
                        }


                        //fast send  detail
                        // send  detail
                        Row(modifier = Modifier.padding(end = MaterialTheme.spacing.small)) {
                            DetailRow(
                                icon = painterResource(id = R.drawable.truck),
                                text = stringResource(R.string.digiKalaSuperMarketSpeedSend),
                                color = Color.Green
                            )
                            Spacer(modifier = Modifier.width(15.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.circle),
                                contentDescription = "",
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .width(8.dp)
                                    .height(8.dp),
                                tint = MaterialTheme.colors.DarkCyan,

                                )
                        }


                    }
                    Image(
                        painter = rememberAsyncImagePainter(item.image),
                        contentDescription = "cart item Photo",
                        modifier = Modifier
                            .width(130.dp)
                            .height(90.dp)
                    )
                }

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.height(MaterialTheme.spacing.semiLarge))
                    Row(
                        modifier = Modifier
                            .align(End)
                    ) {
                        // price
                        Row() {

                            Icon(
                                painter = painterResource(id = R.drawable.toman),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(
                                        bottom = MaterialTheme.spacing.extraSmall,
                                        end = MaterialTheme.spacing.extraSmall
                                    )
                            )
                            Text(
                                text = digitBySeparator(digitByLocate(item.price.toString())),
                                fontFamily = FontFamily(Font(R.font.iranyekanbold))
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .padding(MaterialTheme.spacing.medium)
                        )
                        Surface(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .border(1.dp, Color.LightGray, RoundedCornerShape(6.dp)),
                        ) {

                            // display count
                            Row(
                                modifier = Modifier
                                    .padding(
                                        horizontal = MaterialTheme.spacing.small,
                                        vertical = MaterialTheme.spacing.extraSmall
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                if (count.value == 1) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.digi_trash),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .padding(top = MaterialTheme.spacing.extraSmall)
                                            .clickable {
                                                cartItemCallbacks.onRemoveCartItem(item)
                                            }
                                            .width(20.dp)
                                            .height(22.dp),
                                        colorResource(id = R.color.red_custom)
                                    )
                                } else {
                                    Icon(
                                        painterResource(id = R.drawable.ic_decrease_24),
                                        contentDescription = "decrease icon",
                                        modifier = Modifier.clickable {
                                            if (count.value > 1) {
                                                cartItemCallbacks.onDecreaseCartItem(
                                                    item.itemID,
                                                    --count.value
                                                )
                                            }
                                        },
                                        tint = MaterialTheme.colors.digikalaRed

                                    )
                                }
                                Text(
                                    text = digitBySeparator(digitByLocate(item.count.toString())),
                                    style = MaterialTheme.typography.body2,
                                    fontWeight = FontWeight.SemiBold,
                                    color = colorResource(id = R.color.red_custom),
                                    modifier = Modifier
                                        .padding(horizontal = MaterialTheme.spacing.medium)
                                )

                                Icon(
                                    painterResource(id = R.drawable.ic_increase_24),
                                    contentDescription = "increase icon",
                                    modifier = Modifier.clickable {
                                        cartItemCallbacks.onIncreaseCartItem(
                                            item.itemID,
                                            ++count.value
                                        )
                                    },
                                    tint = MaterialTheme.colors.digikalaRed
                                )
                            }

                        }
                    }


                    Spacer(modifier = Modifier.height(MaterialTheme.spacing.mediumTwo))
                    // save to next purchase
                    Row(
                        modifier = Modifier
                            .clickable {
                                cartItemCallbacks.onChangeStatusCart(
                                    item.itemID, CartStatus.NEXT_CART
                                )
                            }, verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Filled.KeyboardArrowLeft, contentDescription = "",
                            modifier = Modifier,
                            colorResource(id = R.color.iconColor)
                        )


                        Text(
                            text = stringResource(R.string.saveToNextList),
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.h6,
                            color = colorResource(id = R.color.iconColor)
                        )
                    }
                }
            }
        }


    }
}

@Composable
private fun DetailRow(icon: Painter, text: String, color: Color) {
    Row(
        modifier = Modifier
            .padding(vertical = MaterialTheme.spacing.extraSmall)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            style = SmallFont.body1,
            color = MaterialTheme.colors.semiDarkText,
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
        Icon(
            painter = icon,
            contentDescription = "",
            modifier = Modifier
                .width(18.dp)
                .height(18.dp),
            tint = color,

            )
    }
}
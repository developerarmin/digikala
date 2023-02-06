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
import androidx.compose.ui.Alignment
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
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitByLocate
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitBySeparator

@Composable
fun NextCartItemCard(
    item: CartItem, changeStatus: (id: String, newStatus: CartStatus) -> Unit,
    removeFromCart: (CartItem) -> Unit
) {

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
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
                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = stringResource(R.string.superMarketArticles),
                            style = MaterialTheme.typography.h3,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.darkText
                        )
                        Text(
                            text = "1 کالا",
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
                        horizontalAlignment = Alignment.End
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
                        //send detail
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
                            .align(Alignment.End)
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
                                text = digitBySeparator(
                                    digitByLocate(item.price.toString())
                                ),
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
                                .width(120.dp)
                                .height(40.dp)
                                .border(1.dp, Color.LightGray, RoundedCornerShape(6.dp)),
                        ) {

                            // display count
                            Row(
                                modifier = Modifier
                                    .padding(
                                        horizontal = MaterialTheme.spacing.small,
                                        vertical = MaterialTheme.spacing.extraSmall
                                    )
                                    .clickable {
                                        changeStatus(item.itemID, CartStatus.CURRENT_CART)
                                    },
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {

                                Icon(
                                    painter = painterResource(id = R.drawable.ic_baseline_shopping_cart_checkout),
                                    contentDescription = "",
                                    tint = colorResource(id = R.color.red_custom),
                                    modifier = Modifier
                                        .size(32.dp),
                                )
                            }

                        }
                    }


                    Spacer(modifier = Modifier.height(MaterialTheme.spacing.mediumTwo))
                    // save to next purchase
                    Row(
                        modifier = Modifier
                            .clickable {
                                removeFromCart(item)
                            }, verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Filled.KeyboardArrowLeft, contentDescription = "",
                            modifier = Modifier,
                            MaterialTheme.colors.digikalaRed
                        )


                        Text(
                            text = stringResource(R.string.deleteFromList),
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.digikalaRed
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

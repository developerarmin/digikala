package ir.truelearn.androidmvvmsample.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.home.MostDiscountedItem
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper.applyDiscount
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitByLocate
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitBySeparator

@Composable
fun SuggestionItemCard(item: MostDiscountedItem, onAddClick: (MostDiscountedItem) -> Unit) {
    Card(
        modifier = Modifier
            .width(170.dp)
            .padding(bottom = MaterialTheme.spacing.miniDp),
        shape = MaterialTheme.roundedShape.default,
        elevation = 1.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            //title && image
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.extraSmall)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                }
                Box {

                    Image(
                        painter = rememberAsyncImagePainter(item.image),
                        contentDescription = "suggested item image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        contentScale = ContentScale.Fit,
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomStart)
                            .padding(horizontal = MaterialTheme.spacing.small + MaterialTheme.spacing.extraSmall),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Surface(
                            modifier = Modifier
                                .padding(MaterialTheme.spacing.extraSmall)
                                .size(32.dp)
                                .wrapContentWidth(CenterHorizontally)
                                .wrapContentHeight(CenterVertically)
                                .clip(CircleShape)
                                .border(1.dp, MaterialTheme.colors.digikalaRed, CircleShape)
                                .clickable {
                                    onAddClick(item)
                                }
                        ) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = "add icon",
                                tint = MaterialTheme.colors.digikalaRed,
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

            //info
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.small)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(48.dp)
                        .padding(horizontal = MaterialTheme.spacing.small),
                    text = item.name,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.darkText,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                //status
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = MaterialTheme.spacing.small),
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.in_stock),
                        contentDescription = "in stock",
                        tint = MaterialTheme.colors.DigikalaInStock,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                            .padding(end = MaterialTheme.spacing.extraSmall)
                    )

                    Text(
                        text = item.seller,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.semiDarkText,
                        fontSize = 10.sp
                    )


                }
                Spacer(modifier = Modifier.height(10.dp))
                //price
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(MaterialTheme.spacing.small),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {

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
                        val discountedPercent =
                            digitByLocate(item.discountPercent.toString())
                        Text(

                            text = "${discountedPercent}%",
                            color = Color.White,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold,

                            )
                    }

                    Column {

                        val discountedPriceResult =
                            applyDiscount(item.price, item.discountPercent)
                        val discountedLocaleResult = digitByLocate(discountedPriceResult.toString())
                        val discountedSeparatedResult = digitBySeparator(discountedLocaleResult)
                        val previousDiscountedItemPrice =
                            digitBySeparator(digitByLocate(item.price.toString()))
                        Text(
                            text = "$discountedSeparatedResult ${stringResource(id = R.string.price_unit)}",
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(
                            text = previousDiscountedItemPrice,
                            color = Color.LightGray,
                            style = MaterialTheme.typography.body2,
                            textDecoration = TextDecoration.LineThrough,
                        )
                        Divider(
                            Modifier
                                .width(1.dp)
                                .alpha(0.7f)
                        )
                    }
                }
            }


        }
    }


}



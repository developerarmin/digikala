package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
fun MostDiscountedCard(discountedItem: MostDiscountedItem) {
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
                Image(
                    painter = rememberAsyncImagePainter(discountedItem.image),
                    contentDescription = "most discounted item image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    contentScale = ContentScale.Fit,
                )
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
                    text = discountedItem.name,
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
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically
                ) {

                    //inStock icon
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
                        text = discountedItem.seller,
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
                            digitByLocate(discountedItem.discountPercent.toString())
                        Text(

                            text = "${discountedPercent}%",
                            color = Color.White,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold,

                            )
                    }

                    Column {

                        val discountedPriceResult =
                            applyDiscount(discountedItem.price, discountedItem.discountPercent)
                        val discountedLocaleResult = digitByLocate(discountedPriceResult.toString())
                        val discountedSeparatedResult = digitBySeparator(discountedLocaleResult)
                        val previousDiscountedItemPrice =
                            digitBySeparator(digitByLocate(discountedItem.price.toString()))
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



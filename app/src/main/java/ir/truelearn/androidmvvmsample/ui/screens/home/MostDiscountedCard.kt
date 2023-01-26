package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.home.MostDiscountedItem
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.Constants.applyDiscount
import ir.truelearn.androidmvvmsample.util.Constants.initPriceFormat
import ir.truelearn.androidmvvmsample.util.Constants.numberWithLocate

@Composable
fun MostDiscountedCard(discountedItem: MostDiscountedItem) {
    val previousPrice = "100000"
    Card(
        modifier = androidx.compose.ui.Modifier
            .width(170.dp)
            .padding(bottom=MaterialTheme.spacing.miniDp)
        ,
        shape = MaterialTheme.roundedShape.default,
        elevation = 1.dp
    ) {
        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
        ) {

            //title && image
            Column(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.extraSmall)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(discountedItem.image),
                    contentDescription = "most discounted item image",
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    contentScale = ContentScale.Fit,
                )
            }
            Spacer(modifier = androidx.compose.ui.Modifier.height(MaterialTheme.spacing.small))

            //info
            Column(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.small)
            ) {
                Text(
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxSize()
                        .height(48.dp)
                        .padding(horizontal = MaterialTheme.spacing.small),
                    text = discountedItem.name,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.darkText,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = androidx.compose.ui.Modifier.height(MaterialTheme.spacing.small))
                //status
                Row(
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = discountedItem.seller,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.semiDarkText,
                    )
                }
                Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))
                //price
                Row(
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxWidth()
                        .padding(MaterialTheme.spacing.small),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {

                    Box(
                        modifier = androidx.compose.ui.Modifier
                            .width(40.dp)
                            .height(24.dp)
                            .background(
                                color = MaterialTheme.colors.DigikalaDarkRed,
                                shape = CircleShape
                            )
                            .wrapContentWidth(Alignment.CenterHorizontally)
                            .wrapContentHeight(Alignment.CenterVertically),

                        ) {
                        val discountedPercent = numberWithLocate(discountedItem.discountPercent.toString())
                        Text(

                            text = "${discountedPercent}%",
                            color = Color.White,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold,

                            )
                    }

                    Column() {
                        val discountedItemPrice = numberWithLocate((applyDiscount(discountedItem.price,discountedItem.discountPercent)).toString())
                        val previousDiscountedItemPrice = numberWithLocate(discountedItem.price.toString())
                        Text(
                            text = "${initPriceFormat(discountedItemPrice)} ${stringResource(id = R.string.price_unit)}",
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(
                            text = initPriceFormat(previousDiscountedItemPrice),
                            color = Color.LightGray,
                            style = MaterialTheme.typography.body2,
                            textDecoration = TextDecoration.LineThrough,
                        )
                        Divider(
                            androidx.compose.ui.Modifier
                                .width(1.dp)
                                .alpha(0.7f)
                        )
                    }
                }
            }



        }
    }


}



package ir.truelearn.androidmvvmsample.ui.screens.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper

@Composable
fun SpecialSaleCard(item: SearchProductsModel) {
    val title = "فروش ویژه"
    val name =
        item.name
    val seller = item.seller
    val rate = 3.6
    val discount = item.discountPercent
    val currentPrice =DigitHelper.applyDiscount(item.price.toInt(), item.discountPercent)
    val previousPrice =  item.price
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .padding(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.DigikalaDarkRed
        )
        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = MaterialTheme.colors.DigikalaDarkRed, thickness = 2.dp)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.image),
                contentDescription = "",
                modifier = Modifier
                    .width(120.dp)
                    .height(100.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(48.dp)
                        .padding(horizontal = 8.dp),
                    text = name,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.darkText,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //status
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.available),
                            contentDescription = "",
                            modifier = Modifier
                                .size(22.dp)
                                .padding(2.dp),
                            tint = MaterialTheme.colors.DarkCyan
                        )
                        Text(
                            text = seller,
                            fontWeight = FontWeight.SemiBold,
                            style = SmallFont.body1,
                            color = MaterialTheme.colors.semiDarkText,
                        )
                    }
//rate
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_star),
                            contentDescription = "",
                            modifier = Modifier
                                .size(22.dp)
                                .padding(2.dp),
                            tint = MaterialTheme.colors.amber
                        )
                        Text(
                            text = DigitHelper.digitByLocate(rate.toString()),
                            fontWeight = FontWeight.SemiBold,
                            style = SmallFont.body1,
                            color = MaterialTheme.colors.semiDarkText,
                        )
                    }

                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
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
                        Text(
                            text = "${DigitHelper.digitByLocate(discount.toString())}%",
                            color = Color.White,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold,

                            )
                    }

                    Column() {
                        Row() {


                            Text(
                                text = DigitHelper.digitBySeparator(
                                    DigitHelper.digitByLocate(
                                        currentPrice.toString()
                                    )
                                ),
                                style = MaterialTheme.typography.body2,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Image(
                                painter = painterResource(id = R.drawable.toman),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(MaterialTheme.spacing.semiLarge)
                                    .padding(horizontal = MaterialTheme.spacing.extraSmall)
                            )
                        }
                        Text(
                            text = DigitHelper.digitBySeparator(
                                DigitHelper.digitByLocate(
                                    previousPrice.toString()
                                )
                            ),
                            color = Color.LightGray,
                            style = MaterialTheme.typography.body2,
                            textDecoration = TextDecoration.LineThrough,
                        )
                    }


                }
            }

        }


    }
}
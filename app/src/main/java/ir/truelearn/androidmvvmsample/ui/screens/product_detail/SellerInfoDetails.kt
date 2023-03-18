package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.format.TextStyle
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.product_detail.ProductDetailModel
import ir.truelearn.androidmvvmsample.ui.component.RoundedIconBox
import ir.truelearn.androidmvvmsample.ui.screens.home.onBoxClick
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper

@Composable
fun SellerInfoDetails(item: ProductDetailModel) {
    val calculateSatisfactionPercent = calculateSatisfactionPercentage(item.star)

    Surface(
        elevation = 1.dp,
        modifier = Modifier.padding(
            top = MaterialTheme.spacing.small,
            bottom = MaterialTheme.spacing.small
        )
    ) {
        //root
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    top = MaterialTheme.spacing.small,
                    start = MaterialTheme.spacing.medium,
                    end = MaterialTheme.spacing.medium
                )

        ) {
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))

            Text(
                text = "فروشنده",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.darkText,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = MaterialTheme.spacing.small)
            )

            Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))

            //seller info
            Row(
                modifier = Modifier.padding(
                    top = MaterialTheme.spacing.small,
                    start = MaterialTheme.spacing.small,
                    end = MaterialTheme.spacing.small
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.digi_logo),
                    modifier = Modifier
                        .size(25.dp)
                        .clip(MaterialTheme.roundedShape.small), contentDescription = ""
                )

                Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

                Column {
                    Text(
                        text = stringResource(id = R.string.digikala),
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.darkText,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${DigitHelper.digitByLocate(calculateSatisfactionPercent.toString())}%" +
                                    " رضایت خریداران | عملکرد " ,
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.semiDarkText,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        showSatisfactionGrade(percentage = calculateSatisfactionPercent)
                    }



                    Spacer(
                        modifier = Modifier
                            .padding(top = MaterialTheme.spacing.small)
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(MaterialTheme.colors.grayCategory)

                    )

                }
            }


            //guarantee
            Row(
                modifier = Modifier.padding(
                    start = MaterialTheme.spacing.small,
                    end = MaterialTheme.spacing.small
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.guarantee),
                    modifier = Modifier
                        .size(30.dp)
                        .clip(MaterialTheme.roundedShape.small), contentDescription = ""
                )

                Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))

                Column {
                    Text(
                        text = stringResource(id = R.string.articleWarranty),
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.darkText,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(
                            top = MaterialTheme.spacing.medium,
                            bottom = MaterialTheme.spacing.medium
                        )
                    )

                    Spacer(
                        modifier = Modifier
//                    .padding(top = MaterialTheme.spacing.medium)
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(MaterialTheme.colors.grayCategory)

                    )

                }
            }

            //in stock
            Row(
                modifier = Modifier.padding(
                    top = MaterialTheme.spacing.small,
                    start = MaterialTheme.spacing.small,
                    end = MaterialTheme.spacing.small
                ),
                verticalAlignment = Alignment.Top
            ) {


                Image(
                    painter = painterResource(id = R.drawable.in_stock),
                    modifier = Modifier
                        .padding(top = MaterialTheme.spacing.small)
                        .size(18.dp), contentDescription = ""
                )

                Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

                Column(verticalArrangement = Arrangement.Center) {

                    Text(
                        text = item.seller,
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.darkText,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.car),
                            modifier = Modifier
                                .size(25.dp)
                                .clip(MaterialTheme.roundedShape.small), contentDescription = ""
                        )

                        Text(
                            text = stringResource(id = R.string.digiKalaSend),
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.semiDarkText,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .padding(top = MaterialTheme.spacing.small)
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(MaterialTheme.colors.grayCategory)

                    )

                }
            }

            //Digiclub
            Row(
                modifier = Modifier.padding(
                    top = MaterialTheme.spacing.small,
                    start = MaterialTheme.spacing.small,
                    end = MaterialTheme.spacing.small
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.digi_score),
                    modifier = Modifier
                        .size(20.dp), contentDescription = ""
                )

                Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

                Column {

                    Text(
                        text = stringResource(id = R.string.digiclub_score),
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.semiDarkText,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )


                    Spacer(
                        modifier = Modifier
                            .padding(top = MaterialTheme.spacing.small)
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(MaterialTheme.colors.grayCategory)

                    )

                }
            }

            //price
            Row(
                modifier = Modifier.padding(
                    top = MaterialTheme.spacing.small,
                    start = MaterialTheme.spacing.small,
                    end = MaterialTheme.spacing.small
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.exclamation_mark),
                    modifier = Modifier
                        .size(20.dp), contentDescription = ""
                )

                Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

                Column() {
                    val locatedPrice = DigitHelper.digitByLocate(item.price.toString())
                    val separatedPrice = DigitHelper.digitBySeparator(locatedPrice)

                    Text(
                        text = "قیمت تولید کننده:" +
                                " $separatedPrice تومان",
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.unSelectedBottomBar,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }


            }

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

            //better price
            Row(
                modifier = Modifier.padding(
                    top = MaterialTheme.spacing.small,
                    start = MaterialTheme.spacing.small,
                    end = MaterialTheme.spacing.small
                ), horizontalArrangement = Arrangement.End
            ) {

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = stringResource(id = R.string.better_price_suggestion),
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.unSelectedBottomBar,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Image(
                    painter = painterResource(id = R.drawable.mark),
                    modifier = Modifier
                        .size(25.dp), contentDescription = ""
                )

            }

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

        }
    }

}




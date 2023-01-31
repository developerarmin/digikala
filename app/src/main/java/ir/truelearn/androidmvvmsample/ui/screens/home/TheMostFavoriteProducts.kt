package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.home.FavoriteProduct
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper






@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TheMostPopularProducts(item:FavoriteProduct){
    val previousPrice = item.price.toString()
    val currentPrice = DigitHelper.applyDiscount(item.price, item.discountPercent)
    Card(onClick = { /*TODO*/ }, modifier = Modifier
        .height(320.dp)
        .width(160.dp)
        .background(Color.White)
        .padding(top = 2.dp, start = 2.dp)
        , shape = RoundedCornerShape(0.dp)
    ) {
        Column() {
            Image(
                painter = rememberAsyncImagePainter(item.image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                contentScale = ContentScale.FillBounds
            )
        }
        Column()
        {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .height(48.dp)
                    .padding(horizontal = 8.dp),
                text = item.name,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(10.dp))
            //status
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.seller,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.semiDarkText,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            //price
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "${
                        DigitHelper.digitBySeparator(
                            DigitHelper.digitByLocate(
                                currentPrice.toString()
                            )
                        )
                    } ${
                        stringResource(
                            id = R.string.price_unit
                        )
                    }",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.SemiBold,
                )

            }
        }

    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TheMostPopularProductsMoreItem(){
    Card(onClick = { /*TODO*/ }, modifier = Modifier
        .height(320.dp)
        .width(160.dp)
        .background(Color.White)
        .padding(start = 2.dp)
        , shape = RoundedCornerShape(0.dp)
    ){

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .padding(30.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.show_more),
                contentDescription = "",
                tint = MaterialTheme.colors.DarkCyan,
                modifier = Modifier.size(40.dp,40.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                text = "مشاهده همه",
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                fontSize = 13.sp
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TheMostPopularProductsOffer(item: FavoriteProduct) {

    val previousPrice = item.price.toString()
    val currentPrice = DigitHelper.applyDiscount(item.price, item.discountPercent)
    Card(onClick = { /*TODO*/ }, modifier = Modifier
        .height(320.dp)
        .width(160.dp)
        .background(Color.White)
        , shape = RoundedCornerShape(0.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(top = 0.dp)) {
            Image(
                painter = rememberAsyncImagePainter(item.image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .padding(top = 40.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column()
            {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(horizontal = 8.dp),
                    text = item.name,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.darkText,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(10.dp))
                //status
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = MaterialTheme.spacing.small),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
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
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                //price
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
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
                            text = "${DigitHelper.digitByLocate(item.discountPercent.toString())}%",
                            color = Color.White,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold,

                            )
                    }

                    Column() {
                        Text(
                            text = "${
                                DigitHelper.digitBySeparator(
                                    DigitHelper.digitByLocate(
                                        currentPrice.toString()
                                    )
                                )
                            } ${
                                stringResource(
                                    id = R.string.price_unit
                                )
                            }",
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(
                            text = DigitHelper.digitBySeparator(DigitHelper.digitByLocate(previousPrice)),
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

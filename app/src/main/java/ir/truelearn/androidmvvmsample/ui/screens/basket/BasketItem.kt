package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun BasketItem() {

    IconButton(onClick = { }) {
        Icon(
            Icons.Filled.MoreVert,
            contentDescription = "More Options",
            modifier = Modifier
                .padding(start = MaterialTheme.spacing.large,
                top = MaterialTheme.spacing.large),
            tint = MaterialTheme.colors.darkText
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row() {

            Column(
                modifier = Modifier
                    .padding(
                        end = MaterialTheme.spacing.large,
                        top = MaterialTheme.spacing.medium
                    ), horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = stringResource(R.string.superMarketArticles),
                    fontFamily = FontFamily(Font(R.font.iranyekanbold)),
                    fontSize = 16.sp
                )
                Text(
                    text = stringResource(R.string.oneArticle),
                    fontFamily = FontFamily(Font(R.font.iranyekan)),
                    style = TextStyle(
                        textDirection = TextDirection.ContentOrRtl,
                        color = Color.Gray
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.hamberger),
                    contentDescription = "Article Photo",
                    modifier = Modifier.padding(vertical = MaterialTheme.spacing.small)
                )

                Card(
                    modifier = Modifier
                        .width(90.dp),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Row(modifier = Modifier.padding(MaterialTheme.spacing.small)) {
                        Icon(
                            painter = painterResource(id = R.drawable.digi_trash),
                            contentDescription = "",
                            modifier = Modifier.padding(top = MaterialTheme.spacing.extraSmall),
                            colorResource(id = R.color.red_custom)
                        )

                        Text(
                            text = stringResource(R.string.count),
                            fontFamily = FontFamily(Font(R.font.iranyekanmedium)),
                            fontSize = 16.sp,
                            modifier = Modifier

                                .padding(start = MaterialTheme.spacing.medium),
                            color = colorResource(id = R.color.red_custom)
                        )

                        Text(
                            text = stringResource(R.string.increase),
                            fontFamily = FontFamily(Font(R.font.iranyekanmedium)),
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(start = MaterialTheme.spacing.medium),
                            color = colorResource(id = R.color.red_custom)
                        )
                    }
                }

            }

            Column(modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.articleName),
                    fontFamily = FontFamily(Font(R.font.iranyekanbold)),
                    fontSize = 14.sp
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            end = MaterialTheme.spacing.extraLarge +
                                    MaterialTheme.spacing.small
                        ),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.articleWarranty),
                        color = MaterialTheme.colors.darkText,
                        fontFamily = FontFamily(Font(R.font.iranyekan))
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.warranty),
                        contentDescription = "Warranty",
                        modifier = Modifier.size(MaterialTheme.spacing.semiLarge),
                        colorResource(id = R.color.black)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = MaterialTheme.spacing.extraLarge +
                                    MaterialTheme.spacing.medium
                        ),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.storeName),
                        color = MaterialTheme.colors.darkText,
                        fontFamily = FontFamily(Font(R.font.iranyekan))
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.store),
                        contentDescription = "Warranty",
                        modifier = Modifier.size(MaterialTheme.spacing.semiLarge),
                        colorResource(id = R.color.black)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.availableInDigiKala),
                        color = MaterialTheme.colors.darkText,
                        fontFamily = FontFamily(Font(R.font.iranyekanbold))
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.available),
                        contentDescription = "Warranty",
                        modifier = Modifier.size(MaterialTheme.spacing.large),
                        colorResource(id = R.color.iconColor)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = MaterialTheme.spacing.extraLarge),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.digiKalaSuperMarketSpeedSend),
                        color = MaterialTheme.colors.darkText,
                        fontFamily = FontFamily(Font(R.font.iranyekanmedium))
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.available),
                        contentDescription = "Warranty",
                        modifier = Modifier.size(MaterialTheme.spacing.large),
                        colorResource(id = R.color.iconColor)
                    )
                }

                Row() {

                    Icon(
                        painter = painterResource(id = R.drawable.toman), contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(
                                bottom = MaterialTheme.spacing.extraSmall,
                                end = MaterialTheme.spacing.extraSmall
                            )
                    )
                    Text(
                        text = stringResource(R.string.benefit),
                        fontFamily = FontFamily(Font(R.font.iranyekanbold))
                    )
                }
            }
        }


        Column(
            modifier = Modifier
                .padding(
                    vertical = MaterialTheme.spacing.superLarge +
                            MaterialTheme.spacing.superLarge + MaterialTheme.spacing.extraLarge,
                    horizontal = MaterialTheme.spacing.large
                )
        ) {

            Row {
                Icon(
                    Icons.Filled.KeyboardArrowLeft, contentDescription = "",
                    modifier = Modifier
                        .padding(top = 2.dp),
                    colorResource(id = R.color.iconColor)
                )


                Text(
                    text = stringResource(R.string.saveToNextList),
                    fontFamily = FontFamily(Font(R.font.iranyekanmedium)),
                    modifier = Modifier
                        .clickable {},
                    color = colorResource(id = R.color.iconColor)
                )
            }
        }
    }
}

@Composable
@Preview
fun BasketItemPreview() {
    BasketItem()
}
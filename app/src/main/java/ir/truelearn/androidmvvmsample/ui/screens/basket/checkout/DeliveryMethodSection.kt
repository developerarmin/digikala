package ir.truelearn.androidmvvmsample.ui.screens.basket.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem

import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.collectLatest

var showBottomSheet = mutableStateOf(false)

@Composable
fun DeliveryMethodSection(
    shippingConst: String = "20000",
    viewModel: CartViewModel = hiltViewModel()
) {
    val currentCartItems = remember {
        mutableStateOf(emptyList<CartItem>())
    }
    LaunchedEffect(true) {
        viewModel.currentCartItems.collectLatest { list ->
            currentCartItems.value = list
        }
    }
    var marsoleh = ""
    val x1 = DigitHelper.digitByLocate("1")
    var x2 = DigitHelper.digitByLocate("1")
    marsoleh = "مرسوله ${x1} از ${x2}  "

    val sendingType = "ارسال عادی"
    val objectCoun = DigitHelper.digitByLocate("1")
    val readyToSend = "اماده ارسال"

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        //.padding(MaterialTheme.spacing.extraSmall),
        horizontalAlignment = End
    ) {
        Text(
            modifier = Modifier
                .padding(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.small
                )
                .align(Alignment.Start),
            text = String.format(stringResource(id = R.string.deliveryAndTimeMethod)),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.subtitle2,
            color = Color.Black,
            fontFamily = font_bold,

            )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = MaterialTheme.spacing.medium,
                    horizontal = MaterialTheme.spacing.small,
                ),
            shape = RoundedCornerShape(7.dp),
            elevation = 3.dp,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = MaterialTheme.spacing.small
                    ),
                horizontalAlignment = End
            ) {
                Text(
                    text = marsoleh,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.Black,
                    fontFamily = font_bold,
                    modifier = Modifier
                        .align(Alignment.Start)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(20.dp),
                        tint = MaterialTheme.colors.RedColor,
                        painter = painterResource(id = R.drawable.truck_red),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
                    Text(
                        text = sendingType,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.overline,
                        color = MaterialTheme.colors.RedColor,
                        fontFamily = font_bold
                    )

                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))
                    Text(
                        text = " ${objectCoun} کالا ",
                        Modifier.padding(MaterialTheme.spacing.small),
                        style = MaterialTheme.typography.caption,
                        color = Color.Gray,
                        fontFamily = font_bold
                    )
                }
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(currentCartItems.value) { item ->
                        CheckoutProductCard(item = item)
                    }
                }
                Text(
                    text = readyToSend,
                    style = MaterialTheme.typography.caption,
                    color = Color.Gray,
                    fontFamily = font_bold,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(vertical = MaterialTheme.spacing.medium),
                )
                Row(
                    modifier = Modifier
                        .clickable { showBottomSheet.value = true }
                        .fillMaxWidth()
                        .padding(bottom = MaterialTheme.spacing.medium),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = String.format(stringResource(id = R.string.choseTimeSend)),
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.caption,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.LightBlue,
                        fontFamily = font_standard,
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "",
                        tint = MaterialTheme.colors.LightBlue,
                        modifier = Modifier
                            .size(12.dp, 12.dp)
                            .align(Alignment.CenterVertically)

                    )



                }
            }
        }



        if (showBottomSheet.value) Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) { MyBottomSheet() }
    }
}

@Composable
fun MyBottomSheet() {
    showBottomSheet.value = true

    val persian9 = DigitHelper.digitByLocate("9")
    val persian15 = DigitHelper.digitByLocate("15")
    val persian16 = DigitHelper.digitByLocate("16")
    val persian21 = DigitHelper.digitByLocate("21")
    //Temporary.Its Come From Server
    val postPrice = DigitHelper.digitByLocate("27000")

    val radioOptions = listOf("ساعت $persian9 تا $persian15 ", "ساعت $persian16 تا $persian21 ")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(4.dp))
            .border(1.dp, Color.LightGray)
            .clickable { showBottomSheet.value = !showBottomSheet.value },
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Unspecified, RectangleShape),
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround) {

                    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = End) {
                        Image(
                            painter = painterResource(id = R.drawable.truck),
                            contentDescription = "",
                            modifier = Modifier.weight(0.15f)
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = stringResource(id = R.string.leading_post_all_over_the_country), maxLines = 1)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "زمان تقریبی : یک هفته", maxLines = 1)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "هزینه:", maxLines = 1)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "$postPrice تومان ", maxLines = 1)
                    }
                }
            }


            radioOptions.forEachIndexed { _, text ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(horizontal = 16.dp, vertical = 2.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = 10.dp
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = { onOptionSelected(text) }
                        )
                        Text(text = text)
                        Spacer(modifier = Modifier.width(4.dp))
                        Column(verticalArrangement = Arrangement.SpaceAround) {
                            Spacer(modifier = Modifier.height(2.dp))
                            Image(
                                painter = painterResource(id = R.drawable.digi_plus_icon),
                                contentDescription = "",
                                modifier = Modifier.size(18.dp)
                            )
                        }
                        Text(text = stringResource(id = R.string.exclusive_to_digi_plus), color = Color(0xFFFF5722))
                        Spacer(modifier = Modifier.width(8.dp))

                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.digi_plus_icon),
                    contentDescription = "",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = stringResource(id = R.string.ranges_with_special_facilities))
            }
        }

    }
}
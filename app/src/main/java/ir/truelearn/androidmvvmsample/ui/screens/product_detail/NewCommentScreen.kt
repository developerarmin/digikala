package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.component.CircularCategoryItem
import ir.truelearn.androidmvvmsample.ui.theme.*

@Composable
fun NewCommentScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())

    ) {

        NewCommentHeader(R.drawable.pindo)

        ScoreSeekbar()

        NewCommentForm()

        RulesOfDigiText()
    }
}

@Composable
private fun ScoreSeekbar() {

    var sliderValue by remember {
        mutableStateOf(0f)
    }

    var score = sliderValue.toString()
    when (sliderValue.toInt()) {
        1 -> score = ""
        2 -> score = "خیلی بد"
        3 -> score = "بد"
        4 -> score = "معمولی"
        5 -> score = "خوب"
        6 -> score = "عالی"
        else -> {
            score = ""
        }
    }
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = MaterialTheme.spacing.small),
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.darkText,
        text = score,
        textAlign = TextAlign.Center
    )


    Slider(
        modifier = Modifier
            .padding(horizontal = MaterialTheme.spacing.large),
        value = sliderValue,
        onValueChange = { sliderValue_ ->
            sliderValue = sliderValue_
        },
        onValueChangeFinished = {
            // this is called when the user completed selecting the value
            Log.d("MainActivity", "sliderValue = $sliderValue")
        },

        valueRange = 1f..6f,
        steps = 4,
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colors.amber,
            activeTrackColor = MaterialTheme.colors.amber,
            inactiveTrackColor = MaterialTheme.colors.grayCategory,
            activeTickColor = MaterialTheme.colors.amber,
            inactiveTickColor = MaterialTheme.colors.grayAlpha
        ),

        )

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NewCommentForm() {
    var commentTitle by remember { mutableStateOf(TextFieldValue("")) }
    var commentBody by remember { mutableStateOf(TextFieldValue("")) }

    var weakPointText by remember { mutableStateOf("") }
    var strengthPointText by remember { mutableStateOf("") }
    val strengthPointList = remember {
        mutableStateListOf<String>()
    }
    val weakPointList = remember {
        mutableStateListOf<String>()
    }

    Column(
        modifier = Modifier
            .padding(horizontal = MaterialTheme.spacing.large)
    ) {

        Divider(
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.medium),
            color = MaterialTheme.colors.grayCategory,
            thickness = 1.dp,
        )

        Text(
            modifier = Modifier
                .padding(vertical = MaterialTheme.spacing.medium),
            text = "دیدگاه خود را شرح دهید",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.darkText,
        )

        Text(
            modifier = Modifier
                .padding(MaterialTheme.spacing.extraSmall),
            text = "عنوان نظر",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.darkText,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = commentTitle,
            onValueChange = { commentTitle = it },
            maxLines = 1,
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.darkText,
                backgroundColor = MaterialTheme.colors.grayCategory,
                focusedIndicatorColor = MaterialTheme.colors.CartCyan,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )

        Text(
            modifier = Modifier
                .padding(
                    top = MaterialTheme.spacing.mediumTwo,
                    start = MaterialTheme.spacing.extraSmall,
                    bottom = MaterialTheme.spacing.extraSmall,
                ),
            text = "نقاط قوت",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.darkText,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = strengthPointText,
            onValueChange = { strengthPointText = it },
            maxLines = 1,
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.darkText,
                backgroundColor = MaterialTheme.colors.grayCategory,
                focusedIndicatorColor = MaterialTheme.colors.CartCyan,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            trailingIcon = {
                IconButton(onClick = {
                    if (strengthPointText.trim().length > 1)
                        strengthPointList.add(strengthPointText)
                    strengthPointText = ""
                }) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null,
                        tint = MaterialTheme.colors.Gray
                    )
                }
            },
        )


        Surface(
            modifier = Modifier
        ) {

            FlowColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                for (item in strengthPointList) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(Dp(50f))
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(horizontal = MaterialTheme.spacing.extraSmall),

                            imageVector = Icons.Filled.Add,
                            contentDescription = null,
                            tint = MaterialTheme.colors.Green
                        )
                        Text(text = item, Modifier.weight(0.85f))
                        IconButton(onClick = {
                            strengthPointList.remove(item)

                        }) {
                            Icon(
                                painterResource(id = R.drawable.digi_trash),
                                contentDescription = null
                            )
                        }
                    }
                }
            }

        }


        Text(
            modifier = Modifier
                .padding(
                    top = MaterialTheme.spacing.mediumTwo,
                    start = MaterialTheme.spacing.extraSmall,
                    bottom = MaterialTheme.spacing.extraSmall,
                ),
            text = "نقاط ضعف",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.darkText,
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = weakPointText,
            onValueChange = { weakPointText = it },
            maxLines = 1,
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.darkText,
                backgroundColor = MaterialTheme.colors.grayCategory,
                focusedIndicatorColor = MaterialTheme.colors.CartCyan,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            trailingIcon = {
                IconButton(onClick = {
                    if (weakPointText.trim().length > 1)
                        weakPointList.add(weakPointText)
                    weakPointText = ""
                }) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null,
                        tint = MaterialTheme.colors.Gray
                    )
                }
            },
        )


        Surface(
            modifier = Modifier
        ) {

            FlowColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                for (item in weakPointList) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(Dp(50f))
                    ) {
                        Icon(
                            painterResource(id = R.drawable.minus),
                            modifier = Modifier
                                .padding(horizontal = MaterialTheme.spacing.extraSmall),
                            contentDescription = null,
                            tint = MaterialTheme.colors.digikalaRed
                        )

                        Text(text = item, Modifier.weight(0.85f))
                        IconButton(onClick = {
                            weakPointList.remove(item)

                        }) {
                            Icon(
                                painterResource(id = R.drawable.digi_trash),
                                contentDescription = null
                            )
                        }
                    }
                }
            }

        }


        Text(
            modifier = Modifier
                .padding(
                    top = MaterialTheme.spacing.mediumTwo,
                    start = MaterialTheme.spacing.extraSmall,
                    bottom = MaterialTheme.spacing.extraSmall,
                ),
            text = "متن نظر *",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.darkText,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            value = commentBody,
            onValueChange = { commentBody = it },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.darkText,
                backgroundColor = MaterialTheme.colors.grayCategory,
                focusedIndicatorColor = MaterialTheme.colors.CartCyan,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            maxLines = 3,
            minLines = 3
        )

    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = MaterialTheme.spacing.small,
                horizontal = MaterialTheme.spacing.mediumTwo
            ),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val checkedState = remember { mutableStateOf(false) }

        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = CheckboxDefaults.colors(MaterialTheme.colors.CartCyan)
        )
        Text(
            text = "ارسال دیدگاه به صورت ناشناس",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.darkText,
        )

    }

    Divider(color = MaterialTheme.colors.grayCategory, thickness = 2.dp)

    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = MaterialTheme.spacing.medium,
                horizontal = MaterialTheme.spacing.large
            ),
        onClick = { /*TODO*/ }
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.extraSmall),

            text = "ثبت دیدگاه",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.Gray
        )

    }


}

@Composable
fun RulesOfDigiText() {

    Text(
        text = buildAnnotatedString {

            withStyle(style = SpanStyle(color = MaterialTheme.colors.Gray)) {
                append("ثبت دیدگاه، به معنی موافقت با ")
            }

            pushStringAnnotation(tag = "terms", annotation = "https://google.com/policy")
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.LightCyan
                )
            ) {
                append("قوانین انتشار دیجیکالا")
            }
            withStyle(style = SpanStyle(color = MaterialTheme.colors.Gray)) {
                append("  است.")
            }
            addStringAnnotation(
                tag = "terms",
                annotation = "https://developer.android.com/jetpack/compose",
                start = 6,
                end = 21
            )
            toAnnotatedString()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MaterialTheme.spacing.large),
        fontSize = 16.sp,
        style = TextStyle(
            textAlign = TextAlign.Center
        )
    )
}


@Composable
fun NewCommentHeader(image: Int) {
    Row(
        modifier = Modifier
            .padding(
                top = MaterialTheme.spacing.extraSmall,
                start = MaterialTheme.spacing.small
            ),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = null,
//                painter = painterResource(id = R.drawable.digi_trash),
            )
        }

        Image(
            painter = rememberAsyncImagePainter(image),
            contentDescription = "",
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .padding(horizontal = MaterialTheme.spacing.small)
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "دیدگاه شما",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.darkText
            )
            Text(
                text = "ساعت مجی دیجیتال اسکمی",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.Gray
            )
        }
    }

    Divider(color = MaterialTheme.colors.grayCategory, thickness = 2.dp)

}
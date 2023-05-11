package ir.truelearn.androidmvvmsample.ui.screens.comment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.MainActivity.Companion.USER_TOKEN
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.comment.CommentRequest
import ir.truelearn.androidmvvmsample.data.model.comment.CommentResponse
import ir.truelearn.androidmvvmsample.data.model.product_detail.ColorProductDetail
import ir.truelearn.androidmvvmsample.data.model.product_detail.ImageSlider
import ir.truelearn.androidmvvmsample.data.model.product_detail.ProductDetailModel
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.viewmodel.CommentViewModel


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NewCommentForm(
    navController:NavController,
    productId: String,
    commentViewModel: CommentViewModel = hiltViewModel()
) {

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


    var form by remember {
        mutableStateOf(
            CommentRequest(
                "", "", "", "", ""
            )
        )
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
        onClick = {
            form = CommentRequest(
                USER_TOKEN, commentTitle.text, commentBody.text, productId, "samira"
            )
            commentViewModel.addNewComment(form)
            navController.popBackStack()

        }
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
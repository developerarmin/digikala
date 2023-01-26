//package ir.truelearn.androidmvvmsample.ui.screens.profile
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.runtime.*
//import ir.truelearn.androidmvvmsample.R
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.SpanStyle
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.buildAnnotatedString
//import androidx.compose.ui.text.font.Font
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.style.TextDecoration
//import androidx.compose.ui.text.style.TextDirection
//import androidx.compose.ui.text.withStyle
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import ir.truelearn.androidmvvmsample.ui.theme.selectedBottomBar
//import ir.truelearn.androidmvvmsample.ui.theme.spacing
//
//@Composable
//fun Login(){
//    Row(modifier = Modifier
//        .fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceBetween) {
//        IconButton(onClick = {}) {
//            Icon(
//                Icons.Filled.Close , contentDescription = "Close",
//                modifier = Modifier
//                    .padding(
//                        start = MaterialTheme.spacing.small,
//                        top = MaterialTheme.spacing.small
//                    ),
//                colorResource(MaterialTheme.colors.selectedBottomBar)
//            )
//        }
//
//        IconButton(onClick = { }) {
//            Icon(painter = painterResource(
//                id = R.drawable.digi_smile )
//                , contentDescription = "",
//                modifier = Modifier
//                    .padding(
//                    top = MaterialTheme.spacing.small,
//                    end = MaterialTheme.spacing.small
//                ),
//                colorResource()
//            )
//        }
//    }
//    Column(
//        modifier = Modifier.fillMaxHeight()
//    ) {
//        Image(painter = painterResource(id = R.drawable.digi_smile),
//            contentDescription = "",
//            modifier = Modifier
//                .padding(110.dp)
//                .size(200.dp))
//    }
//
//    Column(modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center){
//
//        Text(
//            modifier = Modifier.padding(
//                start = 24.dp,
//                end = 24.dp,
//                top = 128.dp
//            ),
//            text = stringResource(id = R.string.loginTxt),
//            fontSize = 15.sp,
//            textAlign = TextAlign.End,
//            fontFamily = FontFamily(Font(R.font.yekan)),
//            color = Color(0xFF4A4A4A)
//        )
//
//        PhoneNumberEditText()
//        LoginButton()
//
//        Divider(
//            color = Color(0xFFEEEEEE),
//            modifier = Modifier
//                .fillMaxWidth()
//                .width(1.dp)
//                .padding(top = 16.dp)
//        )
//
//        Text(text = buildAnnotatedString {
//            withStyle(
//                style = SpanStyle(
//                    color = Color(0xFF4A4A4A),
//                    fontFamily = FontFamily(Font(R.font.yekan)),
//                    fontSize = 11.5.sp
//                )
//            ){
//                append("با ورود و یا ثبت نام در دیجی کالا شما ")
//            }
//            withStyle(
//                style = SpanStyle(
//                    textDecoration = TextDecoration.Underline
//                )
//            ){
//                withStyle(
//                    style = SpanStyle(
//                        color = Color(0xFF4A4A4A),
//                        fontFamily = FontFamily(Font(R.font.yekan)),
//                        fontSize = 11.5.sp
//                    )
//                ){
//                    append(stringResource(id = R.string.Terms_and_rules))
//                }
//
//            }
//            withStyle(
//                style = SpanStyle(
//                    color = Color(0xFF4A4A4A),
//                    fontFamily = FontFamily(Font(R.font.yekan)),
//                    fontSize = 11.5.sp
//                )
//            ){
//                append("استفاده از سرویس های سایت دیجی کالا")
//            }
//
//        }, modifier = Modifier.padding(top = 24.dp), style = TextStyle(
//            textDirection = TextDirection.ContentOrRtl
//        )
//        )
//
//        Text(text = buildAnnotatedString {
//            withStyle(
//                style = SpanStyle(
//                    color = Color(0xFF4A4A4A),
//                    fontFamily = FontFamily(Font(R.font.yekan)),
//                    fontSize = 11.5.sp
//                )
//            ){
//                append("و ")
//            }
//
//            withStyle(
//                style = SpanStyle(
//                    color = Color(0xFF4A4A4A),
//                    fontFamily = FontFamily(Font(R.font.yekan)),
//                    fontSize = 11.5.sp,
//                    textDecoration = TextDecoration.Underline
//
//                )
//            ){
//                append("قوانین حریم خصوصی ")
//            }
//            withStyle(
//                style = SpanStyle(
//                    color = Color(0xFF4A4A4A),
//                    fontFamily = FontFamily(Font(R.font.yekan)),
//                    fontSize = 11.5.sp
//
//                )
//            ){
//                append("آن را می پذیرید.")
//            }
//        }, modifier = Modifier.padding(top = 8.dp), style = TextStyle(
//            textDirection = TextDirection.ContentOrRtl
//        ))
//    }
//}
//
//@Composable
//fun PhoneNumberEditText(){
//    var textState by remember {
//        mutableStateOf(TextFieldValue())
//    }
//    TextField(value = textState, onValueChange = {
//        textState = it
//    }, modifier = Modifier
//        .fillMaxWidth()
//        .height(83.dp)
//        .padding(start = 24.dp, end = 24.dp, top = 32.dp),
//
//        shape = RoundedCornerShape(8.dp),
//        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color(0xFFF0F0F0),
//            focusedIndicatorColor = Color(0xFF0FAAC6),
//            unfocusedIndicatorColor = Color(0xFFF0F0F0),
//            cursorColor = Color(0xFF018577),
//        ),
//
//        placeholder = {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.End
//            ) {
//
//                Text(text = "شماره موبایل یا پست الکترونیک",
//                    fontFamily = FontFamily(Font(R.font.yekan)),
//                    fontSize = 15.sp)
//            }
//
//        }, textStyle = TextStyle(
//            textDirection = TextDirection.ContentOrRtl
//        )
//    )
//}
//
//@Composable
//fun LoginButton(){
//    Button(onClick = {
//
//    }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE6113D)),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(82.dp)
//            .padding(start = 24.dp, end = 24.dp, top = 32.dp),
//        shape = RoundedCornerShape(8.dp)
//    ) {
//        Text(text = "ورود به دیجی کالا",
//            color = Color.White,
//            fontSize = 17.sp,
//            fontFamily = FontFamily(Font(R.font.yekan))
//        )
//    }
//}
//
//@Preview
//@Composable
//fun LoginPreview(){
//    Login()
//}
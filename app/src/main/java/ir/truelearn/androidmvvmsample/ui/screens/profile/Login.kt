package ir.truelearn.androidmvvmsample.ui.screens.profile

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import ir.truelearn.androidmvvmsample.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.ui.theme.*

@Composable
fun Login(){

        if (!isSystemInDarkTheme()){
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Close , contentDescription = "Close",
                        modifier = Modifier
                            .padding(
                                start = MaterialTheme.spacing.small,
                                top = MaterialTheme.spacing.small
                            ),
                        tint = MaterialTheme.colors.selectedBottomBar
                    )
                }

                IconButton(onClick = { }) {
                    Icon(painter = painterResource(
                        id = R.drawable.digi_settings )
                        , contentDescription = "",
                        modifier = Modifier
                            .padding(
                                top = MaterialTheme.spacing.small,
                                end = MaterialTheme.spacing.small
                            ),
                        tint = MaterialTheme.colors.selectedBottomBar
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxHeight()
            ) {
                Image(painter = painterResource(id = R.drawable.digi_smile),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.superLarge)
                        .size(200.dp))
            }

            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){

                Text(
                    modifier = Modifier.padding(
                        start = MaterialTheme.spacing.semiLarge,
                        end = MaterialTheme.spacing.semiLarge,
                        top = MaterialTheme.spacing.superLarge
                    ),
                    text = stringResource(id = R.string.loginTxt),
                    fontSize = 15.sp,
                    textAlign = TextAlign.End,
                    fontFamily = font_standard,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.semiDarkText
                )

                PhoneNumberEditText()
                LoginButton()

                Divider(
                    color = MaterialTheme.colors.searchBarBg,
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(1.dp)
                        .padding(top = MaterialTheme.spacing.medium)
                )

                ShowDigiKalaTermsAndRulesText(
                    fullText = stringResource(id = R.string.terms_and_rules_full),
                    underlinedText = listOf(
                        stringResource(id = R.string.terms_and_rules),
                        stringResource(id = R.string.privacy_and_rules )),
                    textColor = MaterialTheme.colors.semiDarkText,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )


            }
        }

}

@Composable
fun PhoneNumberEditText(){
    var textState by remember {
        mutableStateOf(TextFieldValue())
    }
    TextField(value = textState, onValueChange = {
        textState = it
    }, modifier = Modifier
        .fillMaxWidth()
        .height(92.dp)
        .padding(start = MaterialTheme.spacing.semiLarge,
            end = MaterialTheme.spacing.semiLarge ,
            top = MaterialTheme.spacing.medium ,
            bottom = MaterialTheme.spacing.semiLarge
        ),
        shape = MaterialTheme.roundedShape.small,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.searchBarBg,
            focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
            unfocusedIndicatorColor = MaterialTheme.colors.searchBarBg,
            cursorColor = MaterialTheme.colors.CursorColor,
        ),

        placeholder = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {

                Text(text = stringResource(id = R.string.phone_and_email),
                    fontFamily = font_standard,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

        }, textStyle = TextStyle(
            textDirection = TextDirection.ContentOrRtl
        )
    )
}

@Composable
fun LoginButton(){
    Button(onClick = {}, colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.digikalaRed),
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(
                start = MaterialTheme.spacing.semiLarge,
                end = MaterialTheme.spacing.semiLarge ,
                bottom = MaterialTheme.spacing.medium
            ),
        shape = MaterialTheme.roundedShape.small
    ) {
        Text(text = stringResource(id = R.string.digikala_entry),
            color = Color.White,
            fontFamily = font_standard,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
    }
}

@Composable
fun ShowDigiKalaTermsAndRulesText(
    fullText : String ,
    textColor : Color ,
    underlinedText : List<String>,
    underlinedTextFontWeight: FontWeight = FontWeight.Medium,
    underlinedTextDecoration : TextDecoration = TextDecoration.Underline,
    fontSize : TextUnit,
    textAlign: TextAlign
){

    Text(text = buildAnnotatedString {
        append(fullText)
        underlinedText.forEachIndexed { index, text ->
            val startIndex = fullText.indexOf(text)
            val endIndex = startIndex + text.length

            addStyle(
                style = SpanStyle(
                    fontSize = fontSize,
                    fontWeight = underlinedTextFontWeight,
                    textDecoration = underlinedTextDecoration
                ), start = startIndex, end = endIndex
            )
            addStyle(
                style = SpanStyle(
                    fontSize = fontSize,
                    fontFamily = font_standard,
                    color = textColor,
                ),
                start = 0, end = fullText.length)
        }
    } ,  modifier = Modifier.padding(MaterialTheme.spacing.small),
        style = TextStyle(textDirection = TextDirection.ContentOrRtl), textAlign = textAlign)


}

@Preview
@Composable
fun LoginPreview(){
    Login()
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun LoginScreenDarkPreview() {
    Login()
}
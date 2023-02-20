package ir.truelearn.androidmvvmsample.ui.screens.checkout


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.viewmodel.AddressListViewModel
import ir.truelearn.androidmvvmsample.viewmodel.SaveAddressViewModel

@Composable
fun SetTextField(
    flag: Int = 1,
    str: String,
    maxLines:Int=1
): String {

    var text by remember { mutableStateOf(TextFieldValue(str)) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MaterialTheme.spacing.medium),
        shape = MaterialTheme.roundedShape.small,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = textFieldBG,
            focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
            unfocusedIndicatorColor = textFieldBG,
            cursorColor = MaterialTheme.colors.CursorColor,
        ),
        textStyle = TextStyle(
            textDirection = TextDirection.ContentOrRtl
        ),
        maxLines = maxLines,
        // keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
    return text.text
}

@Composable
fun inputCheckbox(
    viewModel: SaveAddressViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { viewModel.inputCheckboxState = !viewModel.inputCheckboxState }
            .padding(
                bottom = MaterialTheme.spacing.small,
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = viewModel.inputCheckboxState,
            onCheckedChange = {
                viewModel.inputCheckboxState = it
            }
        )
        Text(
            text = "گیرنده سفارش خودم هستم",
            modifier = Modifier,
            fontFamily = font_standard,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
    }
}

@Composable
fun SetAddressButton(text: String, color:Color,onClick: () -> Unit) {

    Button(
        onClick = {onClick()},
        colors = ButtonDefaults.buttonColors(backgroundColor = BtnWhite),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = MaterialTheme.spacing.medium
            ),
        border = BorderStroke(width = 1.dp, color = color),
        shape = MaterialTheme.roundedShape.small
    )
    {
        Text(
            text = text,
            color =color,
            fontFamily = font_bold,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
    }
}


//@Composable
//fun inputPostalAddressEditText(
//    viewModel: CartViewModel = hiltViewModel()
//) {
//    TextField(
//        value = viewModel.inputPostalAddressState, onValueChange = {
//            viewModel.inputPostalAddressState = it
//        }, modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = MaterialTheme.spacing.medium),
//        shape = MaterialTheme.roundedShape.small,
//        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = Color.LightGray,
//            focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
//            unfocusedIndicatorColor = Color.LightGray,
//            cursorColor = MaterialTheme.colors.CursorColor,
//        ),
//        textStyle = TextStyle(
//            textDirection = TextDirection.ContentOrRtl
//        )
//    )
//}
//
//
//@Composable
//fun zipCodeEditText(
//    viewModel: CartViewModel = hiltViewModel()
//) {
//    TextField(
//        value = viewModel.inputZipCodeState, onValueChange = {
//            viewModel.inputZipCodeState = it
//        }, modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = MaterialTheme.spacing.medium),
//        shape = MaterialTheme.roundedShape.small,
//        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = Color.LightGray,
//            focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
//            unfocusedIndicatorColor = Color.LightGray,
//            cursorColor = MaterialTheme.colors.CursorColor,
//        ),
//        textStyle = TextStyle(
//            textDirection = TextDirection.ContentOrRtl
//        ),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//    )
//}


//@Composable
//fun inputNumberEditText(
//    viewModel: CartViewModel = hiltViewModel()
//) {
//    TextField(
//        value = viewModel.inputNumberState, onValueChange = {
//            viewModel.inputNumberState = it
//        }, modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = MaterialTheme.spacing.medium),
//        shape = MaterialTheme.roundedShape.small,
//        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = Color.LightGray,
//            focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
//            unfocusedIndicatorColor = Color.LightGray,
//            cursorColor = MaterialTheme.colors.CursorColor,
//        ),
//        textStyle = TextStyle(
//            textDirection = TextDirection.ContentOrRtl
//        ),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//    )
//}
//
//
//@Composable
//fun inputUnitEditText(
//    viewModel: CartViewModel = hiltViewModel()
//) {
//    TextField(
//        value = viewModel.inputUnitState, onValueChange = {
//            viewModel.inputUnitState = it
//        }, modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = MaterialTheme.spacing.medium),
//        shape = MaterialTheme.roundedShape.small,
//        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = Color.LightGray,
//            focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
//            unfocusedIndicatorColor = Color.LightGray,
//            cursorColor = MaterialTheme.colors.CursorColor,
//        ),
//        textStyle = TextStyle(
//            textDirection = TextDirection.ContentOrRtl
//        ),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//    )
//}


//
//@Composable
//fun inputRecipientNameEditText(
//    viewModel: CartViewModel = hiltViewModel()
//) {
//    TextField(
//        value = viewModel.inputRecipientNameState,
//        onValueChange = {
//            viewModel.inputRecipientNameState = it
//        },
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = MaterialTheme.spacing.medium),
//        shape = MaterialTheme.roundedShape.small,
//        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = Color.LightGray,
//            focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
//            unfocusedIndicatorColor = Color.LightGray,
//            cursorColor = MaterialTheme.colors.CursorColor,
//        ),
//        textStyle = TextStyle(
//            textDirection = TextDirection.ContentOrRtl
//        ),
//    )
//}
//
//
//@Composable
//fun inputRecipientPhoneEditText(
//    viewModel: CartViewModel = hiltViewModel()
//) {
//    TextField(
//        value = viewModel.inputRecipientPhoneState, onValueChange = {
//            viewModel.inputRecipientPhoneState = it
//        }, modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = MaterialTheme.spacing.medium),
//        shape = MaterialTheme.roundedShape.small,
//        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = Color.LightGray,
//            focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
//            unfocusedIndicatorColor = Color.LightGray,
//            cursorColor = MaterialTheme.colors.CursorColor,
//        ),
//        textStyle = TextStyle(
//            textDirection = TextDirection.ContentOrRtl
//        ),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
//    )
//}





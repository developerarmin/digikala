package ir.truelearn.androidmvvmsample.ui.screens.comment

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.screens.product_detail.RulesOfDigikala
import ir.truelearn.androidmvvmsample.ui.screens.product_detail.ScoreSeekbar
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import ir.truelearn.androidmvvmsample.viewmodel.CommentViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

@Composable
fun NewCommentScreen(
    navController: NavController,
    imageUrl: String,
    productName: String,
    productId: String,
    commentViewModel: CommentViewModel = hiltViewModel()
) {

    var message by remember { mutableStateOf("") }
    var waitingDialogState by remember { mutableStateOf(false) }

    LaunchedEffect(Dispatchers.IO) {
        commentViewModel.commentResponse.collectLatest { result ->
            result?.let {
                when (result) {
                    is NetworkResult.Success -> {
                        message = result.message.toString()
                        waitingDialogState = false
                    }

                    is NetworkResult.Error -> {
                        waitingDialogState = false
                        message = result.message.toString()
                    }

                    is NetworkResult.Loading -> {
                        waitingDialogState = true
                    }
                }
            }

        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())

    ) {

        NewCommentHeader(navController, imageUrl, productName)

        ScoreSeekbar()

        NewCommentForm(navController,productId)

        RulesOfDigikala()
    }
}






package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.comment.CommentRequest
import ir.truelearn.androidmvvmsample.data.model.comment.CommentResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.CommentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(private val repository: CommentRepository) :
    ViewModel() {

    val commentResponse =
        MutableStateFlow<NetworkResult<String>?>(null)

     fun addNewComment(commentRequest: CommentRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            launch {
                commentResponse.emit(repository.setNewComment(commentRequest))
            }
        }


    }
}
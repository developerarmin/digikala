package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.model.comment.CommentRequest
import ir.truelearn.androidmvvmsample.data.remote.ApiInterface
import ir.truelearn.androidmvvmsample.data.remote.BaseApiResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import javax.inject.Inject

class CommentRepository @Inject constructor(private val api: ApiInterface) : BaseApiResponse() {

    suspend fun setNewComment(commentRequest:CommentRequest): NetworkResult<String> =

        safeApiCall {
           api.setNewComment(commentRequest)
        }


}
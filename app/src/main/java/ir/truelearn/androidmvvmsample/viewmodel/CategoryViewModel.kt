package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.category.MainCategory
import ir.truelearn.androidmvvmsample.data.model.category.SubCategory
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository) : ViewModel() {
    val subCategory = MutableStateFlow<NetworkResult<SubCategory>>(NetworkResult.Loading())
    val categories_im = MutableStateFlow<NetworkResult<List<MainCategory>>>(NetworkResult.Loading())

    suspend fun getAllDataFromServer() {
        viewModelScope.launch() {

            launch {
                subCategory.emit(repository.getSubCategories())
            }
            launch {
                categories_im.emit(repository.getCategories_im())
            }

        }
    }

}
package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.category.SubCategory
import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.home.BestSellerItem
import ir.truelearn.androidmvvmsample.data.model.home.Slider
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.CategoryRepository
import ir.truelearn.androidmvvmsample.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository) : ViewModel() {
    val subCategory = MutableStateFlow<NetworkResult<SubCategory>>(NetworkResult.Loading())


    suspend fun getAllDataFromServer() {
        viewModelScope.launch(Dispatchers.Main) {
            val amazingResult = async { repository.getSubCategories() }

            subCategory.emit(amazingResult.await())

        }
    }

}
package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val repository : HomeRepository) : ViewModel() {
    val productList = MutableStateFlow<NetworkResult<List<SearchProductsModel>>> (NetworkResult.Loading())

    suspend fun getAllDataFromServer(
        pageSize: String ,
        pageNumber : String ,
        searchValue : String
    ) {
        viewModelScope.launch {
            launch {
                productList.emit(repository.searchProductByBrand(pageSize,pageNumber,searchValue))
            }
        }
    }


}
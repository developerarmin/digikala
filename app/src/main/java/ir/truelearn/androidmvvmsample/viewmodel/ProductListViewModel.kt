package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.ProductDataSource
import ir.truelearn.androidmvvmsample.data.model.ResponseResult
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val repository : HomeRepository) : ViewModel() {


    val productList = Pager(
        PagingConfig(pageSize = 10)
    ) {
        ProductDataSource(repository)
    }.flow.cachedIn(viewModelScope)

}

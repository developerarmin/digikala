package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.AmazingItem
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val amazingItems = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())

    suspend fun getAmazingItems() {
        viewModelScope.launch(Dispatchers.Main) {
            amazingItems.emit(repository.getAmazingItems())
        }
    }
}
package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.Slider
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    val amazingItems = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())

    suspend fun getAllDataFromServer() {
        viewModelScope.launch {
            val amazingResult = async {repository.getAmazingItems()}
            val sliderResult = async { repository.getSlider() }

            //Use results amazing and slider and ... here
            processData(amazingResult.await(), sliderResult.await())
        }
    }

    private fun processData(
        amazingResult: NetworkResult<List<AmazingItem>>,
        sliderResult: NetworkResult<List<Slider>>
    ) {
        amazingItems.value = amazingResult
        slider.value = sliderResult
    }
}
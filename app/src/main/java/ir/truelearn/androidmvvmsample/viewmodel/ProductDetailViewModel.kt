package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.repository.HomeRepository
import ir.truelearn.androidmvvmsample.repository.ProductDetailRepository
import javax.inject.Inject
@HiltViewModel
class ProductDetailViewModel @Inject constructor(private val repository: ProductDetailRepository) : ViewModel() {
}
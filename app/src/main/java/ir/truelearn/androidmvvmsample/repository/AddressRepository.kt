package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.db.AddressDao
import ir.truelearn.androidmvvmsample.data.db.CartDao
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.data.model.checkout.CartAddress
import ir.truelearn.androidmvvmsample.data.model.home.MostDiscountedItem
import ir.truelearn.androidmvvmsample.data.remote.ApiInterface
import ir.truelearn.androidmvvmsample.data.remote.BaseApiResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import javax.inject.Inject


class AddressRepository @Inject constructor(private val addressDao: AddressDao)  {

    val getAllAddress = addressDao.getAllAddress()

    suspend fun addNewAddress(address: CartAddress) {
        addressDao.addNewAddress(address)
    }





}
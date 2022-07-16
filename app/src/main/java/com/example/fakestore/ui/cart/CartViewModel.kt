package com.example.fakestore.ui.cart

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.model.product.CategoryResponse
import com.example.fakestore.model.product.ProductResponse
import com.example.fakestore.model.product.ProductResponseItem
import com.example.fakestore.repository.ProductRepository
import com.example.fakestore.ui.home.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private var repository: ProductRepository) : ViewModel() {
    private val _response = MutableLiveData<ProductResponse>()
    val responseProductItem: LiveData<ProductResponse>
        get() = _response

    init {
        getAllProductToCart()
    }

    private fun getAllProductToCart() = viewModelScope.launch {
        repository.getAllProducts().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d(TAG, "getAllProducts: Error: ${response.code()}")
            }
        }
    }
}
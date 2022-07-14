package com.example.fakestore.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.model.CategoryResponse
import com.example.fakestore.model.ProductResponseItem
import com.example.fakestore.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "HomeViewModel"

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {


    //private val categoryResponse: MutableLiveData<CategoryResponse?> = MutableLiveData()
    val categoryResponse = MutableLiveData<CategoryResponse>()
    val categoryResponseItem: LiveData<CategoryResponse>
        get() = categoryResponse

    private val _response = MutableLiveData<List<ProductResponseItem>>()
    val responseProductItem: LiveData<List<ProductResponseItem>>
        get() = _response

    init {
        getAllProducts()
        getAllCategories()
    }

    private fun getAllCategories() = viewModelScope.launch {
        repository.getAllCategories().let { response ->
            if (response.isSuccessful) {
                categoryResponse.postValue(response.body())
            } else {
                Log.d(TAG, "getAllCategories: Error: ${response.code()}")
            }
        }
    }

    private fun getAllProducts() = viewModelScope.launch {
        repository.getAllProducts().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d(TAG, "getAllProducts: Error: ${response.code()}")
            }
        }
    }
}
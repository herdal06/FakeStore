package com.example.fakestore.repository

import com.example.fakestore.api.ApiService
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllProducts() = apiService.getAllProducts()
}
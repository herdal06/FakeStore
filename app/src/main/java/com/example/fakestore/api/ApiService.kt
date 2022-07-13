package com.example.fakestore.api

import com.example.fakestore.model.Category
import com.example.fakestore.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getAllProducts(): Response<ProductResponse>

    @GET("categories")
    suspend fun getAllCategories(): Response<Category>
}
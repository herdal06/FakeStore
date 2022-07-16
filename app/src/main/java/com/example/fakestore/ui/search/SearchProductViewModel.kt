package com.example.fakestore.ui.search

import androidx.lifecycle.ViewModel
import com.example.fakestore.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchProductViewModel @Inject constructor(private val repository: ProductRepository) :
    ViewModel() {
}
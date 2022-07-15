package com.example.fakestore.utils

import android.graphics.Color
import android.widget.TextView
import com.example.fakestore.enum.ProductCategoryEnums

fun TextView.changeBackgroundColor(value: String) {
    when (value) {
        ProductCategoryEnums.CATEGORY_ELECTRONICS.value -> this.setBackgroundColor(
            Color.parseColor("#E2F8F2")
        )
        ProductCategoryEnums.CATEGORY_JEWELERY.value -> this.setBackgroundColor(
            Color.parseColor("#63EADD")
        )
        ProductCategoryEnums.CATEGORY_MEN.value -> this.setBackgroundColor(
            Color.parseColor("#87EA63")
        )
        ProductCategoryEnums.CATEGORY_WOMEN.value -> this.setBackgroundColor(
            Color.parseColor("#DDB4E6")
        )
    }
}
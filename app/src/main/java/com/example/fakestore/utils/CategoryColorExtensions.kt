package com.example.fakestore.utils

import android.graphics.Color
import android.widget.TextView
import com.example.fakestore.enum.ProductCategoryEnums
import com.example.fakestore.model.ProductResponseItem

fun ProductResponseItem.changeCategoryColor(product: ProductResponseItem, textView: TextView) {
    when (product.category) {
        ProductCategoryEnums.CATEGORY_ELECTRONICS.value -> textView.setBackgroundColor(
            Color.parseColor("#E2F8F2")
        )
        ProductCategoryEnums.CATEGORY_JEWELERY.value -> textView.setBackgroundColor(
            Color.parseColor("#63EADD")
        )
        ProductCategoryEnums.CATEGORY_MEN.value -> textView.setBackgroundColor(
            Color.parseColor("#87EA63")
        )
        ProductCategoryEnums.CATEGORY_WOMEN.value -> textView.setBackgroundColor(
            Color.parseColor("#DDB4E6")
        )
    }
}

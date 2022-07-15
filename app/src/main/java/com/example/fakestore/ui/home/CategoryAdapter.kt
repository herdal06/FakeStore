package com.example.fakestore.ui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakestore.R
import com.example.fakestore.databinding.ItemCategoryBinding
import com.example.fakestore.enum.ProductCategoryEnums
import com.example.fakestore.model.CategoryResponse
import com.example.fakestore.utils.changeCategoryColor

class CategoryAdapter :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private var categoryList = CategoryResponse()


    inner class CategoryViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentCategory = categoryList[position]
        holder.binding.apply {
            textViewCategory.text = currentCategory
            currentCategory.changeCategoryColor(currentCategory,textViewCategory)
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun setList(newList: CategoryResponse) {
        categoryList.clear()
        categoryList.addAll(newList)
        notifyDataSetChanged()
    }
}
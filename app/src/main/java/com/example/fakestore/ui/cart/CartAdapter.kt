package com.example.fakestore.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakestore.databinding.ItemBagProductBinding
import com.example.fakestore.model.product.ProductResponse
import com.example.fakestore.utils.loadImage

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private var productList = ProductResponse()

    class CartViewHolder(val binding: ItemBagProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            ItemBagProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentProduct = productList[position]
        holder.binding.apply {
            textViewProductNameBag.text = currentProduct.title
            textViewProductPriceBag.text = currentProduct.price.toString()
            imageViewProduct.loadImage(currentProduct.image)
        }
    }

    override fun getItemCount() = productList.size

    fun setList(newList: ProductResponse) {
        productList.clear()
        productList.addAll(newList)
        notifyDataSetChanged()
    }
}
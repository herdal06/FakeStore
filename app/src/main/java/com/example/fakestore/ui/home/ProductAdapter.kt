package com.example.fakestore.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fakestore.databinding.ItemProductBinding
import com.example.fakestore.model.product.ProductResponseItem
import com.example.fakestore.utils.loadImage

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<ProductResponseItem>() {
        override fun areItemsTheSame(
            oldItem: ProductResponseItem,
            newItem: ProductResponseItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductResponseItem,
            newItem: ProductResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var productList: List<ProductResponseItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentProduct = productList[position]

        holder.binding.apply {
            textViewProductName.text = currentProduct.title.substring(0, 15) + "..."
            textViewProductPrice.text = "$" + currentProduct.price.toString()
            ratingBar.rating = currentProduct.rating.rate.toFloat()
            textViewRatingCount.text = "(" + currentProduct.rating.count.toString() + ")"
            imageViewProduct.loadImage(currentProduct.image)
        }

        holder.itemView.setOnClickListener { mView ->
            val direction =
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(currentProduct)
            mView.findNavController().navigate(direction)
        }
    }

    override fun getItemCount() = productList.size
}
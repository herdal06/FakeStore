package com.example.fakestore.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.fakestore.databinding.FragmentDetailsBinding
import com.example.fakestore.model.ProductResponseItem
import com.example.fakestore.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var product: ProductResponseItem

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
        getArgs()
    }

    private fun getArgs() {
        product = args.product
        populateUI()
    }

    private fun populateUI() {
        binding.apply {
            product.let { product ->
                textViewTitleDetails.text = product.title
                textViewPriceDetails.text = product.price.toString()
                textViewCategoryDetails.text = product.category
                textViewRate.text = product.rating.rate.toString()
                textViewDescription.text = product.description
                imageViewProductDetails.loadImage(product.image)
            }
        }
    }
}
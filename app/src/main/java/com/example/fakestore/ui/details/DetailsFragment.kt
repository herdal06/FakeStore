package com.example.fakestore.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.fakestore.databinding.FragmentDetailsBinding
import com.example.fakestore.model.product.ProductResponseItem
import com.example.fakestore.utils.changeBackgroundColor
import com.example.fakestore.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var product: ProductResponseItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()
    }

    private fun getArgs() {
        product = args.product
        populateUI()
    }

    private fun populateUI() {
        binding.apply {
            textViewCategoryDetails.changeBackgroundColor(product.category)
            product.let { product ->
                textViewTitleDetails.text = product.title
                textViewPriceDetails.text = "$" + product.price.toString()
                textViewCategoryDetails.text = product.category
                ratingBarDetails.rating = product.rating.rate.toFloat()
                textViewDescription.text = product.description
                textViewRatingCountDetails.text = product.rating.count.toString() + " ratings"
                imageViewProductDetails.loadImage(product.image)
            }
        }
    }
}
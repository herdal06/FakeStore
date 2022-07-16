package com.example.fakestore.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakestore.databinding.FragmentCartBinding
import com.example.fakestore.model.product.ProductResponseItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val viewModel: CartViewModel by viewModels()
    private val args: CartFragmentArgs by navArgs()
    private lateinit var cartAdapter: CartAdapter
    private lateinit var product: ProductResponseItem

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerViewCart()
        observeLiveData()
        getArgs()
    }

    private fun getArgs() {
        product = args.product
    }

    private fun observeLiveData() {
        viewModel.responseProductItem.observe(viewLifecycleOwner, Observer {
            cartAdapter.setList(it)
        })
    }

    private fun setupRecyclerViewCart() {
        cartAdapter = CartAdapter()
        binding.recyclerViewCart.apply {
            adapter = cartAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
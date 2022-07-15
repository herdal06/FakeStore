package com.example.fakestore.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.fakestore.databinding.FragmentHomeBinding
import com.example.fakestore.model.ProductResponseItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeAdapter.ProductClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels()
    private var homeAdapter =  HomeAdapter()
    private lateinit var categoryAdapter: CategoryAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerViewProducts()
        setupRecyclerViewCategories()
        observeLiveData()
    }

    private fun setupRecyclerViewCategories() {
        categoryAdapter = CategoryAdapter()
        binding.recyclerViewCategories.apply {
            adapter = categoryAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }

    private fun setupRecyclerViewProducts() {
        homeAdapter.productClickListener = this@HomeFragment
        binding.apply {
            recyclerViewProducts.apply {
                setHasFixedSize(true)
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                adapter = homeAdapter
            }
        }
    }

    private fun observeLiveData() {
        viewModel.responseProductItem.observe(requireActivity()) {
            homeAdapter.productList = it
        }

        viewModel.categoryResponseItem.observe(viewLifecycleOwner, Observer {
            categoryAdapter.setList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onProductClicked(product: ProductResponseItem?) {
        product?.let {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it)
            )
        }
    }
}
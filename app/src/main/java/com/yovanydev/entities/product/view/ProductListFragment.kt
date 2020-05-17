package com.yovanydev.entities.product.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.yovanydev.R
import com.yovanydev.databinding.FragmentProductListBinding
import com.yovanydev.entities.product.model.Product
import com.yovanydev.entities.product.viewmodel.ProductViewModel

class ProductListFragment : Fragment() {

    lateinit var productViewModel: ProductViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)

        setupBindings(savedInstanceState, activity as ProductActivity)

        return view
    }

    private fun setupBindings(savedInstanceState: Bundle?, activity: ProductActivity) {
        val binding : FragmentProductListBinding = DataBindingUtil.setContentView(activity, R.layout.fragment_product_list)

        val application = activity.application
        val productModelFactory = ProductModelFactory(application)

        productViewModel = ViewModelProviders.of(this, productModelFactory).get(ProductViewModel::class.java)
        binding.model = productViewModel

        val handlers = ProductHandlers(productViewModel)
        binding.handlers = handlers

        setupListUpdate()
    }

    private fun setupListUpdate() {
        productViewModel.getProducts()?.observe(this, Observer { products : List<Product> ->
            productViewModel.setProductsInRecyclerAdapter(products)
        })
    }

    class ProductHandlers(private val productViewModel: ProductViewModel){
        fun onClickAddProduct(view: View) {
            productViewModel.saveProduct(Product("Product",1, 34.4f, 32.3f, 2f, 4, 80000f, 100000f, 180000f))
        }
    }

}

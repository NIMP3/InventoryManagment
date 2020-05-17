package com.yovanydev.entities.product.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yovanydev.R
import com.yovanydev.utilities.FragmentUtility

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        FragmentUtility.launchFragment(supportFragmentManager, ProductListFragment(), R.id.product_activity )
    }
}

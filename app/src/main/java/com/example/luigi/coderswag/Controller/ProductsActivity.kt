package com.example.luigi.coderswag.Controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.luigi.coderswag.Adapters.ProductsAdapter
import com.example.luigi.coderswag.R
import com.example.luigi.coderswag.Services.DataService
import com.example.luigi.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        var spanCount = 2
        val orientation = resources.configuration.orientation
        val screenSize = resources.configuration.screenWidthDp

        if (orientation == Configuration.ORIENTATION_LANDSCAPE || screenSize > 720) {
            spanCount = 3
        } else if (screenSize > 720 && orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 4
        }


        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager

        productListView.adapter = adapter
    }
}

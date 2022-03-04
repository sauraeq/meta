package com.metaled.ProductModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.metaled.HomeModule.Adapters.ProductAdapter
import com.metaled.ProductModule.Adapters.ProductAdapterNew
import com.metaled.R
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_dashboard.rvproducts
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.header_layout.*

class ProductActivity : AppCompatActivity() {
    lateinit var productss:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        tvTitle.setText(resources.getText(R.string.products))
        rlBack.setOnClickListener {
            onBackPressed()
        }
        productss=ArrayList()
        productss.add("")
        productss.add("")
        productss.add("")
        productss.add("")
        setProduct()
    }
    fun setProduct(){
        rvProdList.layoutManager = LinearLayoutManager(this)

        rvProdList.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvProdList.adapter= ProductAdapterNew(this, productss)
    }
}
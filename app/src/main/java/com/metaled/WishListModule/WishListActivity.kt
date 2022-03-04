package com.metaled.WishListModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.metaled.ProductModule.Adapters.ProductAdapterNew
import com.metaled.R
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.header_layout.*

class WishListActivity : AppCompatActivity() {
    lateinit var productss:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wish_list)
        tvTitle.setText(resources.getText(R.string.wish))
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
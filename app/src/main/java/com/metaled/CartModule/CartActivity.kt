package com.metaled.CartModule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.metaled.Payment.Payment_activity
import com.metaled.R
import kotlinx.android.synthetic.main.activity_cart2.*

import kotlinx.android.synthetic.main.activity_customize_screen.*
import kotlinx.android.synthetic.main.activity_customize_screen.rlBack
import kotlinx.android.synthetic.main.activity_customize_screen.tvTitle
import kotlinx.android.synthetic.main.header_layout.*

class CartActivity : AppCompatActivity() {


    lateinit var clist:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart2)
        tvTitle.setText(resources.getText(R.string.cart))

        clist= ArrayList()
        clist.add("")
        clist.add("")
        clist.add("")
        clist.add("")
        clist.add("")
        clist.add("")

        seList()
        rlBack.setOnClickListener {
           onBackPressed()
        }

        tvNext.setOnClickListener {
            val intent=Intent(this,Payment_activity::class.java)
            startActivity(intent)
        }
    }

    fun seList(){
        rvCart.layoutManager = LinearLayoutManager(this)
        rvCart.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvCart.adapter= CartAdapter(this, clist)

            rlBack.setOnClickListener() {
                onBackPressed()
            }
    }





}
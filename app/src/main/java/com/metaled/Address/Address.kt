package com.metaled.Address

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.metaled.Add_Address.Add_Address

import com.metaled.Payment.PaymentAdapter
import com.metaled.Payment.PaymentSaveAdapter
import com.metaled.R
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.address2.*
import kotlinx.android.synthetic.main.payment_done_popup.*

class Address :  AppCompatActivity() {
    lateinit var list_adress: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        list_adress = ArrayList()
        list_adress.add("")
        list_adress.add("")

        addressList()


        tv_add_new_address1.setOnClickListener {
            intent= Intent(this,Add_Address::class.java)
            startActivity(intent)
        }

    }

    private fun addressList() {
        rv_payment_address.layoutManager = LinearLayoutManager(this)
        rv_payment_address.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rv_payment_address.adapter= PaymentSaveAdapter(this, list_adress)
    }

}





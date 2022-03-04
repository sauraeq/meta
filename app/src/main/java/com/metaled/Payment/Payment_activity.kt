package com.metaled.Payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

import com.metaled.Address.Address
import com.metaled.DashBoardModule.DashboardActivity

import com.metaled.R
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.payment_done_popup.*

class Payment_activity : AppCompatActivity() {
    lateinit var list_payment:ArrayList<String>
    lateinit var list_payment1:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        list_payment= ArrayList()
        list_payment.add("")
        list_payment.add("")
        list_payment.add("")
        list_payment.add("")

        seList()


        list_payment1= ArrayList()
        list_payment1.add("")
        list_payment1.add("")
        list_payment1.add("")



        seList1()

        buton_payment.setOnClickListener()
        {

            payment_done_popup.visibility = View.VISIBLE
            okay_button.setOnClickListener()
            {

                intent=Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }


        }
        tv_add_address.setOnClickListener {
            intent=Intent(this,Address::class.java)
            startActivity(intent)
        }


    }


    fun seList(){
        rvpayment.layoutManager = LinearLayoutManager(this)
        rvpayment.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvpayment.adapter= PaymentAdapter(this, list_payment)
    }

    fun seList1(){
        rvAddressList.layoutManager = LinearLayoutManager(this)
        rvAddressList.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvAddressList.adapter= PaymentSaveAdapter(this, list_payment1)
    }


}
package com.metaled.Add_Address

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.metaled.R
import kotlinx.android.synthetic.main.activity_add_address.*

class Add_Address : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_address)


        add_address.setOnClickListener {
            onBackPressed()
        }

    }
}
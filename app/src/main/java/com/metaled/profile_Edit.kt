package com.metaled

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.header_layout.*

class profile_Edit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_edit)
        tvTitle.setText(resources.getText(R.string.profile))
        rlBack.setOnClickListener() {
            onBackPressed()
        }

        rlBack.setOnClickListener() {
           onBackPressed()

        }
    }
}
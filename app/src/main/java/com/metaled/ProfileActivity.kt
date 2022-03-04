package com.metaled

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.header_layout.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        tvTitle.setText(resources.getText(R.string.profile))
        onClick()
    }
    fun onClick(){
        rlBack.setOnClickListener() {
                  onBackPressed()

        }
                edit_profile.setOnClickListener() {
                    intent= Intent(this,profile_Edit::class.java)
                    startActivity(intent)
                }
//                tvSignin.setOnClickListener() {
//                    intent= Intent(this,MainActivity::class.java)
//                    startActivity(intent)

                }
            }




package com.metaled

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.metaled.CartModule.CartActivity
import com.metaled.Cutomize_Screen.Adapters.ReviewAdapter
import com.metaled.Cutomize_Screen.CustomizeAdapter
import com.metaled.HomeModule.Adapters.BestSellerAdapter


import kotlinx.android.synthetic.main.activity_customize_screen.*
import kotlinx.android.synthetic.main.activity_customize_screen.rlBack
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.custom_elements_popup.*
import kotlinx.android.synthetic.main.custom_material_popup.*
import kotlinx.android.synthetic.main.customize_popup_option_text.*
import kotlinx.android.synthetic.main.customsize_popup.*
import kotlinx.android.synthetic.main.header_layout.*
import kotlinx.android.synthetic.main.hooks_customize.*


class Customize_screen : AppCompatActivity() {
    lateinit var reviewList:ArrayList<String>
    lateinit var list_polygon:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customize_screen)
        reviewList=ArrayList()
        reviewList.add("")
        reviewList.add("")
        reviewList.add("")
        setReviewList()
        reviewList.add("")

        onClick()
    }
    fun setReviewList(){
        rvReview.layoutManager = LinearLayoutManager(this)
//        arrayList= ArrayList()
//        mylist= arrayListOf()
        rvReview.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvReview.adapter= ReviewAdapter(this, reviewList)
    }

        fun onClick(){
            rlBack.setOnClickListener() {
                onBackPressed()
            }

            ivProfile1.setOnClickListener() {
                intent= Intent(this,profile_Edit::class.java)
                startActivity(intent)
            }

            add_card.setOnClickListener() {
                intent = Intent(this, CartActivity::class.java)
                startActivity(intent)
            }

       /* list_polygon=ArrayList()
            list_polygon.add("")
            list_polygon.add("")
            list_polygon.add("")
            list_polygon.add("")
            seList()

            }
        fun seList(){
            rv_hook.layoutManager = LinearLayoutManager(this)
            rv_hook.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            rv_hook.adapter= CustomizeAdapter(this, list_polygon)
        }*/

            first_polygon.setOnClickListener() {

                rlCustomsize_popup.visibility = View.VISIBLE
                rlCustoms_popup_text.visibility = View.GONE

            }
            cross_size.setOnClickListener {
                rlCustomsize_popup.visibility = View.GONE
            }

            second_polygon.setOnClickListener {
                rlCustoms_material_popup.visibility=View.VISIBLE


                cross_material.setOnClickListener {
                    rlCustoms_material_popup.visibility=View.GONE

                }

            }

            third_polygon.setOnClickListener() {

                // rlCustomsize_popup.visibility = View.GONE
                rlCustoms_popup_text.visibility = View.VISIBLE


                cross_text.setOnClickListener {
                    rlCustoms_popup_text.visibility = View.GONE
                }

            }

            fourth_polygon.setOnClickListener {
                rlCustoms_elements_popup.visibility=View.VISIBLE
                cross_elements.setOnClickListener {
                    rlCustoms_elements_popup.visibility=View.GONE
                }
            }


        }






    }









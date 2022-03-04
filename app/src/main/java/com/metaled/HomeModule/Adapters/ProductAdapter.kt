package com.metaled.HomeModule.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.metaled.Customize_screen

import com.metaled.databinding.Products2Binding

class ProductAdapter(
    val context: Context,
    val list:ArrayList<String>?

): RecyclerView.Adapter<ProductAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val v= LayoutInflater.from(parent.context).inflate(R.layout.company_rows,parent,false)
        //return Holder(v)
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: Products2Binding = Products2Binding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return list!!.size
    }

    override  fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data=list?.get(position)
        holder.binding.tvCustom1.setOnClickListener {
           var intent= Intent(context, Customize_screen::class.java)
            context.startActivity(intent)
        }
        /*  if(data?.title!=null){
              holder.binding.tvTitle.setText(data?.title)
          }
          if(data?.body!=null){
              holder.binding.tvDes.setText(data?.body)
          }*/


    }


    class ViewHolder(binding: Products2Binding) : RecyclerView.ViewHolder(binding.getRoot()) {
        var binding: Products2Binding

        init {
            this.binding = binding
        }
    }
}
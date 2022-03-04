package com.metaled.Cutomize_Screen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.metaled.databinding.HooksCustomizeBinding

class CustomizeAdapter(
    val context: Context,
    val list:ArrayList<String>?

): RecyclerView.Adapter<CustomizeAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val v= LayoutInflater.from(parent.context).inflate(R.layout.company_rows,parent,false)
        //return Holder(v)
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: HooksCustomizeBinding = HooksCustomizeBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return list!!.size
    }

    override  fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //    val data=list?.get(position)

        /*  if(data?.title!=null){
              holder.binding.tvTitle.setText(data?.title)
          }
          if(data?.body!=null){
              holder.binding.tvDes.setText(data?.body)
          }*/


    }


    class ViewHolder(binding: HooksCustomizeBinding) : RecyclerView.ViewHolder(binding.getRoot()) {
        var binding: HooksCustomizeBinding

        init {
            this.binding = binding
        }
    }
}
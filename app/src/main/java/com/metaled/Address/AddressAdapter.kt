package com.metaled.Address

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.metaled.Payment.PaymentAdapter
import com.metaled.databinding.Address2Binding
import com.metaled.databinding.PaymentMethodBinding

class AddressAdapter (
    val context: Context,
    val list:ArrayList<String>?

): RecyclerView.Adapter<AddressAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val v= LayoutInflater.from(parent.context).inflate(R.layout.company_rows,parent,false)
        //return Holder(v)
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: Address2Binding = Address2Binding.inflate(layoutInflater, parent, false)
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


    class ViewHolder(binding: Address2Binding) : RecyclerView.ViewHolder(binding.getRoot()) {
        var binding: Address2Binding

        init {
            this.binding = binding
        }
    }}
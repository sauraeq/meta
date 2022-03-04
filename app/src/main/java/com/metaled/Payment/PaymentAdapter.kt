package com.metaled.Payment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.databinding.DataBindingUtil.inflate
import androidx.recyclerview.widget.RecyclerView
import com.metaled.CartModule.CartAdapter
import com.metaled.R
import com.metaled.databinding.ActivityAddAddressBinding.inflate
import com.metaled.databinding.ActivityAddressBinding.inflate
import com.metaled.databinding.PaymentMethodBinding


class PaymentAdapter (
    val context: Context,
    val list:ArrayList<String>?

): RecyclerView.Adapter<PaymentAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val v= LayoutInflater.from(parent.context).inflate(R.layout.activity_payment_layout,parent,false)
//        return ViewHolder(v)
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: PaymentMethodBinding = PaymentMethodBinding.inflate(layoutInflater, parent, false)
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


    class ViewHolder(binding: PaymentMethodBinding) : RecyclerView.ViewHolder(binding.getRoot()) {
        var binding: PaymentMethodBinding

        init {
            this.binding = binding
        }
    }
}

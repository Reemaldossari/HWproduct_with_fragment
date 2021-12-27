package com.example.hwproduct_with_fragment.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hwproduct_with_fragment.ListFragment
import com.example.hwproduct_with_fragment.ListFragmentDirections
import com.example.hwproduct_with_fragment.R
import com.example.hwproduct_with_fragment.conistant.productInfo
import com.example.hwproduct_with_fragment.data.DataSourse
import com.example.hwproduct_with_fragment.model.SmartPhone


class SmartphoneAdapter (private val dataSource: List<SmartPhone>) :
        RecyclerView.Adapter<SmartphoneAdapter.SmartPhoneViewHolder>() {


        class SmartPhoneViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {

            val productImage: ImageView? = view?.findViewById(R.id.product_image)
            val productName: TextView? = view?.findViewById(R.id.product_name)
            val productPrice: TextView? = view?.findViewById(R.id.product_price)
            val productIsVip: ImageView? = view?.findViewById(R.id.isVip_icon)
            val addToCart: ImageButton? = view?.findViewById(R.id.add_to_cart)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmartPhoneViewHolder {
            return SmartPhoneViewHolder(
                LayoutInflater.from(parent.context)
                .inflate(R.layout.vertical_list_item,parent,false)
            )
        }

        @SuppressLint("ResourceAsColor")
        override fun onBindViewHolder(holder: SmartPhoneViewHolder, position: Int) {
            val item= dataSource[position]

            holder.productImage?.setImageResource(item.prductPic)
            holder.productName?.setText(item.PhoneName)
            holder.productPrice?.text= item.PhonePrice

            if (item.PhoneVip){
                holder.productIsVip?.visibility= View.VISIBLE
            }

            holder.addToCart?.setOnClickListener{
                if (item.PhoneQuantity > 0 ){
                    Toast.makeText(holder.itemView.context,"add to cart" , Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(holder.itemView.context,"out of stock" , Toast.LENGTH_SHORT).show()

                }
            }
            holder.productImage?.setOnClickListener {
          val action = ListFragmentDirections.listToDetials(
              name = item.PhoneName,
              image = item.prductPic
          )
                holder.itemView.findNavController().navigate(action)

            }

        }

        override fun getItemCount(): Int = dataSource.size
    }


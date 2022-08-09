package com.example.clavaxtest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.clavaxtest.BR
import com.example.clavaxtest.OnClicked
import com.example.clavaxtest.R
import com.example.clavaxtest.databinding.RvZipListLayoutBinding
import com.example.clavaxtest.model.ZipList


class ZipCodeAdapter(private val zipList: List<ZipList>, context: Context) :
    RecyclerView.Adapter<ZipCodeAdapter.MyViewHolder>(), OnClicked{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding  : RvZipListLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.rv_zip_list_layout, parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(zipList[position])
        holder.rvZipListLayoutBinding.itemClicked = this;
    }

    override fun getItemCount(): Int {
        return zipList.size
    }

    class MyViewHolder(binding: RvZipListLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val rvZipListLayoutBinding = binding
        fun bind(any: Any) {
            rvZipListLayoutBinding.setVariable(BR.zipcode,any)
            rvZipListLayoutBinding.executePendingBindings()
        }

    }

    override fun cardClicked(f: ZipList) {

    }


}

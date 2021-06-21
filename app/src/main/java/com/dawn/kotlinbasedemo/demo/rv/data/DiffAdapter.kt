package com.dawn.kotlinbasedemo.demo.rv.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dawn.kotlinbasedemo.R
import com.dawn.lib_common.util.log


class DIFFCALLBACK: DiffUtil.ItemCallback<String>(){
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        log("areItemsTheSame===>$oldItem")
        log("areItemsTheSame===>$newItem")
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        log("areContentsTheSame===>$oldItem")
        log("areContentsTheSame===>$newItem")
        return oldItem == newItem
    }

}

class DiffAdapter: ListAdapter<String,DiffAdapter.MyHolder>(DIFFCALLBACK()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_diff_rv,parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.text?.text = currentList[position]
        log("onBindViewHolder===>$position")
    }

    class MyHolder( itemView: View): RecyclerView.ViewHolder(itemView) {
        var text:TextView?=null
        init {

            text=itemView.findViewById(R.id.diffText);
        }

    }
}

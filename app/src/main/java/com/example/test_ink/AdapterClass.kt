package com.example.test_ink

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(private val dataList : ArrayList<DataClass>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvText.text = currentItem.dataText
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {

        val rvText:TextView = itemView.findViewById(R.id.text)

    }

}
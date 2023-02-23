package com.example.basicrecycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.w3c.dom.Text

class ExampleAdapter(private val dataList : ArrayList<ItemViewModel>) : RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val name: TextView = itemView.findViewById(R.id.tvShowName)
        val description: TextView = itemView.findViewById(R.id.tvShowDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.customview_showdata_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.name.text = dataList[position].name
        holder.description.text = dataList[position].description
    }
}
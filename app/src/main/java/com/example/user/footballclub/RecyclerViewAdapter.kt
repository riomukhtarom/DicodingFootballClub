package com.example.user.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class RecyclerViewAdapter (private val context: Context, private val items: List<Item>, private val listener: (Item)->Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.tv_clubname)
        private val logo = view.findViewById<ImageView>(R.id.iv_clublogo)

        fun bindItem(items:Item, listener: (Item) -> Unit){
            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(logo)
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}
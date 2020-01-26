package com.manish.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.textview.view.*


class todoadapter(val list:List<todo>): RecyclerView.Adapter<todoadapter.listviewholder>(){

    fun remove(viewholder:RecyclerView.ViewHolder)
    {
        notifyItemChanged(viewholder.adapterPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listviewholder {
        return listviewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.textview,parent,false)
        )
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: listviewholder, position: Int) {
        val listarr=list[position]
        holder.view.textView.text=listarr.task
        holder.view.tv2.text=listarr.date
    }

    class listviewholder(val view: View): RecyclerView.ViewHolder(view)
}

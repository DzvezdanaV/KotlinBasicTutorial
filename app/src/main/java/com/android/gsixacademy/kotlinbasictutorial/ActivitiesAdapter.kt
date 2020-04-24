package com.android.gsixacademy.kotlinbasictutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ActivitiesAdapter(val items: ArrayList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_recyclerview,parent,false))
    }
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       var item = items[position]
    }
    inner class MyViewHolder (view: View) : RecyclerView.ViewHolder(view){
        fun bindData (itemModel: String) {}
    }
}





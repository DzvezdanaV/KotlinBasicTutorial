package com.android.gsixacademy.kotlinbasictutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_list_item.view.*


class CarsAdapter(val items: ArrayList<Car>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_list_item,parent,false))
    }
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var MyViewHolder = holder as MyViewHolder
        MyViewHolder.bindData(items[position])

    }
    inner class MyViewHolder (view: View) : RecyclerView.ViewHolder(view){
        fun bindData (itemModel: Car) {
            Picasso.get().load(itemModel.imageResource).into(itemView.image_view_car);

//            itemView.image_view_car.setImageResource(itemModel.imageResource)
            itemView.text_view_title.text = itemModel.title
            itemView.text_view_description.text = itemModel.description
        }
    }
}





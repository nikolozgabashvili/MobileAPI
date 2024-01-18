package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class MyAdapter(private var list:List<Mobile>) :RecyclerView.Adapter<MyAdapter.MyHolder>() {

    



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyHolder {
        
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.mobilecard,parent,false)
        return MyHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyHolder, position: Int) {

        val item = list[position]
        holder.manufacturer.text = item.manufacturer
        holder.name.text = item.deviceName
        holder.version1.text = item.androidVersion.toString()
        val imagestr = item.cover

        Glide.with(holder.image)
            .load(imagestr)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size


    }

    class  MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var manufacturer :TextView = itemView.findViewById(R.id.manufacturer)
        var name :TextView = itemView.findViewById(R.id.name)
        var version1 :TextView = itemView.findViewById(R.id.version)
        var image :ImageView = itemView.findViewById(R.id.imageView)
    }
}
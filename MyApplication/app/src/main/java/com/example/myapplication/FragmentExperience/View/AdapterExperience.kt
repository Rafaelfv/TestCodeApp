package com.example.myapplication.FragmentExperience.View

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.Models.Response.Experience
import com.example.myapplication.R

class AdapterExperience (private val list: ArrayList<Experience>) : RecyclerView.Adapter<AdapterExperience.Experienceitem>() {


    inner class Experienceitem (v: View) : RecyclerView.ViewHolder(v) {
        internal var title:TextView ? = null
        internal var txt:TextView ? = null
        init {
         title  = v.findViewById(R.id.tvTitleExp_fe)
         txt  = v.findViewById(R.id.tvTxtExp_fe)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdapterExperience.Experienceitem {
        val v = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_experience, p0, false)
        return Experienceitem(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterExperience.Experienceitem, i: Int) {
        Log.i("Adapter","Size: "+list.size)
            if(!list.isEmpty()){
                holder.title?.text = list[i].title
                holder.txt?.text = list[i].content
            }

    }
}
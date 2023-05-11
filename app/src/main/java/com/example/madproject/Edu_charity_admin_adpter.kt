package com.example.madproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class  Edu_charity_admin_adpter  (private val EducationList: ArrayList<CharityModel>) :
    RecyclerView.Adapter<Edu_charity_admin_adpter.ViewHolder>() {


    private  lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.educational_chariti_admin_item, parent, false)
        return ViewHolder(itemView,mListener)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentExpence = EducationList[position]
        holder.tvCharityName.text = currentExpence.charityName
    }

    override fun getItemCount(): Int {
        return EducationList.size
    }

    class ViewHolder(itemView: View,clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val tvCharityName : TextView = itemView.findViewById(R.id.tv_edu_charity_admin_name)

        init {
            itemView.setOnClickListener{
                clickListener.onItemClick(adapterPosition)
            }
        }


    }

}


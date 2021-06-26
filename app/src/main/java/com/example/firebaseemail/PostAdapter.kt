package com.example.firebaseemail

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseemail.Modal.postItem
import com.example.test.UPItem

// class PostAdapter(private val context: Context,private var postList:ArrayList<postItem>):RecyclerView.Adapter<PostAdapter.postViewHolder>() {


    class PostAdapter(private val context: Context,private var postList:ArrayList<postItem>):RecyclerView.Adapter<PostAdapter.postViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {

        return postViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
//        return postViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))


    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {

         //   val post=postList[position]

        val post=postList[position]

      /*  holder.name.text= post.HOSPITAL_NAME
        holder.location.text=post.LOCATION
        holder.totalBeds.text=post.TOTAL
        holder.totalVacant.text=post.VACANT
        holder.contact.text=post.CONTACT
        holder.address.text=post.ADDRESS
        holder.district.text=post.DISTRICT
        Log.d("TAG","${holder.name}")*/


        holder.name.text= post.HOSPITAL_NAME
        holder.address.text= post.LOCATION
        holder.allocatedHDU.text=post.ALLOCATED_HDU
        holder.availableHDU.text=post.NET_AVAILABLE_HDU
        holder.allocatedICU.text=post.ALLOCATED_ICU
        holder.allocatedICUwithventi.text=post.ALLOCATED_ICU_WITH_VENTILATOR
        holder.availableICU.text=post.NET_AVAILABLE_ICU
        holder.availableICUwithVenti.text=post.NET_AVAILABLE_ICU_WITH_VENTILATOR


    }

    override fun getItemCount(): Int = postList.size

    class postViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

//
//        val name:TextView = itemView.findViewById(R.id.hospitalName)
//        val location:TextView = itemView.findViewById(R.id.location)
//        val totalBeds:TextView = itemView.findViewById(R.id.allocatedHDU)
//        val totalVacant:TextView = itemView.findViewById(R.id.availableHDU)
//        val contact:TextView = itemView.findViewById(R.id.contact)
//        val address:TextView = itemView.findViewById(R.id.address)
//        val district:TextView = itemView.findViewById(R.id.district)
//
//
//



        val name:TextView=itemView.findViewById(R.id.hospitalName)
        val address:TextView=itemView.findViewById(R.id.address)
        val allocatedHDU:TextView = itemView.findViewById(R.id.allocatedHDU)
        val availableHDU:TextView = itemView.findViewById(R.id.availableHDU)
        val allocatedICU:TextView = itemView.findViewById(R.id.allocatedICU)
        val availableICU:TextView = itemView.findViewById(R.id.availableICU)
        val allocatedICUwithventi:TextView = itemView.findViewById(R.id.allocaedicuwithventi)
        val availableICUwithVenti:TextView = itemView.findViewById(R.id.availableICUwithventi)






       // val title:TextView=itemView.findViewById(R.id.title)
    }

    fun setData(postList:ArrayList<postItem>){
        this.postList=postList
        notifyDataSetChanged()
    }
}
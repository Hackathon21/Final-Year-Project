package com.example.firebaseemail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val context: Context, private val userList : ArrayList<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.Name.text = currentitem.Name
        holder.phone.text = currentitem.phone
        holder.zipcode.text = currentitem.zipcode
        holder.bgroup.text = currentitem.bgroup

        val number=holder.phone.text

        holder.phone.setOnClickListener {

            val number=holder.phone.text.toString()
            // The number on which you want to send SMS


            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)))



//
//            val sendIntent: Intent = Intent().apply {
//                action = Intent.ACTION_SEND
//                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
//                type = "text/plain"
//            }
//
//            val shareIntent = Intent.createChooser(sendIntent, null)
//            context.startActivity(shareIntent)

        }
//        val shareIntent = Intent.createChooser(sendIntent, null)
//        startActivity(shareIntent)


    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val Name : TextView = itemView.findViewById(R.id.tvfirstName)
        val phone : TextView = itemView.findViewById(R.id.tvlastName)
        val zipcode : TextView = itemView.findViewById(R.id.tvaddress)
        val bgroup : TextView = itemView.findViewById(R.id.tvbloodgroup)

    }

}
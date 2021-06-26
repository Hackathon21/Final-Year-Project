package com.example.h3.UpPostAdapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseemail.R
import com.example.test.UPItem

class UpPostAdapter(private val context: Context, private var postList:ArrayList<UPItem>):
        RecyclerView.Adapter<UpPostAdapter.postViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpPostAdapter.postViewHolder {

        return UpPostAdapter.postViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.up, parent, false)
        )

    }

    override fun onBindViewHolder(holder: UpPostAdapter.postViewHolder, position: Int) {

        val post = postList[position]

        holder.name.text = post.HOSPITAL_NAME
        holder.location.text = post.LOCATION
        holder.totalBeds.text = post.TOTAL
        holder.totalVacant.text = post.VACANT
        holder.contact.text = post.CONTACT
        holder.address.text = post.ADDRESS
        holder.district.text = post.DISTRICT

        val add=holder.address.text.toString()
        holder.address.setOnClickListener {
            val gmmIntentUri: Uri = Uri.parse("geo:0,0?q=$add")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            context.startActivity(mapIntent)

            }
        }

    override fun getItemCount(): Int = postList.size

    class postViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){


        val name:TextView = itemView.findViewById(R.id.hospitalName)
        val location:TextView = itemView.findViewById(R.id.location)
        val totalBeds:TextView = itemView.findViewById(R.id.allocatedHDU)
        val totalVacant:TextView = itemView.findViewById(R.id.availableHDU)
        val contact:TextView = itemView.findViewById(R.id.contact)
        val address:TextView = itemView.findViewById(R.id.address)
        val district:TextView = itemView.findViewById(R.id.district)






        // val title:TextView=itemView.findViewById(R.id.title)
    }

    fun setData(postList:ArrayList<UPItem>){
        this.postList = postList
        notifyDataSetChanged()
    }


}


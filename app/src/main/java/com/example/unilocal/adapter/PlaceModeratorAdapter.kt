package com.example.unilocal.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.unilocal.R
import com.example.unilocal.activities.DetailPlaceActivity
import com.example.unilocal.activities.SearchResultActivity
import com.example.unilocal.db.Categories
import com.example.unilocal.db.Comments
import com.example.unilocal.db.Places
import com.example.unilocal.model.Place
import com.example.unilocal.model.PlaceStatus
import com.example.unilocal.model.Schedule
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PlaceModeratorAdapter(var list:ArrayList<Place>): RecyclerView.Adapter<PlaceModeratorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_place_moderators, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }


    override fun getItemCount() = list.size

    inner class ViewHolder(var itemView:View):RecyclerView.ViewHolder(itemView), OnClickListener{



        val name:TextView = itemView.findViewById(R.id.place_name)
        val direction:TextView = itemView.findViewById(R.id.place_direction)
        val startTime:TextView = itemView.findViewById(R.id.start_time)
        val closingTime:TextView = itemView.findViewById(R.id.closing_time)
        val image:ImageView = itemView.findViewById(R.id.place_image)
        val icon:TextView = itemView.findViewById(R.id.place_icon)
        var codePlace:Int = 0
        var btnAccept = itemView.findViewById<FloatingActionButton>(R.id.button_accept_place)
        var btnReject = itemView.findViewById<FloatingActionButton >(R.id.button_reject_place)


        init{
            itemView.setOnClickListener(this)
        }

        fun bind(place: Place){
            name.text = place.name
            direction.text = place.direction
            startTime.text = place.schedules[0].startTime.toString() + ":00"
            closingTime.text = place.schedules[0].closingTime.toString() + ":00"

            codePlace= place.id
            val placeToRemove = list.find { it.id == place.id }

            if(place.status.equals(PlaceStatus.PENDING)){
                btnAccept.setOnClickListener {
                    place.status = PlaceStatus.ACCEPTED
                    //list = Places.ListByState(PlaceStatus.ACCEPTED)
                }
                btnReject.setOnClickListener {
                    place.status = PlaceStatus.REJECTED
                    //list = Places.ListByState(PlaceStatus.REJECTED)
                }
            }else{
                btnAccept.visibility = View.GONE
                btnReject.visibility = View.GONE
            }



/*
            icon.text = Categories.get(place.id)!!.icon


 */
        }

        override fun onClick(p0: View?) {
            val intent = Intent(name.context, DetailPlaceActivity::class.java)
            intent.putExtra("code", codePlace)
            name.context.startActivity(intent)
        }

    }
}
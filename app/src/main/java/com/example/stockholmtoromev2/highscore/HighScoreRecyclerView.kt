package com.example.stockholmtoromev2.highscore

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stockholmtoromev2.R

class HighScoreRecyclerView(val context: Context, val persons: List<HiScore>) :
    RecyclerView.Adapter<HighScoreRecyclerView.ViewHolder>() {

   val layoutInflater = LayoutInflater.from(context)

    //Hur många items finns det i vår datamängd
    override fun getItemCount(): Int {
        Log.d("!!!Adapter", "getItemcount")
        return persons.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.highscore_item, parent, false)
        Log.d("!!!Adapter", "onCreateViewHolder")

            return ViewHolder(itemView)

    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //När en listview ska visas så tar vi rätt person fråan vår lista
        Log.d("!!!Adapter", "OnbindviewHolder $position")
        val person = persons[position]


        //Sätter vi in den personens uppgifter i vår view
        holder.nameTextView.text = person.name
        holder.ageTextView.text = person.where


    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //När en viewholder skapas letar vi reda på tvp textviews som finns inne i vår itemview
        val nameTextView = itemView.findViewById<TextView>(R.id.username)
        val ageTextView = itemView.findViewById<TextView>(R.id.whereTextView)



    }

}
package com.example.stockholmtoromev2.highscore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stockholmtoromev2.R

class HighScoreRecycleView(val context: Context, var where: List<HiScore>) :
    RecyclerView.Adapter<HighScoreRecycleView.ViewHolder>() {
    val layoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int {
        return where.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighScoreRecycleView.ViewHolder {
        val viewHolder = layoutInflater.inflate(R.layout.highscore_item, parent, false)
        return ViewHolder(viewHolder)

    }

    override fun onBindViewHolder(holder: HighScoreRecycleView.ViewHolder, position: Int) {
        val user = where[position]

        holder.nameTextView.text = user.name
        holder.whereTextView.text = user.where


    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView = itemView.findViewById<TextView>(R.id.usernameEditText)
        val whereTextView = itemView.findViewById<TextView>(R.id.whereTextView)



    }

}
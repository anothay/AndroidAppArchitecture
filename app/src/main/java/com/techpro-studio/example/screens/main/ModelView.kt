package com.wolvesstudio.example.screens.main

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wolvesstudio.example.R

class ModelView(itemView: View): RecyclerView.ViewHolder(itemView) {
    val textView: TextView = itemView.findViewById(R.id.text)
}
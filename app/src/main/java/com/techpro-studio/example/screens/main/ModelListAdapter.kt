package com.wolvesstudio.example.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wolvesstudio.example.R
import com.wolvesstudio.example.core.Model

class ModelListAdapter : RecyclerView.Adapter<ModelView>() {
    var list: List<Model> = listOf()

    var onItemClickListener: ((Model)->Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_view, parent, false)
        return ModelView(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ModelView, position: Int) {
        val item = list[position]
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(list[position])
        }
        holder.textView.text = item.name
    }
}
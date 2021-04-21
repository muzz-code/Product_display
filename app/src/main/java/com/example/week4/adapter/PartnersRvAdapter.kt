package com.example.week4.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.week4.R
import com.example.week4.model.PartnersData
import kotlinx.android.synthetic.main.debit_card.view.*
import kotlinx.android.synthetic.main.recycler_items.view.*

class PartnersRvAdapter (val partnersList: ArrayList<PartnersData>): RecyclerView.Adapter<PartnersRvAdapter.PartnersViewHolder>(){

    class PartnersViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartnersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_items, parent, false)
        return PartnersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return partnersList.size
    }

            // setting the view binder
    override fun onBindViewHolder(holder: PartnersViewHolder, position: Int) {
        holder.itemView.apply {

            textView.text = partnersList[position].name
            textView20.text = partnersList[position].discount
            textView21.text = partnersList[position].merchandise
//            imageView.setImageResource(partnersList[position].image)

        }
    }
}
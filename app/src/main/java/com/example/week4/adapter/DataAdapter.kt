package com.example.week4.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.week4.R
import com.example.week4.model.Data
import kotlinx.android.synthetic.main.debit_card.view.*

class DataAdapter(private val debitCardList: ArrayList<Data>) :
    RecyclerView.Adapter<DataAdapter.PagerViewHolder>() {


    class PagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.debit_card, parent, false)
        return PagerViewHolder(view)
    }


    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.itemView.apply {


            val debitCard = debitCardList[position]


            textView4.text = debitCard.name
            textView2.text = debitCard.balance

            debit_card.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this.context, debitCard.color))

        }
    }

    override fun getItemCount(): Int {
        return debitCardList.size
    }
}

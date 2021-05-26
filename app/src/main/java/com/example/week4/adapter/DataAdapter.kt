package com.example.week4.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.week4.R
import com.example.week4.model.Data
import kotlinx.android.synthetic.main.debit_card.view.*

class DataAdapter(private val debitCardList: ArrayList<Data>) :
    RecyclerView.Adapter<DataAdapter.PagerViewHolder>() {


    class PagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardName: TextView = view.findViewById(R.id.textView4)
        val cardBalance: TextView = view.findViewById(R.id.textView2)
        val card: ImageView = view.findViewById(R.id.debit_card)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.debit_card, parent, false)
        return PagerViewHolder(view)
    }


    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        val debitCard = debitCardList[position]

        holder.apply {
            cardName.text = debitCard.name
            cardBalance.text = debitCard.balance
            card.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(itemView.context, debitCard.color))

        }
    }

    override fun getItemCount(): Int {
        return debitCardList.size
    }
}

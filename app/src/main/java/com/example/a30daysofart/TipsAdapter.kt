package com.example.a30daysofart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipsAdapter(private val tips: List<Tip>) : RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

    class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val day: TextView = itemView.findViewById(R.id.tip_day)
        val title: TextView = itemView.findViewById(R.id.tip_advice)
        val image: ImageView = itemView.findViewById(R.id.tip_image)
        val adviceShort: TextView = itemView.findViewById(R.id.tip_description_short)
        val adviceLong: TextView = itemView.findViewById(R.id.tip_description_long)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        holder.day.text = "День ${position + 1}"
        holder.title.text = tip.title
        holder.image.setImageResource(tip.imageResId)
        holder.adviceShort.text = tip.adviceShort
        holder.adviceLong.text = tip.adviceLong

        holder.adviceLong.visibility = View.GONE

        holder.image.setOnClickListener {
            if (holder.adviceLong.visibility == View.GONE) {
                holder.adviceLong.visibility = View.VISIBLE
            } else {
                holder.adviceLong.visibility = View.GONE
            }
        }
    }

    override fun getItemCount() = tips.size
}

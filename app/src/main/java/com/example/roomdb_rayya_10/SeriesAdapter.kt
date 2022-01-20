package com.example.roomdb_rayya_10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb_rayya_10.room.Series
import kotlinx.android.synthetic.main.list_series.view.*

class SeriesAdapter(private val series: ArrayList<Series>) : RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        return SeriesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_series, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val series  = series[position]
        holder.view.text_title.text = series.tittle
    }

    override fun getItemCount() = series.size

    class SeriesViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Series>){
        series.clear()
        series.addAll(list)
        notifyDataSetChanged()
    }
}
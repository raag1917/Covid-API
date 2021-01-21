package com.raag.covidapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raag.covidapi.R
import com.raag.covidapi.data.model.CovidData
import com.raag.covidapi.databinding.RowBinding

class CovidAdapter(private val context: Context, private var list: List<CovidData>) :
    RecyclerView.Adapter<CovidAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainViewHolder(LayoutInflater.from(context).inflate(R.layout.row, parent, false))

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RowBinding.bind(view)

        fun bind(item: CovidData) = with(binding) {
            binding.fecha.text = item.fecha
            binding.atlantico.text = item.atlantico
            binding.antioquia.text = item.antioquia
            binding.bogota.text = item.bogota
            binding.valle.text = item.valle_del_cauca
            binding.santander.text = item.santander
            binding.caldas.text = item.caldas
        }
    }
}
package com.development.planet

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlanetDataAdapter(
    private val listPlanetDataClass: ArrayList<PlanetDataClass>,
    private val listener: (PlanetDataClass) -> Unit
) : RecyclerView.Adapter<PlanetDataAdapter.CardViewViewHolder>() {


    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.imgItemPhoto)
        var tvName: TextView = itemView.findViewById(R.id.txtItemName)
        var tvDescription: TextView = itemView.findViewById(R.id.txtItemDeskripsi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_planet, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPlanetDataClass.size
    }

    // init data and action
    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val planet = listPlanetDataClass[position]

        holder.imgPhoto.setImageResource(planet.photo)
        holder.tvName.text = planet.name
        holder.tvDescription.text = planet.description
        holder.itemView.setOnClickListener { listener(planet) }
    }
}
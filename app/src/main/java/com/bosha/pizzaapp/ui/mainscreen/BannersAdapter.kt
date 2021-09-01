package com.bosha.pizzaapp.ui.mainscreen

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.bosha.pizzaapp.databinding.BannerItemBinding

class BannersAdapter() : RecyclerView.Adapter<BannersViewHolder>() {

    var bannersResIds: List<Drawable?> = emptyList()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
       field = value
       notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannersViewHolder =
        BannersViewHolder(
            BannerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BannersViewHolder, position: Int) {
        holder.binding.cvBanner.foreground = bannersResIds[position]
    }

    override fun getItemCount(): Int = bannersResIds.size

}

class BannersViewHolder(val binding: BannerItemBinding) : RecyclerView.ViewHolder(binding.root)
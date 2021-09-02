package com.bosha.pizzaapp.ui.mainscreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bosha.domain.entities.PizzaItem
import com.bosha.pizzaapp.databinding.StoreItemBinding
import com.bosha.pizzaapp.utils.pizzaImage

class PizzaMainListAdapter() : ListAdapter<PizzaItem, PizzaMainListAdapter.PizzaViewHolder>(
    DiffCallback()
) {
    private var onEdit: ((pizza: PizzaItem) -> Unit)? = null

    fun setOnClickListener(action: (pizza: PizzaItem) -> Unit) {
        onEdit = action
    }

    class PizzaViewHolder(
        private val binding: StoreItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PizzaItem) {
            binding.apply {
                bPrice.text = "от ${item.price} р"
                ivPizzaImage.setImageResource(pizzaImage[item.imageResUrl] ?: 1)
                tvPizzaDescription.text = item.description
                tvPizzaTitle.text = item.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val binding = StoreItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PizzaViewHolder(binding).apply {
            binding.root.setOnClickListener {
                onEdit?.invoke(getItem(adapterPosition))
            }
        }
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class DiffCallback : DiffUtil.ItemCallback<PizzaItem>() {

    override fun areItemsTheSame(oldItem: PizzaItem, newItem: PizzaItem): Boolean =
        newItem == oldItem

    override fun areContentsTheSame(oldItem: PizzaItem, newItem: PizzaItem): Boolean =
        newItem.title == oldItem.title
}
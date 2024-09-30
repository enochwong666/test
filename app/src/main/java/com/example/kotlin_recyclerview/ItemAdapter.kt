package com.example.kotlin_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_recyclerview.databinding.ItemViewBinding

class ItemAdapter(
    private val items: List<Item>,
    private val onItemClick: (Item) -> Unit // Accept a click listener in the constructor
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding, onItemClick) // Pass the click listener to the ViewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ItemViewHolder(
        private val binding: ItemViewBinding,
        private val onItemClick: (Item) -> Unit // Store the click listener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.tvTitle.text = item.title
            binding.tvDescription.text = item.description
            itemView.setOnClickListener {
                onItemClick(item) // Invoke the click listener when the item is clicked
            }
        }
    }
}

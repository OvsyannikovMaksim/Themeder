package com.example.myapplication5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication5.databinding.CardStackItemBinding

class CardStackAdapter : ListAdapter<Picture, CardStackAdapter.CardStackVH>(DiffCallback) {

    private lateinit var binding: CardStackItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardStackVH {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        binding = CardStackItemBinding.inflate(inflater, parent, false)
        return CardStackVH(binding)
    }

    override fun onBindViewHolder(holder: CardStackVH, position: Int) {
        holder.bind(currentList[position])
    }

    class CardStackVH(private var itemBinding: CardStackItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(picture: Picture) {
            TODO("Not yet implemented")
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Picture>() {
        override fun areItemsTheSame(oldItem: Picture, newItem: Picture): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: Picture, newItem: Picture): Boolean {
            TODO("Not yet implemented")
        }
    }
}
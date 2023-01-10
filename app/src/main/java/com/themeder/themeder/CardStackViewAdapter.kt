package com.themeder.themeder

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.themeder.themeder.databinding.PictureItemBinding

class CardStackViewAdapter : ListAdapter<PhotoInfo, CardStackViewAdapter.PictureVH>(DiffCallBack) {

    private lateinit var pictureItemBinding: PictureItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureVH {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        pictureItemBinding = PictureItemBinding.inflate(inflater, parent, false)
        return PictureVH(pictureItemBinding)
    }

    override fun onBindViewHolder(holder: PictureVH, position: Int) {
        holder.bind(currentList[position])
    }

    class PictureVH(private val pictureItemBinding: PictureItemBinding) :
        RecyclerView.ViewHolder(pictureItemBinding.root) {

        fun bind(item: PhotoInfo) {
            Picasso.get().load(item.uri).into(pictureItemBinding.pictureItem)
            Log.d("TAG", item.uri.toString())
        }
    }

    object DiffCallBack : DiffUtil.ItemCallback<PhotoInfo>() {

        override fun areContentsTheSame(oldItem: PhotoInfo, newItem: PhotoInfo): Boolean {
            TODO("Need to implement after finalizing PhotoInfo")
        }

        override fun areItemsTheSame(oldItem: PhotoInfo, newItem: PhotoInfo): Boolean {
            TODO("Need to implement after finalizing PhotoInfo")
        }
    }
}

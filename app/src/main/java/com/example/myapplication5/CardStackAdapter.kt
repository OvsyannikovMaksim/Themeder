package com.example.myapplication5

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView

@SuppressLint("ResourceType")
class CardStackAdapter(context: Context, list: MutableList<String>) :
    ArrayAdapter<String>(context, R.id.card_stack_item, list) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val holder: CardStackItemVH
        val retView: View

        if(convertView==null){
            val inflater= LayoutInflater.from(context)
            retView=inflater.inflate(R.id.card_stack_item, parent)
            holder= CardStackItemVH()
            holder.image=retView.findViewById(R.id.card_stack_item_image)
            retView.tag=holder
        }
        else{
            retView=convertView
            holder = convertView.tag as CardStackItemVH
        }

        return retView
    }

    internal class CardStackItemVH{
        var image: ImageView? = null
    }
}
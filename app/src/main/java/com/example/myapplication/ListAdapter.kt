package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ListAdapter(val items:ArrayList<String>,private val listner:itemClicked ) : RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        val viewHolder = ListViewHolder(view)
        view.setOnClickListener {
            listner.OnitemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val currentitem = items[position]
        holder.titleview.text = currentitem


    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateitems() {
        //items.clear()
        //  items.addAll(updateditems)
        notifyDataSetChanged()
    }

}



class ListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
{
   val titleview:TextView = itemView.findViewById(R.id.title)
    val imageview:ShapeableImageView=itemView.findViewById(R.id.image)
}
interface itemClicked{
    fun OnitemClicked(item: String)
}
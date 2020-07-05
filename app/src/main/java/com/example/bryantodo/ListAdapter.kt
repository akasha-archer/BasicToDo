package com.example.bryantodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter(private val items: MutableList<String>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    // updates the adapter's content whenever something new is added to the list
    fun updateItems(items: MutableList<String>) {
        notifyDataSetChanged()
    }

    class ListViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    // whenever a new viewholder is created, this function instructs it to use the specified layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view)
    }


    // Tells the adapter that the value of the entry in the edit text field is the item at the index of position in the list
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.listEntry.text = items[position]
    }

    // returns the size of the list to the adapter
    override fun getItemCount(): Int {
        return items.size
    }


}







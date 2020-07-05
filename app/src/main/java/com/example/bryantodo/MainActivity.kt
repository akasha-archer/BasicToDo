package com.example.bryantodo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ListAdapter
    private val toDoList: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set up the recycler view
        adapter = ListAdapter(toDoList)
        list_rv.layoutManager = LinearLayoutManager(this)
        list_rv.adapter = adapter

        // adds a divider between items on the list
        list_rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        updateList()
    }

    private fun updateList() {
        buttonID.setOnClickListener {
            val listItem = text_field.text.toString()

            //check to see is user entered a value in the text field
            if (listItem.isBlank()) {
                Toast.makeText(this, "Please enter an item for the list", Toast.LENGTH_LONG).show()
            } else {
                toDoList.add(listItem)
                adapter.updateItems(toDoList)
            }

            // clear the text field after the item is added to the list
            text_field.text.clear()
        }
    }
}

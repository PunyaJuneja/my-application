package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), itemClicked {
    val list = ArrayList<String>()
    val listA = ArrayList<String>()
    private lateinit var adapter:ListAdapter
    private lateinit var adapterA:ListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerViewA: RecyclerView = findViewById(R.id.recyclerviewA)
        recyclerViewA.layoutManager = LinearLayoutManager(this)
        adapterA= ListAdapter(listA,this)
        recyclerViewA.adapter  = adapterA


        val recyclerView: RecyclerView = findViewById(R.id.recyclerviewB)
        recyclerView.layoutManager =LinearLayoutManager(this)
        val items = fetchdata()
        adapter = ListAdapter(items,this)
        recyclerView.adapter = adapter


        val shuffle:Button = findViewById(R.id.shuffle)
        shuffle.setOnClickListener{
            Collections.shuffle(list)
            adapter.updateitems()
        }
    }

    private fun fetchdata(): ArrayList<String> {

        for(i in 0 until 100)
        {
            list.add("item $i")
        }
   return list
    }

    override fun OnitemClicked(item: String) {
        Toast.makeText(this,"$item clicked",Toast.LENGTH_LONG).show()
        val x:String = item
        list.remove(x)
        adapter.updateitems()
        listA.add(x)
        adapterA.updateitems()
    }
}
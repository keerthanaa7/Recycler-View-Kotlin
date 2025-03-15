package com.example.recyclerviewdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
) : RecyclerView.Adapter<MyViewHolder>() {
    companion object{
        private val TAG = "MyRecyclerViewAdapter"
    }

    private val callback = object:DiffUtil.ItemCallback<Fruit>(){
        override fun areItemsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
            Log.d(TAG ,"old item name " + oldItem.name + "new item name "  + newItem.name)
           return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
            return oldItem == newItem
        }

    }

    val asyncDifferList = AsyncListDiffer(this,callback)

    fun saveData(fruitlist:List<Fruit>) {
        asyncDifferList.submitList(fruitlist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(
            listItem
        )

    }

    override fun getItemCount(): Int {
        Log.d(TAG, "get count " + asyncDifferList.currentList.size)
        return asyncDifferList.currentList.size
       // return fruitsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = asyncDifferList.currentList[position]
       // val fruit = fruitsList[position]
        holder.bind(fruit)
    }
}

class MyViewHolder(
    val view: View
) : RecyclerView.ViewHolder(view) {
    fun bind(fruit: Fruit) {
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name
    }
}
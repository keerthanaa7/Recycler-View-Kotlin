package com.example.recyclerviewdemo

import android.graphics.Color.YELLOW
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.ui.theme.RecyclerViewDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recylerView = findViewById<RecyclerView>(R.id.recyclerView)
        recylerView.setBackgroundColor(YELLOW)
        recylerView.layoutManager = LinearLayoutManager(this)
        val fruitsList = listOf<Fruit>(
            Fruit("guava", "keer"),
            Fruit("blackberry", "keer1"),
            Fruit("blueberry", "keer2"),
            Fruit("strawberry", "keer3"),
            Fruit("mango", "keer4"),
        )
        val recyclerViewAdapter = MyRecyclerViewAdapter()
        recyclerViewAdapter.saveData(fruitsList)
        recylerView.adapter = recyclerViewAdapter

        val fruitsList1 = listOf<Fruit>(
            Fruit("guava", "keer"),
            Fruit("blackberry", "keer1"),
            Fruit("blueberry", "keer2"),
            Fruit("strawberry", "keer3"),
            Fruit("mango", "keer4"),
            Fruit("papya", "keer7"),
            Fruit("grapes", "keer8"),
        )
        recyclerViewAdapter.saveData(fruitsList1)
    }

    private fun listItemClicked(fruit: Fruit) {
        Toast.makeText(
            this,
            "selected fruit is ${fruit.name}",
            Toast.LENGTH_LONG
        ).show()
    }
}

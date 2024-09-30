package com.example.kotlin_recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: ItemAdapter
    private val items = mutableListOf<Item>() // Use MutableList to allow dynamic changes

    // Change 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize with some data
        repeat(100) { index ->
            items.add(Item("Title ${index + 1}", "Description ${index + 1}"))
        }

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        itemAdapter = ItemAdapter(items) { item ->
            Toast.makeText(this, "Clicked: ${item.title}", Toast.LENGTH_SHORT).show()
        }
        binding.recyclerView.adapter = itemAdapter

        // Set up button click listener to add a new item
        binding.addButton.setOnClickListener {
            val newItem = Item("Title ${items.size + 1}", "Description ${items.size + 1}")
            items.add(newItem)
            val position = items.size - 1
            itemAdapter.notifyItemInserted(position)
            binding.recyclerView.scrollToPosition(position)
        }
    }
}

package com.example.kotlin_recyclerview

data class Item(
    val title: String,
    val description: String,
    val imageUrl: String? = null, // Nullable property for image URL
    val imageResId: Int? = null // Nullable property for image resource ID
)

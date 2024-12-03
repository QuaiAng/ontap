package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Parcelable


data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val description: String,
    val picture: String
)
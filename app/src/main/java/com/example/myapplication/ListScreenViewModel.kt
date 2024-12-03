package com.example.myapplication

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.BufferedReader

class ListScreenViewModel(private val context: Context) : ViewModel(){

    private var products: List<Product> = emptyList()


    fun readJsonFromFile(context: Context, filename: String): String {
        val inputStream = context.assets.open(filename)
        val bufferedReader = BufferedReader(inputStream.reader())
        return bufferedReader.use { it.readText() }
    }


    fun getProducts(): List<Product> {
        if (products.isEmpty()) {
            val json = readJsonFromFile(context, "ontap.json")
            val type = object : TypeToken<List<Product>>() {}.type
            products = Gson().fromJson(json, type)
        }
        return products
    }

    fun getProductById(id: Int): Product {
        products = getProducts()
        for(i in products){
            if(i.id == id){
                return i
            }
        }
        return products[0]
    }

}
package com.example.like2

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import array
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapResource
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_data.*
import picurl

class Activity_data : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        setTitle("作品集")

//        val inflater = LayoutInflater.from(this)

        //JSON撈資料解析
        val jsonFile = applicationContext.assets.open("testjson.json").bufferedReader().use {
                it.readText()
        }
        var newUser3 = Gson().fromJson(jsonFile, array::class.java)
        val image3 = this.findViewById<ImageView>(R.id.imageView)
        var ItemListimage = intent.getIntExtra("list2image",1)
        var catname = intent?.getStringExtra("catname")
        when(catname) {
            "0" -> {
                Glide.with(this).load(ItemList[ItemListimage].image).into(image3)
            }
            "1" -> {
                Glide.with(this).load(ItemList2[ItemListimage].image).into(image3)
            }
            "2" -> {
                Glide.with(this).load(ItemList3[ItemListimage].image).into(image3)
            }
        }
        if (catname != null) {
            textView4.text =
                "\n\t資料關鍵字=${newUser3.Array[catname.toInt()].url[ItemListimage].IDname}"
        }
    }
}

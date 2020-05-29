package com.example.like2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import array
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity__b.*
import kotlinx.android.synthetic.main.activity_main.view.*

class Activity_B: AppCompatActivity() {

var list2 = mutableListOf<item>()
    var catname = ""
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__b)
        setTitle("詳細資料")



        val intent =getIntent()

        val jsonFile = applicationContext.assets.open("testjson.json").bufferedReader().use {
                it.readText()
            }
        var newUser = Gson().fromJson(jsonFile, array::class.java)
        var list = intent?.getStringExtra("num1").toString()
        catname = intent?.getStringExtra("num").toString()

        //get所傳遞的參數將其放置要顯示的圖片
        imageView2.setImageResource(list.toInt())
                    textView3.text =
                "\n\t姓名=${newUser.Array[catname.toInt()].name}"+
                        "\n\t年齡=${newUser.Array[catname.toInt()].code}" +
                        "\n\t身高=${newUser.Array[catname.toInt()].message}"

        rvRecyclerView.layoutManager = GridLayoutManager(this,3)
        //rvRecyclerView.layoutManager = LinearLayoutManager(this)

        when (catname) {
            "1" -> {
                list2 = ItemList2

            }
            "2" -> {
                list2 = ItemList3

            }

            else -> {
                list2 = ItemList

            }

        }
        rvRecyclerView.adapter = MyAdapter(this,list2 )
        //rvRecyclerView.itemAnimator




        }

}








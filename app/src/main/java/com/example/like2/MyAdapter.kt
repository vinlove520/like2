package com.example.like2


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView

import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.testmodul.view.*
import java.util.logging.Handler


class MyAdapter(val context: Activity_B, val list2: List<Int>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var Skr = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.testmodul, parent, false)

        return ViewHolder(view)

    }

    //抓取itemlist的資料有幾筆就會出現幾筆的空間
    override fun getItemCount(): Int {
        return ItemList.size
    }

    //將ViewHolder呼叫進來放置陣列的資料
    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
//放入ItemList[position]
        holder.Bind(ItemList[position], position)
        //點擊item事件
        holder.itemView.setOnClickListener {
            val intent = Intent(context, Activity_data::class.java)
            //傳遞點擊哪個圖並傳遞放置第三畫面imageView

//            var targetImage2 = ItemList[position].image2
            intent.putExtra("ItemListimage", position)
//            intent.putExtra("ItemListimage2",targetImage2)
            startActivity(context, intent, null)
        }

//將itemView的型態轉成image(圖片型態),將每個item順序賦予一個號碼
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image = itemView.findViewById<ImageView>(R.id.imageView3)

        //分析item.kt並載入圖片
        fun Bind(item: item, position: Int) {

                Glide.with(itemView.context).load(ItemList[position].image).into(image)

        }

    }
}







package com.example.like2



import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_data.*

import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {


    val list = mutableListOf<Int>()
var catname = ""
var addimage = ""





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addToList()   //把圖片傳進list
        viewPager.adapter = Adapter(this,list)  //Adapter需要填兩個函數
                                                        //Adapter(Context, List<Int>)
        viewPager.addOnPageChangeListener(mlistener)

//        Glide.with(this).load("https://www.xiaoxiaohuajia.com/uploads/allimg/191127/1_191127153251_4.jpg").into(imageView4)


//備胎程式碼
//        textView2.setOnClickListener {
//            val intent = Intent(this, Activity_B::class.java)
//            intent.putExtra("num1", addimage)
//            intent.putExtra("num",catname)
//
//            //MainActivity.this可簡寫成this
//            startActivity(intent)
//        }
//        addimage = viewPager

//
        }

    fun addToList() {

        for (i in 1..3) {

            var id = resources.getIdentifier("meme_"+ i, "drawable", packageName)


            list.add(id)

        }
    }   val mlistener = object: ViewPager.OnPageChangeListener{
        override fun onPageScrollStateChanged(position: Int) {
            //頁面滑動狀態改變時
        }
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            //頁面滾動時觸發

            //JSON撈資料解析
            val jsonFile = applicationContext.assets.open("testjson.json").bufferedReader().use {
                it.readText()
            }

            //var newUser = Gson().fromJson(jsonFile, array::class.java)

            // 製作成頁碼 － 原先是０  －－ ＋１表示從第一頁開始
            val page_position = position + 1  //position是從0開始

            //將資料存入暫存後續傳遞至AcＢ
            var aa= resources.getIdentifier("meme_"+ page_position, "drawable", packageName)
            addimage = aa.toString()
            //將在AcＡ曉得目前抓到哪一筆資料 將其存在catname
            catname = position.toString()
            //頁碼
            textView.text = ("$page_position / ${list.size}")

        }
        override fun onPageSelected(position: Int) {
            //當新的頁面被選擇時

        }
    }
}


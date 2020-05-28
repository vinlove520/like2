package com.example.like2


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.imageview.view.*


class Adapter(val context: MainActivity, val list: List<Int>) : PagerAdapter() {



    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.imageview, container, false)

        Glide.with(context).load(list[position]).into(view.meme_1)
        container.addView(view)




        view.setOnClickListener{
            val intent = Intent(context,Activity_B::class.java)
            //num -> 選擇第幾張(總３張)圖片,傳遞AcB -
            //num1 -> 初始０ ／從json中的第0筆資料傳遞
            intent.putExtra("num1", context.addimage)
            intent.putExtra("num", context.catname)


            startActivity(context,intent,null)

        }
        return view
    }
    override fun isViewFromObject(view: View, any: Any): Boolean {
        return view == any
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)


    }

}
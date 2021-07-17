package com.example.neighbourly_v1

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_feed.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_scroll.setOnScrollListener{
            var y=findViewById(R.id.scroll_stopper).getLocationOnScreen().y
        }
        main_scroll.smoothScrollTo(0, y)

        iv_gps.setOnClickListener {
            val dialog = Dialog(this)
            var window: Window = dialog.window!!
            val wmLp = window.attributes
            wmLp.gravity = Gravity.TOP
            window.attributes = wmLp
            dialog.setContentView(R.layout.layout_popup)
            dialog.setCancelable(true)
            dialog.setCanceledOnTouchOutside(true)
            dialog.show()
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window=dialog.window!!
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        }

        card_view.setOnClickListener {
            val i = Intent(this, DetailsActivity::class.java)
            startActivity(i)
        }
    }    
    fun View.getLocationOnScreen(): Point
    {
        val location = IntArray(2)
        this.getLocationOnScreen(location)
        return Point(location[0],location[1])
    }
}
package com.example.neighbourly_v1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import app.futured.hauler.setOnDragDismissedListener
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.layout_feed_details.*
import kotlinx.android.synthetic.main.layout_feed_details.type_ans

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        haulerView.setOnDragDismissedListener {
            finish() // finish activity when dismissed
        }

        type_ans.setOnClickListener {
            type_ans.visibility = View.GONE

            type_user.visibility = View.VISIBLE
            type_et.visibility = View.VISIBLE
            type_mic.visibility = View.VISIBLE
            type_send.visibility = View.GONE
        }

        type_et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.trim()?.length == 0 && type_user.visibility == View.GONE) {
                    type_user.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.push_right_in)
                    type_user.visibility = View.VISIBLE
                    type_et.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_left)
                    type_mic.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_left)
                    type_send.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.push_right_out)
                    type_send.visibility = View.GONE
                } else if (type_user.visibility == View.VISIBLE) {
                    type_user.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.push_left_out)
                    type_user.visibility = View.GONE
                    type_et.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_left)
                    type_mic.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_left)
                    type_send.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.push_left_in)
                    type_send.visibility = View.VISIBLE
                }
            }
        })
    }
}
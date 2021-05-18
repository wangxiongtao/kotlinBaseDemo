package com.dawn.kotlinbasedemo.demo.motion

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.dawn.kotlinbasedemo.R

class MotionActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion5)
    }

    fun onClick(view: View) {
        findViewById<ViewGroup>(R.id.sin_ll).visibility=View.VISIBLE
    }
}
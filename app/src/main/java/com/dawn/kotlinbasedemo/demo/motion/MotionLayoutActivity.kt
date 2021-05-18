package com.dawn.kotlinbasedemo.demo.motion

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.dawn.kotlinbasedemo.R

class MotionLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_layout)
        val t=TextView(this);
        t.visibility= View.GONE
        findViewById<MotionLayout>(R.id.motion_layout).setTransitionListener(object: MotionLayout.TransitionListener{
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                Log.e("anim","------onTransitionStarted==p1$p1==p2$p2")
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                Log.e("anim","onTransitionChange==p1$p1==p2$p2==p3$p3")

            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                Log.e("anim","onTransitionCompleted==p1$p1==")
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                Log.e("anim","onTransitionTrigger==p1$p1==p2$p2==p3$p3")
            }

        })
    }

    fun onClick(view: View) {
        findViewById<MotionLayout>(R.id.motion_layout)
    }
}
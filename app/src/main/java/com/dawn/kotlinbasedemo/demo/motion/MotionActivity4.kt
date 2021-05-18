package com.dawn.kotlinbasedemo.demo.motion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.dawn.kotlinbasedemo.R

class MotionActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion4)
        val motionLayout=findViewById<MotionLayout>(R.id.motion_root)
        // 0️⃣ 通过id获取ConstraintSet，id 是xml中对应id
        val constraintSet = motionLayout.getConstraintSet(R.id.end2)
        //1️⃣ 通过id获取Constraint
        constraintSet.getConstraint(R.id.myTextView).apply {
            propertySet.alpha = 0.2f
        }
    }
}
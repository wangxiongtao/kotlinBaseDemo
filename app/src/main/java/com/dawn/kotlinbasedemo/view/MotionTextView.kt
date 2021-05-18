package com.dawn.kotlinbasedemo.view

import android.content.Context
import android.util.AttributeSet


class MotionTextView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyleAttr) {


    fun changeColor(){
        text = "树"
    }
    fun changeColor2(){
        text = "树博"
    }
}
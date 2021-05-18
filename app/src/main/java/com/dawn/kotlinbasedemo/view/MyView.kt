package com.dawn.kotlinbasedemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View


class MyView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View
    (
    context,
    attributeSet,
    defStyleAttr
) {
    init {
        setOnClickListener{
           x=100f
        }

    }





    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.parseColor("#FF6600"))



    }


}
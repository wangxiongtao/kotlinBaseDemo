package com.dawn.kotlinbasedemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.View

class MyView : View {
    constructor(context: Context) : super(context){
        initView("1")
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet){
        initView("2")
    }
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
            context,
            attributeSet,
            defStyleAttr
    ){
        initView("3")
    }

    private fun  initView(a :String){
        Log.e("MyView===>","a==$a")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.BLUE)
    }
}
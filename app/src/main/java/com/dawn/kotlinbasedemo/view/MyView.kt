package com.dawn.kotlinbasedemo.view

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager
import com.dawn.lib_common.util.log


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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        log("specMode===widthMeasureSpec=$widthMeasureSpec=>")
        val specMode = MeasureSpec.getMode(widthMeasureSpec)
        val specSize = MeasureSpec.getSize(widthMeasureSpec)
        log("specMode===specSize==>$specSize")
        val displayMetrics=context.getResources().getDisplayMetrics()
        val wm = context
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wm.defaultDisplay.getMetrics(displayMetrics)

        log("specMode===specSize=widthPixels=>${displayMetrics.widthPixels}")
        val a=context as Activity

        // Apply data from current theme.


//        log("specMode===specSize==>${a.window.mFixedWidthMajor}")
        when (specMode) {
            MeasureSpec.UNSPECIFIED -> {
                log("specMode===UNSPECIFIED==>")
            }
            MeasureSpec.AT_MOST -> {
                log("specMode===AT_MOST==>")
            }
            MeasureSpec.EXACTLY -> {
                log("specMode===EXACTLY==>")
            }
        }

    }





    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.parseColor("#FF6600"))



    }


}
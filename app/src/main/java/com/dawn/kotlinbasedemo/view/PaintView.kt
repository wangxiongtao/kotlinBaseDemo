package com.dawn.kotlinbasedemo.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.dawn.lib_common.util.dp


class PaintView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View
    (
    context,
    attributeSet,
    defStyleAttr
) {
    private val paint: Paint by lazy(LazyThreadSafetyMode.NONE) {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style=Paint.Style.STROKE
            strokeWidth=1f.dp
            // //第一个参数：将原来的路径切成多长的线段,越小，所切成的小线段越多
            //    //第二参数：被切成的每个小线段的可偏移距离。越大，每个线段的可偏移距离就越大。
//            pathEffect = DiscretePathEffect(20f.dp, 30f.dp)//
//            val colorStart = Color.parseColor("#84F125")
//            val colorEnd = Color.parseColor("#5825F1")
            val colorStart = Color.parseColor("#DDDDDD")
            val colorEnd = Color.parseColor("#EEEEEE")
            shader = RadialGradient(
                0f, 0f, 200f,
                colorStart, colorEnd,
                Shader.TileMode.REPEAT

            )
            alpha=128
        }


    }
    private val path: Path by lazy(LazyThreadSafetyMode.NONE) {
        Path().apply {

        }


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.translate(width * 0.5f, width * 0.5f);
        path.moveTo(-200f, 0f);
//        path.lineTo(0f,0f);
        path.lineTo(200f, 0f);

        canvas?.drawPath(path, paint)
        paint.style=Paint.Style.FILL
        canvas?.drawCircle(0f,0f,width*0.5f*0.8f,paint)




    }


}
package com.dawn.kotlinbasedemo.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.dawn.lib_common.util.dp


class PorterDuffXfermodeView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0) : androidx.appcompat.widget.AppCompatImageView
(
        context,
        attributeSet,
        defStyleAttr
)
{
    private var dstBmp: Bitmap? = null
    private var srcBmp: Bitmap? = null
    private var mPaint: Paint? = null
    private var pppp=0f;
    init {


        mPaint = Paint()
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);//禁止硬件加速
        setOnClickListener{

            ValueAnimator.ofFloat(0f,1f).apply {
                addUpdateListener {
                    pppp=it.animatedValue as Float;
                    invalidate()
                }
                start()
            }
        }


    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.clipPath(Path().apply {
            addRoundRect(RectF(0f,0f,width*1f,width*1f),12f.dp,12f.dp, Path.Direction.CCW)
        })
        mPaint?.alpha=64
        canvas.drawCircle(width*0.5f,width*0.5f,width*pppp,mPaint!!)
//        dstBmp = getDSTBitmap(width, width)
//        srcBmp = getSRCBitmap(width, width)
//        canvas.drawBitmap(dstBmp!!, 0f, 0f, mPaint) //绘制目标图形,目标图形是一个圆
//        mPaint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP)
//        canvas!!.drawBitmap(srcBmp!!, 0f,0f, mPaint) //绘制源目标
//        mPaint!!.xfermode = null //将画笔去除Xfermode


    }

    fun getDSTBitmap(w: Int, h: Int): Bitmap? {
        val bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val c = Canvas(bm) //创建一个新的画布,以后在画布上绘制的图形都是绘制在bm上
        val p = Paint(Paint.ANTI_ALIAS_FLAG)
//        p.style=Paint.Style.STROKE
//        p.strokeWidth=10f.dp;
        p.color = Color.parseColor("#44000000")
        c.drawRoundRect(RectF(width*0.5f-width*0.5f*pppp,width*0.5f-width*0.5f*pppp, width*0.5f+width*0.5f*pppp,width*0.5f+width*0.5f*pppp ),12f.dp,12f.dp, p)
        return bm
    }

    fun getSRCBitmap(w: Int, h: Int): Bitmap? {
        val bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val c = Canvas(bm)
        val p = Paint(Paint.ANTI_ALIAS_FLAG)
        p.color = Color.parseColor("#44000000")
        c.drawCircle(width*0.5f,width*0.5f,width*pppp,p)
        return bm
    }

}
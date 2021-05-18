package com.dawn.lib_common.view

import android.R
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import android.view.animation.LinearInterpolator
import com.dawn.lib_common.util.dp


class LoadingButton @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatButton(context, attrs, defStyleAttr) {
    private val mStrokeWidth = 4f.dp
    var startAngle = 0f;
    var sweepAngle = 0f;
    var initAngle = 0f;
    private val rectF: RectF by lazy(LazyThreadSafetyMode.NONE) {
        RectF().apply {
            left = width * 0.5f - height * 0.5f + mStrokeWidth + 5f.dp
            top = mStrokeWidth + 5f.dp
            right = width * 0.5f + height * 0.5f - mStrokeWidth - 5f.dp
            bottom = height * 1f - mStrokeWidth - 5f.dp;
        }
    }

    private val paint: Paint by lazy(LazyThreadSafetyMode.NONE) {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = getColorAccent()
            style = Paint.Style.STROKE
            strokeWidth = mStrokeWidth
        }
    }
    private val anim: ValueAnimator by lazy(LazyThreadSafetyMode.NONE) {
        ValueAnimator.ofFloat(5f, 270 + (360f) + 225f + (90+5)).apply {
            addUpdateListener {
                when (val v = it.animatedValue as Float) {
                    in 5f..270f -> {
                        startAngle = initAngle
                        sweepAngle = v
                    }
                    in 270f..(360f + 270f) -> {
                        startAngle = v - 270f + initAngle;
                        sweepAngle = 270f
                    }
                    in (360f + 270f)..(270 + (360f) + 225f) -> {
                        startAngle = 270 + initAngle
                        sweepAngle = (v - (270 + (360f) + 225f)) - 45f
                    }
                    else -> {
                        startAngle = 225 + (v - (270 + (360f) + 225f)) + initAngle
                        sweepAngle = 45f
                    }

                }
                invalidate()
            }
            repeatCount = -1
            interpolator = LinearInterpolator()
            duration = 1500
        }
    }


    init {

        setOnClickListener {
            anim.start()
        }
    }

    private fun getColorAccent(): Int {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(R.attr.colorAccent, typedValue, true)
        return typedValue.data
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawArc(rectF, startAngle, sweepAngle, false, paint)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        anim.cancel()
        anim.removeAllUpdateListeners()
        anim.removeAllListeners()
    }

}
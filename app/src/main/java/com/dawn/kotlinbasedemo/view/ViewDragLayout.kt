package com.dawn.kotlinbasedemo.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.customview.widget.ViewDragHelper
import com.dawn.lib_common.util.log
import kotlin.math.min


class ViewDragLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var mDragger: ViewDragHelper? = null
    init {
        mDragger = ViewDragHelper.create(this, 1.0f, object :ViewDragHelper.Callback(){
            override fun tryCaptureView(child: View, pointerId: Int): Boolean {
                return true
            }

            override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
                log("clampView==top====$top")
                return min(top,200)
            }

            override fun onViewPositionChanged(
                changedView: View,
                left: Int,
                top: Int,
                dx: Int,
                dy: Int
            ) {
                log("clampView==PositionChanged====$top")
            }

            override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
                log("clampView==onViewReleased===1=${releasedChild.top}")
                log("clampView==onViewReleased===topMargin=${(releasedChild.layoutParams as LayoutParams).topMargin}")
                releasedChild.offsetTopAndBottom(-releasedChild.top)
            }

        });


    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return mDragger!!.shouldInterceptTouchEvent(ev!!)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        mDragger!!.processTouchEvent(event!!)
        return true
    }

}
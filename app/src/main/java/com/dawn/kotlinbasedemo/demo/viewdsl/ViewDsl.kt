package com.dawn.kotlinbasedemo.demo.viewdsl

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.dawn.lib_common.util.dp

fun Context.ConstraintLayout(bloc: LinearLayout.() -> Unit):ViewGroup{
    var view=LinearLayout(this);
     bloc(view);
    return view;
}
inline var View.background_color: String
    get() {
        return ""
    }
    set(value) {
        setBackgroundColor(Color.parseColor(value))
    }
inline var View.layout_width : Int
    get() {
        return layoutParams.width
    }
    set(value) {
        val w = if (value > 0) value.dp else value
        val h = layoutParams?.height ?: 0
        layoutParams = ViewGroup.MarginLayoutParams(w, h)

    }
inline var View.layout_height : Int
    get() {
        return layoutParams.height
    }
    set(value) {
        val h = if (value > 0) value.dp else value
        val w = layoutParams?.width ?: 0
        layoutParams = ViewGroup.MarginLayoutParams(w, h)

    }

fun ViewGroup.TextView(bloc: TextView.() -> Unit){
    addView(TextView(context).apply(bloc));
}
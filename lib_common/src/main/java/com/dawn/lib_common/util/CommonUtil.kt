package com.dawn.lib_common.util

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.dawn.lib_common.base.BaseApp

fun log(msg: String) {
    Log.e("log", msg);
}


fun toast(string: String) {
    Toast.makeText(BaseApp.myApp, string, Toast.LENGTH_SHORT).show()
}

/**
 * 一般结合takeIf使用
 * @param content String?
 * @param notShow Boolean
 * @return Boolean
 */
fun takeToast(content: String?, notShow: Boolean): Boolean {
    if (!notShow) {
        toast(content ?: "null")
    }
    return notShow
}

val Float.dp
    get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this,
            Resources.getSystem().displayMetrics
    )
val Float.intDp
    get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this,
            Resources.getSystem().displayMetrics
    ).toInt()
val Int.dp
    get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            Resources.getSystem().displayMetrics
    ).toInt()

/**
 * 设置View的shape公共方法
 * 在XML设置属性即可
 * 单位全是dp
 * 例如 设置背景的圆角的角度为10dp：
 * app:borderRadius="@{10}"
 *
 * @param view View
 * @param radius Float 圆角的角度
 * @param borderWidth Int 边框线的宽度
 * @param borderColor String? 边框的线的颜色
 */
@BindingAdapter("radius", "borderWidth", "borderColor", requireAll = false)
fun setBorderShape(view: View, radius: Float, borderWidth: Int, borderColor: String?) {
    view.background = GradientDrawable().apply {
        (view.background as? ColorDrawable)?.color?.apply {
            setColor(this)//颜色取背景颜色（backgroundColor）
        }
        cornerRadius = radius.dp;
        setStroke(borderWidth.dp, Color.parseColor(borderColor ?: "#FFFFFF"))

    }

}





















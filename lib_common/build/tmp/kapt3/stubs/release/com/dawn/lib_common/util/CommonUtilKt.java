package com.dawn.lib_common.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a*\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007\u001a\u0018\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0014\u001a\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0019"}, d2 = {"dp", "", "getDp", "(F)F", "", "(I)I", "intDp", "getIntDp", "(F)I", "log", "", "msg", "", "setBorderShape", "view", "Landroid/view/View;", "radius", "borderWidth", "borderColor", "takeToast", "", "content", "notShow", "toast", "string", "lib_common_release"})
public final class CommonUtilKt {
    
    public static final void log(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public static final void toast(@org.jetbrains.annotations.NotNull()
    java.lang.String string) {
    }
    
    /**
     * 一般结合takeIf使用
     * @param content String?
     * @param notShow Boolean
     * @return Boolean
     */
    public static final boolean takeToast(@org.jetbrains.annotations.Nullable()
    java.lang.String content, boolean notShow) {
        return false;
    }
    
    public static final float getDp(float $this$dp) {
        return 0.0F;
    }
    
    public static final int getIntDp(float $this$intDp) {
        return 0;
    }
    
    public static final int getDp(int $this$dp) {
        return 0;
    }
    
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
    @androidx.databinding.BindingAdapter(value = {"radius", "borderWidth", "borderColor"}, requireAll = false)
    public static final void setBorderShape(@org.jetbrains.annotations.NotNull()
    android.view.View view, float radius, int borderWidth, @org.jetbrains.annotations.Nullable()
    java.lang.String borderColor) {
    }
}
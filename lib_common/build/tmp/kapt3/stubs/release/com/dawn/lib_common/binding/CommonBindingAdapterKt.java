package com.dawn.lib_common.binding;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001aB\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a4\u0010\u0010\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007\u001a\u0018\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0007\u001a\u001a\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007\u001a\u001a\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u000fH\u0007\u00a8\u0006#"}, d2 = {"setAnimation", "", "view", "Landroid/view/View;", "animation", "Landroid/view/animation/Animation;", "setBorderShape", "topLeftRadius", "", "topRightRadius", "bottomLeftRadius", "bottomRightRadius", "borderWidth", "", "borderColor", "", "setDataList", "T", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "list", "", "adapter", "Lcom/dawn/lib_common/binding/recyclerview/RVItemAdapter;", "setImageViewResource", "imageView", "Landroid/widget/ImageView;", "resource", "setLineManager", "type", "Lcom/dawn/lib_common/binding/recyclerview/DividerLine$LineDrawMode;", "setTextColor", "textView", "Landroid/widget/TextView;", "color", "lib_common_release"})
public final class CommonBindingAdapterKt {
    
    @androidx.databinding.BindingAdapter(value = {"dataList", "adapter"})
    public static final <T extends java.lang.Object>void setDataList(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> list, @org.jetbrains.annotations.NotNull()
    com.dawn.lib_common.binding.recyclerview.RVItemAdapter<T> adapter) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"lineManager"})
    public static final void setLineManager(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.Nullable()
    com.dawn.lib_common.binding.recyclerview.DividerLine.LineDrawMode type) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"android:src"})
    public static final void setImageViewResource(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, int resource) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"android:textColor"})
    public static final void setTextColor(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.String color) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"tweenAnimation"})
    public static final void setAnimation(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.view.animation.Animation animation) {
    }
    
    /**
     * 同setBorderShape
     * 不过可以指定每个角的角度 不传则为0
     * @param view View
     * @param topLeftRadius Float 左上角（参数根据单词以此类推）
     * @param topRightRadius Float
     * @param bottomLeftRadius Float
     * @param bottomRightRadius Float
     * @param borderWidth Int
     * @param borderColor String?
     */
    @androidx.databinding.BindingAdapter(value = {"topLeftRadius", "topRightRadius", "bottomLeftRadius", "bottomRightRadius", "borderWidth", "borderColor"}, requireAll = false)
    public static final void setBorderShape(@org.jetbrains.annotations.NotNull()
    android.view.View view, float topLeftRadius, float topRightRadius, float bottomLeftRadius, float bottomRightRadius, int borderWidth, @org.jetbrains.annotations.Nullable()
    java.lang.String borderColor) {
    }
}
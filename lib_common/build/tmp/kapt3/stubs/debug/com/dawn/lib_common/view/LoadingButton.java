package com.dawn.lib_common.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010&\u001a\u00020\u0007H\u0002J\b\u0010\'\u001a\u00020(H\u0014J\u0010\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+H\u0014R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010#\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014\u00a8\u0006,"}, d2 = {"Lcom/dawn/lib_common/view/LoadingButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anim", "Landroid/animation/ValueAnimator;", "getAnim", "()Landroid/animation/ValueAnimator;", "anim$delegate", "Lkotlin/Lazy;", "initAngle", "", "getInitAngle", "()F", "setInitAngle", "(F)V", "mStrokeWidth", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "rectF", "Landroid/graphics/RectF;", "getRectF", "()Landroid/graphics/RectF;", "rectF$delegate", "startAngle", "getStartAngle", "setStartAngle", "sweepAngle", "getSweepAngle", "setSweepAngle", "getColorAccent", "onDetachedFromWindow", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "lib_common_debug"})
public final class LoadingButton extends androidx.appcompat.widget.AppCompatButton {
    private final float mStrokeWidth = 0.0F;
    private float startAngle = 0.0F;
    private float sweepAngle = 0.0F;
    private float initAngle = 0.0F;
    private final kotlin.Lazy rectF$delegate = null;
    private final kotlin.Lazy paint$delegate = null;
    private final kotlin.Lazy anim$delegate = null;
    
    public final float getStartAngle() {
        return 0.0F;
    }
    
    public final void setStartAngle(float p0) {
    }
    
    public final float getSweepAngle() {
        return 0.0F;
    }
    
    public final void setSweepAngle(float p0) {
    }
    
    public final float getInitAngle() {
        return 0.0F;
    }
    
    public final void setInitAngle(float p0) {
    }
    
    private final android.graphics.RectF getRectF() {
        return null;
    }
    
    private final android.graphics.Paint getPaint() {
        return null;
    }
    
    private final android.animation.ValueAnimator getAnim() {
        return null;
    }
    
    private final int getColorAccent() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    protected void onDetachedFromWindow() {
    }
    
    public LoadingButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public LoadingButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public LoadingButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
}
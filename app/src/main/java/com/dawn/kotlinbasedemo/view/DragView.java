package com.dawn.kotlinbasedemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 可以滑动到指定的left值和top值区域的ImageView
 */
public class DragView extends View {
    private int downX;
    private int downY;
    private int targetLeft=150;
    private int targetTop=0;
    private int oriLeft=-1;
    private int oriTop=-1;
    private View targetView;//需要填空的view
    private View rooView;//填空view父view
    public DragView(Context context) {
        super(context);
        setEnabled(true);
        setClickable(true);
    }

    public DragView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setEnabled(true);
        setClickable(true);
    }

    public DragView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setEnabled(true);
        setClickable(true);
    }





    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                initLeftAndTop();
                downX=x;
                downY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - downX;
                int offsetY = y - downY;
                offsetTopAndBottom(offsetY);
                offsetLeftAndRight(offsetX);

                break;
            case MotionEvent.ACTION_UP:
//                if(isSuccess()){
//                    offsetTopAndBottom(targetTop-getTop());
//                    offsetLeftAndRight(targetLeft-getLeft());
//                    setEnabled(false);
//                    setClickable(false);
//                }else {
//                    //错误则还原到初始位置
//                    offsetTopAndBottom(oriTop-getTop());
//                    offsetLeftAndRight(oriLeft-getLeft());
//                }
                break;
        }
        return super.onTouchEvent(event);
    }


    private boolean isSuccess(){
        boolean topSuccess=getTop()>=(targetTop-getWidth()*0.5)&&getTop()<=targetTop+getHeight()*0.8;
        boolean leftSuccess1=getLeft()>=(targetLeft-getWidth()*0.5)&&getLeft()<=(targetLeft+getWidth()*0.8);
        return  topSuccess&&leftSuccess1&&targetTop>=0&&targetLeft>=0;
    }






    private void initLeftAndTop(){
        if(oriTop<0){
            oriTop=getTop();
        }
        if(oriLeft<0){
            oriLeft=getLeft();
        }

        if(targetView!=null){
            if(targetTop<0){
                targetTop=targetView.getTop()+rooView.getTop();
            }
            if(targetLeft<0){
                targetLeft=targetView.getLeft()+rooView.getLeft();
            }
        }
    }
}

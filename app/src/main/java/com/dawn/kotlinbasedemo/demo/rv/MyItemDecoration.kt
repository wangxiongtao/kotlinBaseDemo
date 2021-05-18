package com.dawn.kotlinbasedemo.demo.rv

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dawn.lib_common.util.dp
import com.dawn.lib_common.util.log

class MyItemDecoration :RecyclerView.ItemDecoration() {
    var needGroup:((position:Int)->Boolean)?=null
    var groupName:((position:Int)->String?)?=null


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {


        val itemIndex=parent.getChildAdapterPosition(view)
        if(needGroup?.invoke(itemIndex) == true){
            outRect.top=50.dp
        }


//        val layoutIndex=parent.getChildLayoutPosition(view)



    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)





        for (i in 0 until parent.childCount){
            val view=parent.getChildAt(i);

            val itemPosition=parent.getChildAdapterPosition(view);
            log("=MyItemDecoration=onDraw===${view.top}=")

            c.drawText(groupName?.invoke(itemPosition)?:"",10f.dp,view.top-25f.dp, Paint(Paint.ANTI_ALIAS_FLAG).apply {
                textSize=20f.dp
            })
        }

    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val rect=Rect(0,0,parent.right,50.dp)

        c.drawRect(rect,Paint().apply {
            color= Color.parseColor("#FF6600")
        })

        c.drawText(
            groupName?.invoke((parent.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()) ?: "",
            10f.dp,
            25f.dp,
            Paint(Paint.ANTI_ALIAS_FLAG).apply {
                textSize = 20f.dp
                color=Color.WHITE
            })

    }
}
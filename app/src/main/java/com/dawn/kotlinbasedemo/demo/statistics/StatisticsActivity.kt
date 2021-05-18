package com.dawn.kotlinbasedemo.demo.statistics

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.dawn.kotlinbasedemo.R
import com.dawn.lib_common.util.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class StatisticsActivity : AppCompatActivity() {
    lateinit var btn: Button
    val list=ArrayList<View>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_satistics)
        btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            testFlow()



        }

        val viewGroup=findViewById<ViewGroup>(android.R.id.content);
        viewGroup.post {
//            getAllChild(viewGroup)
        }





    }

    fun testFlow() {
        log("==flow==testFlow=thread==${Thread.currentThread().name}=")
        try {
            GlobalScope.launch(Dispatchers.Main) {
                flow {
                    (1..3).forEach{
                        log("==flow==forEach=thread==${Thread.currentThread().name}=")
                        delay(1000)
                        emit(it)
                    }
                }.map {
                    log("==flow==map=thread==${Thread.currentThread().name}=")
                    it*it
                }
                    .collect {
                        log("==flow=collect=${it}==thread==${Thread.currentThread().name}=")
                    }


            }
        }catch (e: Exception){
            log("==flow==Exception=thread==${e.localizedMessage}=")
        }

    }

    fun getAllChild(view: ViewGroup) {
        for (index in 0 until view.childCount) {
            val childView = view.getChildAt(index)
            if (childView is ViewGroup) {
                log("=====childView==ViewGroup==>${childView}")
                getAllChild(childView)
            } else {
                log("=====childView====>${childView}")
                val rect = Rect()
                childView.getGlobalVisibleRect(rect)//全屏的 包括 toolbar
                childView.setTag(R.id.tag_rect,rect)
                list.add(childView)

            }
        }

    }

//    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
//        val x = event?.rawX
//        val y = event?.rawY
//        when (event?.action) {
//            MotionEvent.ACTION_DOWN -> {
//                log("==event==ACTION_DOWN===x==$x==y===$y")
//                val view=list.find {
//                    val rect=it.getTag(R.id.tag_rect) as Rect
//                    rect.contains(x?.toInt() ?: 0, y?.toInt() ?: 0)
//                }
//                log("==event==ACTION_UP===view==$view")
//                if(view!=null){
//                    toast("click==down=success")
//                }
//            }
//            MotionEvent.ACTION_MOVE -> {
//                log("==event==ACTION_MOVE===x==$x==y===$y")
//            }
//            MotionEvent.ACTION_UP -> {
//                log("==event==ACTION_UP===x==$x==y===$y")
//                val view=list.find {
//                    val rect=it.getTag(R.id.tag_rect) as Rect
//                    rect.contains(x?.toInt() ?: 0, y?.toInt() ?: 0)
//                }
//                log("==event==ACTION_UP===view==$view")
//                if(view!=null){
//                    toast("click===success")
//                }
//            }
//        }
//        return super.dispatchTouchEvent(event)
//    }
}
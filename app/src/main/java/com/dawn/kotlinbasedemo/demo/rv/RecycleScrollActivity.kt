package com.dawn.kotlinbasedemo.demo.rv
import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dawn.kotlinbasedemo.BR
import com.dawn.kotlinbasedemo.R
import com.dawn.kotlinbasedemo.databinding.ActivityRecycleScrollBinding
import com.dawn.lib_common.base.BaseActivity
import com.dawn.lib_common.util.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class RecycleScrollActivity : BaseActivity<ActivityRecycleScrollBinding, RvVm>() {

    private var index=0;
    private var job: Job?=null

    override fun getLayoutId(): Int = R.layout.activity_recycle_scroll


    override fun initData(savedInstanceState: Bundle?) {
        viewDataBinding.startScrollBtn.setOnClickListener {
            Log.e("dataRv==scrollY1==>","${viewDataBinding.dataRv.scrollY}")
            Log.e("dataRv==scrollY1==>","${viewDataBinding.dataRv.computeVerticalScrollOffset()}")



            viewDataBinding.dataRv.smoothScrollBy(0,viewDataBinding.dataRv.getChildAt(0).top+220)
//            viewDataBinding.dataRv.scrollToPosition(4)
        }
        viewDataBinding.startDownBtn.setOnClickListener {

//            val item=viewDataBinding.dataRv.getChildAt(0);
//            viewDataBinding.dataRv.smoothScrollBy(0,item.top-220)
            val manager = viewDataBinding.dataRv.layoutManager as LinearLayoutManager?
        manager?.scrollToPositionWithOffset(2, 0)//屏幕内的item 无动画
//            viewDataBinding.dataRv.scrollToPosition(4)
        }
        viewDataBinding.startIndexBtn.setOnClickListener {

            setResult(Activity.RESULT_OK)
//            val item=viewDataBinding.dataRv.getChildAt(0);
            log("scrollY===index==${index}")
            viewDataBinding.dataRv.smoothScrollBy(0,220*index-viewDataBinding.dataRv.computeVerticalScrollOffset())
            job=GlobalScope.launch {
                while (true){
                    delay(1000)
                    log("===GlobalScope===")
                }

            }
        }

    }

    override fun getVariableId(): Int {
        return BR.rvvm
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }

    private fun scrollItemTo(position: Int, recyclerView: RecyclerView) {
//        val smoothScroller =  LinearTopSmoothScroller(recyclerView.context);
//        val p=if(position<=0) 0 else position
//        val smoothScroller = object :LinearSmoothScroller(recyclerView.context){
//            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics?): Float {
//                return 400f / displayMetrics!!.densityDpi
//            }
//        }
//        smoothScroller.targetPosition = p;
//        recyclerView.layoutManager?.startSmoothScroll(smoothScroller);







//        val manager = recyclerView.layoutManager as LinearLayoutManager?
//        manager?.scrollToPositionWithOffset(position, 0)//屏幕内的item 无动画
//        recyclerView.scrollToPosition(1)//只滑动屏幕外的item
//        recyclerView.smoothScrollToPosition(position)
        val x=recyclerView.getChildAt(position)?.left?:0+recyclerView.scrollX
//        recyclerView.smoothScrollBy(a,0)
//        a+=10
    }
}









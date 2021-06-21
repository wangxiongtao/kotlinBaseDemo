package com.dawn.kotlinbasedemo.vm

import android.util.Log
import android.view.animation.AnimationUtils
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.viewModelScope
import com.dawn.kotlinbasedemo.BR
import com.dawn.kotlinbasedemo.R
import com.dawn.kotlinbasedemo.api.request
import com.dawn.kotlinbasedemo.api.requestFlow
import com.dawn.kotlinbasedemo.api.requestSimple
import com.dawn.kotlinbasedemo.demo.ViewDragHelperActivity
import com.dawn.kotlinbasedemo.demo.circularreveal.CircularRevealActivity
import com.dawn.kotlinbasedemo.demo.motion.*
import com.dawn.kotlinbasedemo.demo.paging2.PagingNewActivity
import com.dawn.kotlinbasedemo.demo.paint.PaintActivity
import com.dawn.kotlinbasedemo.demo.rv.RecycleActivity
import com.dawn.kotlinbasedemo.demo.rv.RecycleDiffActivity
import com.dawn.kotlinbasedemo.demo.rv.RecycleScrollActivity
import com.dawn.kotlinbasedemo.demo.statistics.StatisticsActivity
import com.dawn.kotlinbasedemo.demo.viewdsl.ViewDSLActivity
import com.dawn.lib_common.base.BaseViewModel
import com.dawn.lib_common.binding.recyclerview.RVItemAdapter
import com.dawn.lib_common.http.ApiException
import com.dawn.lib_common.http.catchException
import com.dawn.lib_common.http.next
import com.dawn.lib_common.util.takeToast
import com.dawn.lib_common.util.toast
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.IOException

class MainVm : BaseViewModel() {
    val responseText = ObservableField<String>("11111");
    private val phone = "";
    val pwd = "";
    val dataList = ObservableArrayList<ActItemBean>()

    val handler = CoroutineExceptionHandler { _, exception ->
        Log.e("handler>thread2====>", "${Thread.currentThread().name}==${exception}")
    }


    val adapter = object : RVItemAdapter<ActItemBean>() {
        override fun getLayoutId(viewType: Int): Int {
            return R.layout.item_rv
        }

        override fun onBindViewHolder(
            binding: ViewDataBinding,
            item: ActItemBean,
            position: Int
        ) {
            binding.setVariable(BR.item, item)
            binding.setVariable(BR.position, "$position")
            binding.root.setOnClickListener {
                startActivity.value = item.clas
            }


        }

        override fun onViewAttachedToWindow(holder: ViewHolder) {
            val rotateAnimation =
                AnimationUtils.loadAnimation(holder.itemView.context, R.anim.my_anim);
            holder.itemView.startAnimation(rotateAnimation);
        }

        override fun onViewDetachedFromWindow(holder: ViewHolder) {
            holder.itemView.clearAnimation()
        }

    }

    override fun onCreate() {
        super.onCreate()
//        requestData()
        funFlowRequest()
        viewModelScope.launch {
            delay(2000)
            dataList.add(ActItemBean("D", RecycleActivity::class.java))
            dataList.add(ActItemBean("paint", PaintActivity::class.java))
            dataList.add(ActItemBean("view-DSL", ViewDSLActivity::class.java))
            dataList.add(ActItemBean("MotionLayout", MotionLayoutActivity::class.java))
            dataList.add(ActItemBean("MotionLayout2", MotionActivity2::class.java))
            dataList.add(ActItemBean("MotionLayout3", MotionActivity3::class.java))
            dataList.add(ActItemBean("MotionLayout4", MotionActivity4::class.java))
            dataList.add(ActItemBean("MotionLayout5", MotionActivity5::class.java))
            dataList.add(ActItemBean("Page3", PagingNewActivity::class.java))
            dataList.add(ActItemBean("CircularReveal", CircularRevealActivity::class.java))
            dataList.add(ActItemBean("view坐标统计", StatisticsActivity::class.java))
            dataList.add(ActItemBean("RecycleviewScroll", RecycleScrollActivity::class.java))
            dataList.add(ActItemBean("RecycleDiff", RecycleDiffActivity::class.java))
            dataList.add(ActItemBean("ViewDragHelperActivity", ViewDragHelperActivity::class.java))
        }


    }

    private fun funFlowRequest() {
        viewModelScope.launch {
            requestFlow {
                getListProject();
            }.catch{ cause ->
                run {
                    when(cause){
                        is ApiException->{

                        }
                    }

                }
            }.collect {
                    Log.e("data===>", "data==requestFlow===>${it?.data}")
                }
        }
    }

    /**
     * 请求网络
     */
    fun requestData() {
        viewModelScope.launch {
            request(false) {
                getListProject();
            }.next {
                Log.e("data===>", "data=====>${this.data}")
                responseText.set(this.data.toString())
            }.catchException {
                when (this) {
                    is ApiException -> {

                    }
                    is IOException -> {

                    }
                    else -> {

                    }
                }
            }
        }
    }

    /**
     * 轮询
     */
    fun requestLoopData() {
        viewModelScope.launch {
            runCatching {
                while (true) {
                    requestSimple {
                        getListProject();
                    }.next {
                        Log.e("data===>", "requestLoopData=====>${this.data}")
                    }
                    delay(1 * 1000)//1s请求一次
                }

            }
        }

    }

    /**
     * 类似登录功能的前置判断的流式写法
     */
    fun requestWithTake() {
        viewModelScope.launch {
            takeIf {
                takeToast("请输入电话号码", !phone.isNullOrEmpty())
            }?.takeIf {
                takeToast("请输入密码", !pwd.isNullOrEmpty())
            }?.apply {
                request {
                    getListProject();
                }.next {
                    toast("请求成功")
                }
            }
        }

    }

    fun startAct() {
        startActivity.value
    }


}
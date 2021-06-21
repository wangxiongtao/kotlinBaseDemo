package com.dawn.kotlinbasedemo.demo.rv

import androidx.databinding.ObservableArrayList
import androidx.databinding.ViewDataBinding
import com.dawn.kotlinbasedemo.BR
import com.dawn.kotlinbasedemo.R
import com.dawn.kotlinbasedemo.demo.rv.data.GroupDataBean
import com.dawn.lib_common.base.BaseViewModel
import com.dawn.lib_common.binding.recyclerview.RVItemAdapter
import com.dawn.lib_common.util.log
import com.dawn.lib_common.util.toast

class RvVm:BaseViewModel() {
    val dataList1=ArrayList<String>();
    val dataList=ObservableArrayList<GroupDataBean>();
    val adapter=object :RVItemAdapter<GroupDataBean>(){
        override fun getLayoutId(viewType: Int): Int {
            log("=MyItemDecoration=getLayoutId==")
            return R.layout.item_rv2
        }

        override fun onBindViewHolder(binding: ViewDataBinding?, item: GroupDataBean?, position: Int) {
            binding?.setVariable(BR.item,   item);
            binding?.setVariable(BR.position,   position);
            binding?.root?.setOnClickListener {
                toast("ppppp==${position}")
            }
        }

    }
    val adapter2=object :RVItemAdapter<GroupDataBean>(){
        override fun getLayoutId(viewType: Int): Int {
            log("=MyItemDecoration=getLayoutId==")
            return R.layout.item_srcoll_rv
        }

        override fun onBindViewHolder(binding: ViewDataBinding?, item: GroupDataBean?, position: Int) {
            binding?.setVariable(BR.item,   item);
            binding?.setVariable(BR.position,   position);
            binding?.root?.setOnClickListener {
                toast("ppppp==${position}")
            }
        }

    }

    override fun onCreate() {
        super.onCreate()
        dataList1.add("a1")
        dataList1.add("a2")
        dataList1.add("a3")
        dataList1.add("b1")
        dataList1.add("b2")
        dataList1.add("b3")
        dataList1.add("c1")
        dataList1.add("c2")
        dataList1.add("d1")
        dataList1.add("d2")
        dataList1.add("d3")
        dataList1.add("d4")
        dataList1.add("d1")
        dataList1.add("d2")
        dataList1.add("d1")
        dataList1.add("died")

        var lastString="";
        dataList1.forEachIndexed { index, s ->
            val dataBean=GroupDataBean();
            dataBean.name=s;
//            if(index<dataList1.size-1){
//                val nextS=dataList1[index+1];
//                dataBean.isGroupHead = s.substring(0,1)!=nextS.substring(0,1)
//            }
            if(s.substring(0,1)!=lastString){
                dataBean.isGroupHead=true;
                lastString=s.substring(0,1)
            }

            dataList.add(dataBean)

        }

    }
}
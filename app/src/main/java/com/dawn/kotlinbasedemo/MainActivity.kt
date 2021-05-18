package com.dawn.kotlinbasedemo

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearSmoothScroller
import com.dawn.kotlinbasedemo.databinding.ActivityMainBinding
import com.dawn.kotlinbasedemo.vm.MainVm
import com.dawn.lib_common.base.BaseActivity
import com.dawn.lib_common.util.dp
import com.github.promeg.pinyinhelper.Pinyin
import com.hyy.highlightpro.HighlightPro
import com.hyy.highlightpro.parameter.Constraints
import com.hyy.highlightpro.parameter.HighlightParameter
import com.hyy.highlightpro.parameter.MarginOffset
import com.hyy.highlightpro.shape.CircleShape
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : BaseActivity<ActivityMainBinding, MainVm>() {
    var  listData:MutableList<String>?=null;
    val list: MutableList<String> = ArrayList()



    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    @ExperimentalStdlibApi
    override fun initData(savedInstanceState: Bundle?) {
//        add()
        listData=ArrayList();
        listData?.add("2222")
        list.add("222")


        GlobalScope.launch(Dispatchers.Main.immediate) {
            delay(2000)
            show()
        }
        viewDataBinding.btnStepFirst.setOnClickListener{
//            val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.my_anim);
//            viewDataBinding.btnStepFirst.startAnimation(rotateAnimation);
            add()
            startAPP("com.kamridor.treector")
        }


        //a e i o u

        Log.e("toPinyin===>", "toPinyin=====>${Pinyin.toPinyin('孤').lowercase()}")
//        equalsWords("孤单", "好代")

        val keyWords = "博士很"
        val text = "我太孤单了,树博士很孤"
        var count = 0;

        var list=ArrayList<String>();

        text.mapIndexed { index, _ ->
            if (index + keyWords.length <= text.length) {
                val o = text.substring(index, index + keyWords.length)
               list.add(o);

            }


        }
        list.forEach{
            if ( equalsWords(keyWords, it)){
                Log.e("toPinyin--", "---------------匹配正确------keyWords=${keyWords}---text=${it}")
                return@initData

            }



        }







        viewModel.startActivity.observe(this) {
            onStartActivity(it);
        }
//        viewModel.requestLoopData();
//        viewModel.requestWithTake()


    }

    override fun onStartActivity(param: Any) {
        startActivity(Intent(this, param as Class<*>))
    }

   fun startAPP( appPackageName:String){
        try{
            val intent = this.packageManager.getLaunchIntentForPackage(appPackageName);
            startActivity(intent);
        }catch(e :Exception){
            Toast.makeText(this, "没有安装", Toast.LENGTH_LONG).show();
        }
    }


    override fun getVariableId(): Int {
        return BR.mainVm

    }
    fun add(){
        val smoothScroller: LinearSmoothScroller = LinearTopSmoothScroller(this)
        smoothScroller.targetPosition = 20
        viewDataBinding.dataRv?.layoutManager?.startSmoothScroll(smoothScroller)
    }

    fun show(){
        HighlightPro.with(this)
            .setHighlightParameter {
                HighlightParameter.Builder()
                    .setHighlightViewId(R.id.btn_step_first)
                    .setTipsViewId(R.layout.guide_step_first)
                    .setHighlightShape(CircleShape(4f.dp))
                    .setHighlightHorizontalPadding(8f.dp)
                    .setConstraints(Constraints.BottomToTopOfHighlight + Constraints.StartToStartOfHighlight)
                    .setMarginOffset(MarginOffset(start = 8.dp))
                    .build()
            }
            .setBackgroundColor(Color.parseColor("#80000000"))
            .setOnShowCallback { index ->
                //do something
            }
            .setOnDismissCallback {
                //do something
            }
            .show()


    }


    @ExperimentalStdlibApi
    fun equalsWords(keyWords: String, words: String): Boolean {
        Log.e("toPinyin--", "-------equalsWords------keyWords=${keyWords}---text=${words}")
        if(keyWords==words){
            Log.e("toPinyin--", "-------equalsWords-文字匹配")
            return true
        }
        Log.e("toPinyin--", "-------equalsWords-文字没有匹配---匹配读音")




        return equalsWords1(keyWords, words)



//        Log.e("==toPinyin=count", "equalsWords=keyWords===${keyWords}------比较------读出的文字==${s2}")
//        var count = 0;
//        val s11 = Pinyin.toPinyin(keyWords, ".").lowercase()
//        val s12 = Pinyin.toPinyin(s2, ".").lowercase()
//        val data1 = s11.split(".")
//        val data2 = s12.split(".")
//        data1.forEachIndexed { index, s ->
//            val d = data2[index]
//            if(!equalsPinYin(s,d)){
//
//            }
//
//            if (equalsPinYin(s, d)){
//                count++;
//            }
//
//
//        }
//        Log.e("==toPinyin=count", "$count")
//        return count
    }

    /**
     * 比较两个词语(孤单，古代)
     * @param keyWords String
     * @param words String
     * @return Boolean
     */
    fun equalsWords1(keyWords: String, words: String):Boolean{
        var count=0
        keyWords.forEachIndexed { index, c ->
            if(equalsChar(c, words[index])){
                count++
            }
        }
        Log.e("==toPinyin=count", "equalsWords1===${count}----")
        if(count==keyWords.length){
            return true
        }
        return false

    }

    /**
     * 比较两个汉字 (孤，古)
     */
   fun equalsChar(keyWords: Char, words: Char):Boolean{
       if(keyWords==words){
           return true
       }
       return equalsPinYin(keyWords, words);
   }

    /**
     * (gu，gu)
     * @param keyWords Char
     * @param words Char
     * @return Boolean
     */
    fun equalsPinYin(keyWords: Char, words: Char): Boolean {
        Log.e("==toPinyin=count", "equalsPinYin===${keyWords}---${words}----")
        val s1=Pinyin.toPinyin(keyWords);
        val s2=Pinyin.toPinyin(words);
        val ss1 = s1.substring(0, 1)
        val ss2 = s2.substring(0, 1)


        if (ss1!==ss2){

            return false
        }
        Log.e("==toPinyin=count", "equalsPinYin===true==")

        val yy1 = s1.substring(1);
        val yy2 = s2.substring(1);
        return true

    }


}

 class LinearTopSmoothScroller(context: Context?) : LinearSmoothScroller(context) {
     override fun getVerticalSnapPreference(): Int {
         return SNAP_TO_START;
     }
}
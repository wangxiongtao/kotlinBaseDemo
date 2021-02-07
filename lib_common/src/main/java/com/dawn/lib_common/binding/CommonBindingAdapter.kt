package com.dawn.lib_common.binding

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dawn.lib_common.binding.recyclerview.DividerLine
import com.dawn.lib_common.binding.recyclerview.DividerLine.LineDrawMode
import com.dawn.lib_common.binding.recyclerview.RVItemAdapter
import com.dawn.lib_common.util.dp


@BindingAdapter("dataList", "adapter")
fun <T> setDataList(recyclerView: RecyclerView, list: List<T>?, adapter: RVItemAdapter<T>) {
    val itemAdapter = recyclerView.adapter as RVItemAdapter<T>?
    if (itemAdapter == null) {
        adapter.setList(list)
        recyclerView.adapter = adapter
    } else {
        itemAdapter.notifyDataSetChanged()
    }
}

@BindingAdapter("lineManager")
fun setLineManager(recyclerView: RecyclerView, type: LineDrawMode?) {
    recyclerView.addItemDecoration(DividerLine(recyclerView.context, type))
}

//    @BindingAdapter({"dataList","adapter"})
//    public static <T> void setDataList(RecyclerView recyclerView, List<T> list, ItemAdapter<T> adapter){
//       ItemAdapter<T>  itemAdapter= (ItemAdapter<T>) recyclerView.getAdapter();
//        if(itemAdapter==null){
//            itemAdapter=adapter;
//            adapter.setList(list);
//            recyclerView.setAdapter(adapter);
//        }
//        itemAdapter.notifyDataSetChanged();
//
//    }
//    @BindingAdapter("imageUrl")
//    public static <T> void setImageUrl(ImageView imageView, String imageUrl){
//        imageUrl="https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2839262297,1897381364&fm=26&gp=0.jpg";
//        GlideApp.with(imageView.getContext()).load(imageUrl).placeholder(imageView.getDrawable()).error(imageView.getDrawable()).into(imageView);
//
//    }
@BindingAdapter("android:src")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

@BindingAdapter("android:textColor")
fun setTextColor(textView: TextView, color: String?) {
    textView.setTextColor(Color.parseColor(color))
}

@BindingAdapter("tweenAnimation")
fun setAnimation(view: View, animation: Animation?) {
    if (animation == null) {
        view.clearAnimation()
        return
    }
    view.startAnimation(animation)
} //    @BindingAdapter(value = {"bannerAdapter","bannerListener","bannerChangeListener"},requireAll = false)
//    public static <T,BA extends BannerAdapter<T,VH>,VH extends RecyclerView.ViewHolder>void setBannerAdapter(Banner<T,BA> banner, BA adapter, OnBannerListener<T>listener, OnPageChangeListener pageChangeListener){
//        Context context=banner.getContext();
//        if(context instanceof LifecycleOwner){
//            banner.addBannerLifecycleObserver((LifecycleOwner) banner.getContext());
//        }
//        banner.setIndicator(new CircleIndicator(banner.getContext()));
//        banner.setAdapter(adapter);
//        banner.setOnBannerListener(listener);
//        banner.addOnPageChangeListener(pageChangeListener);
//    }
//    @BindingAdapter("bannerList")
//    public static <T,BA extends BannerAdapter<T,VH>,VH extends RecyclerView.ViewHolder>void setBannerList(Banner<T,BA> banner, List<T> list){
//        banner.setDatas(list);
//    }
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
@BindingAdapter(
    "topLeftRadius",
    "topRightRadius",
    "bottomLeftRadius",
    "bottomRightRadius",
    "borderWidth",
    "borderColor",
    requireAll = false
)
fun setBorderShape(
    view: View,
    topLeftRadius: Float,
    topRightRadius: Float,
    bottomLeftRadius: Float,
    bottomRightRadius: Float,
    borderWidth: Int,
    borderColor: String?
) {
    view.background = GradientDrawable().apply {
        (view.background as? ColorDrawable)?.color?.apply {
            setColor(this)//颜色取背景颜色（backgroundColor）
        }
        cornerRadii = floatArrayOf(
            topLeftRadius,
            topLeftRadius,
            topRightRadius,
            topRightRadius,
            bottomRightRadius,
            bottomRightRadius,
            bottomLeftRadius,
            bottomLeftRadius
        )
        setStroke(borderWidth.dp, Color.parseColor(borderColor ?: "#FFFFFF"))

    }

}

package com.dawn.lib_base.base;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;


import com.dawn.lib_base.dialog.BaseDialog;
import com.dawn.lib_base.dialog.LoadingDialog;
import com.dawn.lib_base.http.ApiException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<VDB extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {
    private  VM VM;
    private  VDB VDB;
    private BaseDialog loadingDialog;
    protected ImageView backTitleImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setStatusBarColor();
        super.onCreate(savedInstanceState);
        handlerVDB();
        handlerVM();
        if(getBackImageId()>0){
            backTitleImg=findViewById(getBackImageId());
            if(backTitleImg!=null){
                backTitleImg.setOnClickListener(v -> finish());
            }
        }

        receiveLiveData();
        initData(savedInstanceState);
    }


    /**
     * 第一次进入页面子类可以重写
     * 这个方法修改状态栏
     */
    protected void setStatusBarColor() {
//        StatusBarUtil.setStatusBarColor(this, Color.parseColor("#FFFFFF"));
    }


    private void handlerVDB() {
        VDB = DataBindingUtil.setContentView(this, getLayoutId());
        if(VDB==null){
            return;
        }
        VDB.setLifecycleOwner(this);//可以使用liveData对XMl数据更新

    }

    private void handlerVM() {
        Class<BaseViewModel> viewModelClass;
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            viewModelClass = (Class<BaseViewModel>) ((ParameterizedType) type).getActualTypeArguments()[1];//获取第1个注解即VM的注解类型
        } else {
            //使用父类的类型
            viewModelClass = BaseViewModel.class;
        }
        VM = (VM) new ViewModelProvider(this).get(viewModelClass);
        if (getVariableId() > 0) {
            getLifecycle().addObserver(VM);
            VDB.setVariable(getVariableId(), VM);
        }

    }

    private void receiveLiveData() {
        VM.loadingEvent.observe(this, aBoolean -> {
            if (aBoolean) {
               showLoading();
            } else {
               dismissLoading();
            }
        });
        VM.startActivity.observe(this, this::onStartActivity);
        VM.finishActivity.observe(this, o -> onBackPressed());
        VM.apiExceptionEvent.observe(this,this::onHandlerApiExceptionEvent);
    }


    public  @NonNull VM getVM() {
        return VM;
    }

    public @NonNull VDB getVDB() {
        return VDB;
    }

    public abstract int getLayoutId();

    public  int getBackImageId(){
        return -1;
    };


    public abstract void initData(Bundle savedInstanceState);

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    public abstract int getVariableId();

    public void onStartActivity(Object params) {
    }
    public void onHandlerApiExceptionEvent(ApiException params) {
    }


    public void showLoading(){
        if(loadingDialog==null){
            loadingDialog = getLoadingDialog();
        }
        if (!loadingDialog.isShowing()){
            loadingDialog.show();
        }
    }

    public BaseDialog getLoadingDialog (){
        return new LoadingDialog(this);
    }


    public void dismissLoading(){
        if (loadingDialog != null){
            loadingDialog.dismiss();
        }
    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (VDB != null) {
            VDB.unbind();
        }
       VDB=null;
    }
}

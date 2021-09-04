package com.dawn.lib_base.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsetsController;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.dawn.lib_base.R;


/**
 * Created by Administrator on 2018/4/3 0003.
 */

public abstract class BaseDialog<VDB extends ViewDataBinding> extends AlertDialog {
    protected Context activity;
    private VDB viewDataBinding;


    public BaseDialog(@NonNull Context context) {
        super(context, R.style.half_trans_Dialog);
        this.activity = context;
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.activity = context;
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.activity = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        ViewGroup contentView = decorView.findViewById(android.R.id.content);
        viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), getLayoutId(), contentView, true);
        initData();
        if (isFullScreen()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                getWindow().getInsetsController().hide(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                                //布局位于状态栏下方
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                //全屏
                                View.SYSTEM_UI_FLAG_FULLSCREEN |
                                //隐藏导航栏
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                        uiOptions |= 0x00001000;
                        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
                    }
                });
            }
        }


    }

    private void fullScreenImmersive(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            view.setSystemUiVisibility(uiOptions);
        }
    }

    public abstract int getLayoutId();

    public abstract void initData();

    public AppCompatActivity getActivity() {
        return (AppCompatActivity) activity;
    }

    public VDB getViewDataBinding() {
        return viewDataBinding;
    }

    @Override
    public void show() {
        if (isFullScreen()) {
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        }
        try {
            if (activity instanceof Activity) {
                Activity activity = (Activity) this.activity;
                if (activity.isDestroyed() || activity.isFinishing() || isShowing()) {
                    return;
                }
                super.show();
            }
        } catch (Exception e) {

        }
        if (isFullScreen()) {
            fullScreenImmersive(getWindow().getDecorView());
            this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        }
    }

    @Override
    public void dismiss() {
        try {
            if (activity instanceof Activity) {
                Activity activity = (Activity) this.activity;
                if (activity.isFinishing() || !isShowing()) {
                    return;
                }
                super.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    /**
     * dialog 是否要全屏
     * 全屏取决于所在的Activity是否是全屏的
     *
     * @return
     */
    public boolean isFullScreen() {
        return true;
    }

    public <T extends ViewModel> T getVm(@NonNull Class<T> modelClass) {
        return new ViewModelProvider(getActivity()).get(modelClass);
    }
}

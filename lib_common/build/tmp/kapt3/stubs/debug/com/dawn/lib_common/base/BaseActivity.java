package com.dawn.lib_common.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0018H&J\r\u0010\u001a\u001a\u00028\u0001H\u0002\u00a2\u0006\u0002\u0010\u0011J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0016J\u0006\u0010\"\u001a\u00020\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00028\u0001X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006#"}, d2 = {"Lcom/dawn/lib_common/base/BaseActivity;", "VDB", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/dawn/lib_common/base/BaseViewModel;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "loadingDialog", "Landroid/app/ProgressDialog;", "viewDataBinding", "getViewDataBinding", "()Landroidx/databinding/ViewDataBinding;", "setViewDataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "viewModel", "getViewModel", "()Lcom/dawn/lib_common/base/BaseViewModel;", "setViewModel", "(Lcom/dawn/lib_common/base/BaseViewModel;)V", "Lcom/dawn/lib_common/base/BaseViewModel;", "dismissLoading", "", "getLayoutId", "", "getVariableId", "getVm", "initData", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onStartActivity", "param", "", "showLoading", "lib_common_debug"})
public abstract class BaseActivity<VDB extends androidx.databinding.ViewDataBinding, VM extends com.dawn.lib_common.base.BaseViewModel> extends androidx.appcompat.app.AppCompatActivity {
    public VDB viewDataBinding;
    public VM viewModel;
    private android.app.ProgressDialog loadingDialog;
    
    @org.jetbrains.annotations.NotNull()
    public final VDB getViewDataBinding() {
        return null;
    }
    
    public final void setViewDataBinding(@org.jetbrains.annotations.NotNull()
    VDB p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final VM getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    VM p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public abstract int getLayoutId();
    
    public abstract void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState);
    
    public void onStartActivity(@org.jetbrains.annotations.NotNull()
    java.lang.Object param) {
    }
    
    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    public abstract int getVariableId();
    
    private final VM getVm() {
        return null;
    }
    
    public final void showLoading() {
    }
    
    public final void dismissLoading() {
    }
    
    public BaseActivity() {
        super();
    }
}
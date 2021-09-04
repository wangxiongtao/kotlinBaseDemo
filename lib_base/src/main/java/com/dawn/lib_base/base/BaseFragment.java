package com.dawn.lib_base.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.dawn.lib_base.dialog.LoadingDialog;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseFragment<VDB extends ViewDataBinding, VM extends BaseViewModel> extends Fragment {
    private VM VM;
    private VDB VDB;
    private LoadingDialog loadingDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        VDB = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        if (VDB != null) {
            VDB.setLifecycleOwner(this);
            return VDB.getRoot();
        } else {
            return inflater.inflate(getLayoutId(), container, false);
        }


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        handlerVM();
        receiveLiveData();
        initData(savedInstanceState);
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
        VM = (VM) new ViewModelProvider(requireActivity()).get(viewModelClass);//找到Activity对于的VM
        if (VM == null) {
            VM = (VM) new ViewModelProvider(this).get(viewModelClass);//fragment自己的VM 不是Activity
        }
        if (getVariableId() > 0) {
            getLifecycle().addObserver(VM);
            VDB.setVariable(getVariableId(), VM);
        }

    }

    private void receiveLiveData() {
        VM.loadingEvent.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                showLoading();
            } else {
                dismissLoading();
            }
        });
        VM.startActivity.observe(getViewLifecycleOwner(), this::onStartActivity);
    }

    public VM getViewModel() {
        return VM;
    }

    public VDB getViewDataBinding() {
        return VDB;
    }

    public abstract int getLayoutId();


    public abstract void initData(Bundle savedInstanceState);

    public void onStartActivity(Object params) {
    }

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    public abstract int getVariableId();

    public void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(getActivity());
        }
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    public void dismissLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (VDB != null) {
            VDB.unbind();
        }
        VDB=null;

    }
}

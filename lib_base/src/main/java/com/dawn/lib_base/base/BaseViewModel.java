package com.dawn.lib_base.base;


import androidx.lifecycle.MutableLiveData;

import com.dawn.lib_base.http.ApiException;


public class BaseViewModel extends LifeViewModel implements IViewModel {
    public MutableLiveData<Boolean> loadingEvent = new MutableLiveData<>();
    public MutableLiveData<ApiException> apiExceptionEvent = new MutableLiveData<>();
    public MutableLiveData<Object> startActivity = new MutableLiveData<>();
    public MutableLiveData<Object> finishActivity = new MutableLiveData<>();


    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void showLoading() {
        loadingEvent.setValue(true);

    }

    @Override
    public void closeLoading() {
        loadingEvent.setValue(false);
    }

    public void finishActivity() {
        finishActivity.postValue("");

    }

}

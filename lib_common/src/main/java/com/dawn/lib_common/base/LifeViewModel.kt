package com.dawn.lib_common.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.dawn.lib_common.util.log

open class LifeViewModel :ViewModel(), LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
        log("===OnLifecycleEvent==onCreate==>")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {
        log("===OnLifecycleEvent==onStart==>")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {
        log("===OnLifecycleEvent==onResume==>")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause() {
        log("===OnLifecycleEvent==onPause==>")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {
        log("===OnLifecycleEvent==onStop==>")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        log("===OnLifecycleEvent==onDestroy==>")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    open fun onAny() {
        log("===OnLifecycleEvent==onAny==>")
    }
}
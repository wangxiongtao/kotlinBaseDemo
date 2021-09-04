package com.dawn.kotlinbasedemo.api

import androidx.appcompat.app.AppCompatActivity
import com.dawn.lib_base.http.ApiException

/**
 *
 * @param activity 可能为null 一定要判断
 * @param e
 * @return
 */
fun handlerApiException(activity: AppCompatActivity?, e: ApiException): Boolean {
    val code: Int? = e.code
    val message: String? = e.message
    when (code) {
        2001 -> {
            if (activity != null) {

            }

            return true
        }
    }
    return false
}

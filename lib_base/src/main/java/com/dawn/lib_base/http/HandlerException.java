package com.dawn.lib_base.http;


import org.json.JSONException;

import java.io.IOException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;

/**
 * Created by Dawn on 2018/10/27.
 */

public class HandlerException {
    public static final String LOGIN_INVALID_EXCEPTION = "请重新登录";
    public static final String SERVER_EXCEPTION = "服务器开小差啦，请稍后再试";
    public static final String TIME_OUT_EXCEPTION = "网络请求超时，请稍后再试";
    public static final String NETWORK_EXCEPTION = "网络开小差啦，请稍后再试";
    public static final String JSON_EXCEPTION = "数据类型转换错误";

    public static final int LOGIN_INVALID_CODE = 401;//2001
    public static final int NETWORK_CODE = -900010;
    public static final int JSON_CODE = -900011;
    public static final int OTHER_CODE = -9000101;

    public static Throwable handlerException(Throwable e) {
        if (e instanceof HttpException) {
            if (((HttpException) e).code() == LOGIN_INVALID_CODE) {//登录异常
                return new ApiException(2001, LOGIN_INVALID_EXCEPTION);
            } else {
                return new ApiException(((HttpException) e).code(), SERVER_EXCEPTION);
            }
        }
        if (e instanceof IOException) {
            if (e instanceof SocketTimeoutException) {
                return new SocketTimeoutException(TIME_OUT_EXCEPTION);
            }
            return new IOException(NETWORK_EXCEPTION);
        }
        if (e instanceof JSONException) {
            return (new JSONException(JSON_EXCEPTION));
        }
        return e;
    }
}

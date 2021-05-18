package com.dawn.lib_common.http;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/dawn/lib_common/http/BaseResponse;", "T", "", "()V", "data", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "errorCode", "", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "lib_common_release"})
public final class BaseResponse<T extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable()
    private final T data = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer errorCode = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String errorMsg = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Exception exception;
    
    @org.jetbrains.annotations.Nullable()
    public final T getData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getErrorCode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getErrorMsg() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Exception getException() {
        return null;
    }
    
    public final void setException(@org.jetbrains.annotations.Nullable()
    java.lang.Exception p0) {
    }
    
    public BaseResponse() {
        super();
    }
}
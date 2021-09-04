package com.dawn.kotlinbasedemo.api

import com.dawn.lib_base.base.BaseViewModel
import com.dawn.lib_base.http.ApiException
import com.dawn.lib_base.http.HandlerException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.util.concurrent.CancellationException

/**
 * 使用flow+retrofit
 * @param showLoading Boolean 是否 显示loading框
 * @param request [@kotlin.ExtensionFunctionType] SuspendFunction1<ApiInterface, BaseResponse<T>?>
 * @return Flow<BaseResponse<T>>
 */
suspend fun <T> BaseViewModel.flowRequest(
    showLoading: Boolean = true,
    request: suspend ApiInterface.() -> BaseResponse<T>?
): Flow<BaseResponse<T>> {
    val vm = this;
    if (showLoading) {
        showLoading()
    }
    return flow {
        val response = request(Api) ?: throw IllegalArgumentException("数据非法，获取响应数据为空")
        response.throwAPIException();
        emit(response)
    }.flowOn(Dispatchers.IO)
        .onCompletion { cause ->
            run {
                closeLoading()
                cause?.let { throw catchException(vm, it) }// 这里再重新把捕获的异常再次抛出，调用的时候如果有必要可以再次catch 获取异常
            }

        }


}

fun BaseViewModel.onApiError(exception: ApiException) {
    if (handlerApiException(null, exception)) {
        apiExceptionEvent.value = exception
        return
    } else {
//       ToastUtils.showShortToast("${e.localizedMessage},错误码：${e.code}");
    }

}

fun catchException(
    vm: BaseViewModel,
    e: Throwable,
): Throwable {
    e.printStackTrace()

    if (e is CancellationException) {
        return e;
    }
    val exception = HandlerException.handlerException(e)
    exception?.let {
        if (it is ApiException) {
            vm.onApiError(it);
        } else {
//           ToastUtils.showShortToast("${e.localizedMessage},错误码：${e.code}");
        }
    }
    return exception;
}
fun <T> Flow<T>.catchError(bloc: Throwable.() -> Unit) = catch { cause -> bloc(cause) }

suspend fun <T> Flow<T>.next(bloc: suspend T.() -> Unit): Unit = catch { }.collect { bloc(it) }

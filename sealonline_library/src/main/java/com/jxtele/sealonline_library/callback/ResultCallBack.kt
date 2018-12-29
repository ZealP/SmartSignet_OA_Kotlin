package com.jxtele.sealonline_library.callback

import com.jxtele.sealonline_library.net.http.exception.ApiException

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/27
 * Email: zealpeng@163.com
 * Description:
 */
abstract class ResultCallBack : RequestCallBack {

    override fun onStart() {
    }

    override fun onHttpErr(e: ApiException) {
        onHttpReqErr(e)
    }

    override fun onFail(code: String?, msg: String?, data: String?) {
        onResultFail(code, msg, data)
    }

    override fun onSuccess(data: String?, msg: String?) {
        onResultSuccess(data, msg)
    }

    abstract fun onResultSuccess(data: String?, msg: String?)
    abstract fun onResultFail(code: String?, msg: String?, data: String?)
    abstract fun onHttpReqErr(e: ApiException?)
}
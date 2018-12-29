package com.jxtele.sealonline_library.callback

import com.jxtele.sealonline_library.net.http.exception.ApiException

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/27
 * Email: zealpeng@163.com
 * Description:
 */
interface RequestCallBack {

    fun onStart()

    fun onSuccess(data: String?, msg: String?)

    fun onFail(code: String?, msg: String?, data: String?)

    fun onHttpErr(e: ApiException)
}
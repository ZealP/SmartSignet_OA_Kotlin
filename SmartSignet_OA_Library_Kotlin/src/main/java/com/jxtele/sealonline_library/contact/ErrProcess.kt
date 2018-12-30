package com.jxtele.sealonline_library.contact

import android.content.Context
import com.jxtele.sealonline_library.utils.ToastUtil

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/27
 * Email: zealpeng@163.com
 * Description:
 */
object ErrProcess {
    /**
     * 请求成功
     */
    private val REQ_SUC = "0"

    /**
     * 结果反馈
     */
    fun parseRequestResult(context: Context?, code: String?, msg: String?): Boolean {
        return when (code) {
            REQ_SUC -> true
            else -> {
                ToastUtil.showShort(context, msg ?: "出现未知错误")
                false
            }
        }
    }
}
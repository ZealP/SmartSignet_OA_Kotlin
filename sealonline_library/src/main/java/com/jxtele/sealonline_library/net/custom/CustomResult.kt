package com.jxtele.sealonline_library.net.custom

import com.jxtele.sealonline_library.net.http.model.ApiResult

/**
 * Author: Dev_@ZealP
 * Created On: 2018/5/8
 *
 * Description:
 *
 * Email: zealpeng@163.com
 */

class CustomResult<T> : ApiResult<T>() {

    override fun isOk(): Boolean {
        return code == 200
    }

}
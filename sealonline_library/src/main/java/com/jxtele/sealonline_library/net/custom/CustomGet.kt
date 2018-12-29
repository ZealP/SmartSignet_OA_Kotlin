package com.jxtele.sealonline_library.net.custom

import com.jxtele.sealonline_library.net.http.callback.CallBack
import com.jxtele.sealonline_library.net.http.callback.CallBackProxy
import com.jxtele.sealonline_library.net.http.callback.CallClazzProxy
import com.jxtele.sealonline_library.net.http.request.GetRequest
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.lang.reflect.Type

/**
 * Author: Dev_@ZealP
 * Created On: 2018/5/8
 *
 * Description:
 *
 * Email: zealpeng@163.com
 */

/**
 * Created by zealPeng on 2017/9/26.
 */

class CustomGet(url: String) : GetRequest(url) {

    override fun <T> execute(type: Type): Observable<T> {
        return super.execute(object : CallClazzProxy<CustomResult<T>, T>(type) {

        })
    }

    override fun <T> execute(clazz: Class<T>): Observable<T> {
        return super.execute(object : CallClazzProxy<CustomResult<T>, T>(clazz) {

        })
    }

    override fun <T> execute(callBack: CallBack<T>): Disposable {
        return super.execute(object : CallBackProxy<CustomResult<T>, T>(callBack) {

        })
    }
}

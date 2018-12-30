package com.jxtele.sealonline_library.net.base

import com.jxtele.sealonline_library.net.custom.CustomGet
import com.jxtele.sealonline_library.net.custom.CustomPost
import com.jxtele.sealonline_library.net.http.request.GetRequest
import com.jxtele.sealonline_library.net.http.request.PostRequest

/**
 * Author: Dev_@ZealP
 * Created On: 2018/5/9
 *
 * Description:
 *
 * Email: zealpeng@163.com
 */
class NetRequest {

    companion object {

        /**
         * GET请求体
         *
         * @param url
         * @param signFlag
         * @return
         */
        fun doGetReq(url: String, signFlag: Boolean?): GetRequest {

            val mReq = CustomGet(url).connectTimeout(15 * 1000)

            if (signFlag!!)
                mReq.accessToken(true).sign(true).timeStamp(true)
            else
                mReq.accessToken(false).sign(false).timeStamp(false)

            return mReq
        }

        /**
         * POST请求体
         *
         * @param url
         * @param signFlag
         * @return
         */
        fun doPostReq(url: String, signFlag: Boolean?): PostRequest {

            val mReq = CustomPost(url).connectTimeout(15 * 1000)

            if (signFlag!!)
                mReq.accessToken(true).sign(true).timeStamp(true)
            else
                mReq.accessToken(false).sign(false).timeStamp(false)

            return mReq
        }
    }

}
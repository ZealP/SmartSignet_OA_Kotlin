package com.jxtele.sealonline_library.net.interceptor

import com.jxtele.sealonline_library.net.http.interceptor.BaseDynamicInterceptor
import com.jxtele.sealonline_library.utils.CommonUtil
import com.jxtele.sealonline_library.utils.MD5
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.*
import kotlin.collections.HashMap

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/27
 * Email: zealpeng@163.com
 * Description:
 */
class SignInterceptor : BaseDynamicInterceptor<SignInterceptor> {

    companion object {
        var mOpenId: String? = null
        var mSecret: String? = null
    }

    constructor(openId: String?, secret: String?){
        mOpenId = openId
        mSecret = secret
    }

    /**
     * 全部请求签名字段使用GET\POST形式传递
     *
     * @param chain
     * @return
     * @throws IOException
     */
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (isSign) {
            if (request.method() == "GET")
                request = addParam(request)
        }
        return chain.proceed(request)
    }

    /**
     * GET拦截器
     *
     * @param oldRequest
     * @return
     */
    private fun addParam(oldRequest: Request): Request {
        val build = oldRequest.url().newBuilder()
        val timeStamp = CommonUtil.formatTimeStamp(System.currentTimeMillis())

        val map = LinkedHashMap<String, String>()
        map["timestamp"] = timeStamp

        for (s in map.keys) {
            build.setEncodedQueryParameter(s, map[s])
        }

        val newRequest = oldRequest.newBuilder()
            .url(build.build())
            .build()

        val rootMap = HashMap<String, List<String>>()

        for (s in newRequest.url().queryParameterNames()) {
            if (!s.isEmpty())
                rootMap[s] = newRequest.url().queryParameterValues(s)
        }

        val digest = encodeReqSecretString(rootMap, "")

        var url = newRequest.url().toString()
        url += "&sign=$digest"

        return newRequest.newBuilder().url(url).build()
    }

    /**
     * 签名加密字段
     */
    private fun encodeReqSecretString(map: HashMap<String, List<String>>, secretStr: String): String {
        val mMapResult = StringBuffer()
        val key_arr = map.keys.toTypedArray()
        Arrays.sort(key_arr)
        for (key in key_arr) {
            mMapResult.append("$key=${map[key]?.get(0)}")
        }
        mMapResult.append(mSecret)
        return MD5.encodeMD5(mMapResult.toString()).toUpperCase()
    }

    override fun dynamic(dynamicMap: TreeMap<String, String>?): TreeMap<String, String> {
        return TreeMap()
    }

}
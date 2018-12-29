package com.jxtele.sealonline_library.callback

import android.content.Context
import com.alibaba.fastjson.JSON
import com.jxtele.sealonline_library.contact.ErrProcess
import com.jxtele.sealonline_library.entity.BaseMsg
import com.jxtele.sealonline_library.net.http.callback.CallBack
import com.jxtele.sealonline_library.net.http.exception.ApiException
import com.jxtele.sealonline_library.utils.ToastUtil

/**
 * Author: Dev_@ZealP
 * Created On: 2018/11/13
 * Email: zealpeng@163.com
 * Description:
 */
abstract class SkCallBack<T> : CallBack<T> {

    private var mContext: Context? = null
    private var resultCallback: ResultCallBack? = null

    constructor(context: Context?, callback: ResultCallBack?) {
        context?.let{
            mContext = context
            resultCallback = callback
        }
    }

    override fun onSuccess(t: T) {

        try {

            val mMsg: BaseMsg<*>?

            if (t is String)
                mMsg = JSON.parseObject(t as String, BaseMsg::class.java)
            else
                return

            if (mMsg != null) {

                if (mMsg.code != "0" || mMsg.msg != null)
                    resultMsg(mMsg, !ErrProcess.parseRequestResult(mContext, mMsg.code, mMsg.msg))
                else
                    resultMsg(mMsg, true)

            } else {
                ToastUtil.showShort(mContext, "数据解析失败，请稍后再试或联系管理员")
            }

        }catch (e : Exception){
            ToastUtil.showShort(mContext, "处理出错")
        }
    }

    override fun onError(e: ApiException?) {
        ErrProcess.parseRequestResult(mContext, e?.code?.toString(), e?.message)
        resultCallback?.onHttpReqErr(e)
    }

    private fun resultMsg(msg: BaseMsg<*>?, isResultErr: Boolean?) {
        if (isResultErr == false)
            resultCallback?.onResultSuccess(msg?.data, msg?.msg)
        else
            resultCallback?.onResultFail(msg?.code, msg?.msg, msg?.data)
    }


    override fun onCompleted() {}

    override fun onStart() {}

//    abstract fun resultMsg(msg: BaseMsg<*>?, isResultErr: Boolean?)
}
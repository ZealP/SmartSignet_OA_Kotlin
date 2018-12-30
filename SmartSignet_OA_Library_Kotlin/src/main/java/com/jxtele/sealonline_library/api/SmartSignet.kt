package com.jxtele.sealonline_library.api

import android.app.Application
import com.jxtele.sealonline_library.callback.ResultCallBack
import com.jxtele.sealonline_library.callback.SkCallBack
import com.jxtele.sealonline_library.contact.ApiContact
import com.jxtele.sealonline_library.entity.BaseMsg
import com.jxtele.sealonline_library.net.base.NetRequest
import com.jxtele.sealonline_library.net.http.callback.SimpleCallBack
import com.jxtele.sealonline_library.net.http.exception.ApiException

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/28
 * Email: zealpeng@163.com
 * Description:
 */
class SmartSignet {

    private constructor()

    companion object {
        val mSmartSignet: SmartSignet by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SmartSignet()
        }
    }

    /**
     * 申请签章
     *
     */
    fun applySignet(
        application: Application,
        openId: String?,
        version: String?,
        useCount: Int?,
        surplusTimes: Int?,
        serialNo: String?,
        applyReason: String?,
        resultCallback: ResultCallBack?
    ) {
        NetRequest
            .doGetReq(ApiContact.BASE_API, true)
            .params("method", ApiContact.METHOD.METHOD_SEAL_APPLY)
            .params("v", version ?: "")
            .params("openid", openId ?: "")
            .params("useCount", useCount?.toString())
            .params("surplusTimes", surplusTimes?.toString())
            .params("serialNo", serialNo ?: "")
            .params("applyReason", applyReason ?: "")
            .execute(object : SkCallBack<String>(application, resultCallback) {
            })
    }

    /**
     * 变更流程审批之拒绝
     */
    fun refusedApprovalWorkflow(
        application: Application,
        openId: String?,
        version: String?,
        applyId: String?,
        serialNo: String?,
        resultCallback: ResultCallBack?
    ) {
        NetRequest
            .doGetReq(ApiContact.BASE_API, true)
            .params("method", ApiContact.METHOD.METHOD_APPROVAL_WORKFLOW_REFUSED)
            .params("v", version ?: "")
            .params("openid", openId ?: "")
            .params("applyId", applyId ?: "")
            .params("serialNo", serialNo ?: "")
            .execute(object : SkCallBack<String>(application, resultCallback) {
            })
    }

    /**
     * 变更流程审批之同意
     */
    fun agreeApprovalWorkflow(
        application: Application,
        openId: String?,
        version: String?,
        applyId: String?,
        serialNo: String?,
        resultCallback: ResultCallBack?
    ) {
        NetRequest
            .doGetReq(ApiContact.BASE_API, true)
            .params("method", ApiContact.METHOD.METHOD_APPROVAL_WORKFLOW_AGREE)
            .params("v", version ?: "")
            .params("openid", openId ?: "")
            .params("applyId", applyId ?: "")
            .params("serialNo", serialNo ?: "")
            .execute(object : SkCallBack<String>(application, resultCallback) {
            })
    }

    /**
     * 印章二维码扫描接口
     */
    fun signetQrCodeScan(
        application: Application,
        openId: String?,
        version: String?,
        serialNum: String?,
        applyId: String?,
        clientid: String?,
        resultCallback: ResultCallBack?
    ) {
        NetRequest
            .doGetReq(ApiContact.BASE_API, true)
            .params("method", ApiContact.METHOD.METHOD_QRCODE_SCAN)
            .params("v", version ?: "")
            .params("openid", openId ?: "")
            .params("applyId", applyId ?: "")
            .params("serialNum", serialNum ?: "")
            .params("clientid", clientid ?: "")
            .execute(object : SkCallBack<String>(application, resultCallback) {
            })
    }

    /**
     * 印章信息列表
     *
     */
    fun getSignetList(
        application: Application,
        openId: String?,
        version: String?,
        resultCallback: ResultCallBack?
    ) {
        NetRequest
            .doGetReq(ApiContact.BASE_API, true)
            .params("method", ApiContact.METHOD.METHOD_SIGNET_LIST)
            .params("v", version ?: "")
            .params("openid", openId ?: "")
            .execute(object : SkCallBack<String>(application, resultCallback) {
            })
    }
}
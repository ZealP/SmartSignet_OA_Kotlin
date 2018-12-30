package com.jxtele.sealonline_library.api

import android.app.Application
import com.jxtele.sealonline_library.callback.ResultCallBack
import com.jxtele.sealonline_library.net.http.EasyHttp
import com.jxtele.sealonline_library.net.http.cache.model.CacheMode
import com.jxtele.sealonline_library.net.interceptor.SignInterceptor
import okhttp3.ConnectionPool
import java.util.concurrent.TimeUnit

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/27
 * Email: zealpeng@163.com
 * Description:
 */
object SignetOnline {

    private var mApp: Application? = null
    private var mOpenId: String? = null
    private var mSecretKey: String? = null
    private var mBaseServiceAddr: String? = null

    /**
     * 初始化组件
     * @param application Application对象
     * @param openId  平台唯一标识
     * @param secretKey 平台匹配密钥
     * @param serviceUrl 服务器地址
     */
    fun initSealOnline(application: Application, openId: String, secretKey: String, serviceUrl:String) {
        mApp = application
        if (!openId.isNullOrEmpty() || !secretKey.isNullOrEmpty() || !serviceUrl.isNullOrEmpty()) {
            mOpenId = openId
            mSecretKey = secretKey
            mBaseServiceAddr = serviceUrl
            initHttpReq(openId, secretKey)
        }
    }

    /**
     * 获取印章列表
     * @param version 请求版本号
     * @param ResultCallback 返回结果回调
     */
    fun getSignList(version: String?, resultCallback: ResultCallBack?) {
        mApp?.let {
            SmartSignet.mSmartSignet.getSignetList(mApp!!, mOpenId, version, resultCallback)
        }
    }

    /**
     * 申请签章
     * @param version 请求版本号
     * @param useCount 印章使用次数
     * @param surplusTimes 印章使用时间/秒
     * @param serialNo 印章设备序列号
     * @param applyReason 合同名称
     * @param ResultCallback 返回结果回调
     */
    fun applySignet(
        version: String?,
        useCount: Int?,
        surplusTimes: Int?,
        serialNo: String?,
        applyReason: String?,
        resultCallback: ResultCallBack?
    ) {
        mApp?.let {
            SmartSignet.mSmartSignet.applySignet(
                mApp!!,
                mOpenId,
                version,
                useCount,
                surplusTimes,
                serialNo,
                applyReason,
                resultCallback
            )
        }
    }

    /**
     * 变更流程审批之拒绝
     * @param version 请求版本号
     * @param applyId 申请流程编号
     * @param serialNo 印章设备序列号
     * @param ResultCallback 返回结果回调
     */
    fun refusedApprovalWorkflow(version: String?, applyId: String?, serialNo: String?, resultCallback: ResultCallBack?) {
        mApp?.let {
            SmartSignet.mSmartSignet.refusedApprovalWorkflow(mApp!!, mOpenId, version, applyId, serialNo, resultCallback)
        }
    }

    /**
     * 变更流程审批之同意
     * @param version 请求版本号
     * @param applyId 申请流程编号
     * @param serialNo 印章设备序列号
     * @param ResultCallback 返回结果回调
     */
    fun agreeApprovalWorkflow(version: String?, applyId: String?, serialNo: String?, resultCallback: ResultCallBack?) {
        mApp?.let {
            SmartSignet.mSmartSignet.agreeApprovalWorkflow(mApp!!, mOpenId, version, applyId, serialNo, resultCallback)
        }
    }

    /**
     * 印章二维码扫描
     * @param version 请求版本号
     * @param serialNum 印章序列号
     * @param applyId 申请流程编号
     * @param clientid 印章设备编码
     * @param ResultCallback 返回结果回调
     */
    fun signetQrCodeScan(version: String?, serialNum: String?, applyId: String?, clientid: String?, resultCallback: ResultCallBack?){
        mApp?.let {
            SmartSignet.mSmartSignet.signetQrCodeScan(mApp!!, mOpenId, version, serialNum, applyId, clientid, resultCallback)
        }
    }

    /**
     * 初始化网络请求框架
     * @param openId 平台唯一标识
     * @param secretKey 平台匹配密钥
     */
    private fun initHttpReq(openId: String, secretKey: String) {
        EasyHttp.init(mApp)
        EasyHttp.getInstance()
            .setBaseUrl(mBaseServiceAddr)
            .debug("SEAL_ONLINE", true)
            .setReadTimeOut(20 * 1000)
            .setWriteTimeOut(40 * 1000)
            .setConnectTimeout(40 * 1000)
            .setRetryCount(2)
            .setRetryDelay(3000)
            .setRetryIncreaseDelay(2000)
            .setCacheMode(CacheMode.NO_CACHE)
            .setCacheTime(-1)
            .setCacheMaxSize(200 * 1024 * 1024)
            .setCacheVersion(1)
            .setOkconnectionPool(ConnectionPool(10, 10, TimeUnit.MINUTES))
            .addInterceptor(SignInterceptor(openId, secretKey))
    }
}
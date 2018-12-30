package com.jxtele.sealonline.act

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jxtele.sealonline.R
import com.jxtele.sealonline.app.MyApplication
import com.jxtele.sealonline_library.api.SignetOnline
import com.jxtele.sealonline_library.callback.ResultCallBack
import com.jxtele.sealonline_library.net.http.exception.ApiException
import com.jxtele.sealonline_library.utils.ToastUtil
import kotlinx.android.synthetic.main.act_main.*

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/27
 * Email: zealpeng@163.com
 * Description:
 */
class MainAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_main)

        testGetSignetList()
//        testApplySignet()
//        testRefusedApprovalWorkflow()
//        testAgreeApprovalWorkflow()
//        testSignetQrCodeScan()
    }

    /**
     * 获取印章列表
     */
    private fun testGetSignetList() {
        /**
         * 获取印章列表
         * @param version 请求版本号
         * @param ResultCallback 返回结果回调
         */
        SignetOnline?.getSignList("1.0.8", object : ResultCallBack() {
            /**
             * 返回请求成功
             * @param data 返回印章列表信息
             * @param msg 返回msg字段信息
             */
            override fun onResultSuccess(data: String?, msg: String?) {
                ToastUtil.showShort(MyApplication.application, msg ?: "")
                main_result_msg?.text = "[getSignList()]返回请求成功\nmsg = $msg\ndata = $data\n"
            }

            /**
             * 返回请求失败
             * @param code 返回错误状态code码
             * @param data 返回data字段信息
             * @param msg 返回msg字段信息
             */
            override fun onResultFail(code: String?, msg: String?, data: String?) {
                ToastUtil.showShort(MyApplication.application, msg ?: "")
                main_result_msg?.text = "[getSignList()]返回请求失败\ncode = $code\nmsg = $msg\ndata = $data\n"
            }

            /**
             * Http请求出错
             * @param e 返回相关请求失败信息
             */
            override fun onHttpReqErr(e: ApiException?) {
                ToastUtil.showShort(MyApplication.application, e?.message ?: "")
                main_result_msg?.text =
                        "[getSignList()]返回请求失败\ncode = ${e?.code}\nerrorMsg = $e?.message\nexception = \n${e?.printStackTrace()}\n"
            }
        })
    }

    /**
     * 申请签章
     */
    private fun testApplySignet() {
        /**
         * 申请签章
         * @param version 请求版本号
         * @param useCount 印章使用次数
         * @param surplusTimes 印章使用时间/秒
         * @param serialNo 印章设备序列号
         * @param applyReason 合同名称
         * @param ResultCallback 返回结果回调
         */
        SignetOnline?.applySignet("1.0.8", 1, 5 * 60, "9ffq99f89q99vq99f", "企业员工劳务合同", object : ResultCallBack() {
            /**
             * 返回请求成功
             * @param data 返回申请流程编号
             * @param msg 返回msg字段信息
             */
            override fun onResultSuccess(data: String?, msg: String?) {
                ToastUtil.showShort(MyApplication.application, msg ?: "")
                main_result_msg?.text = "[applySignet()]返回请求成功\nmsg = $msg\ndata = $data\n"
            }

            /**
             * 返回请求失败
             * @param code 返回错误状态code码
             * @param data 返回data字段信息
             * @param msg 返回msg字段信息
             */
            override fun onResultFail(code: String?, msg: String?, data: String?) {
                ToastUtil.showShort(MyApplication.application, msg ?: "")
                main_result_msg?.text = "[applySignet()]返回请求失败\ncode = $code\nmsg = $msg\ndata = $data\n"
            }

            /**
             * Http请求出错
             * @param e 返回相关请求失败信息
             */
            override fun onHttpReqErr(e: ApiException?) {
                ToastUtil.showShort(MyApplication.application, e?.message ?: "")
                main_result_msg?.text =
                        "[applySignet()]返回请求失败\ncode = ${e?.code}\nerrorMsg = $e?.message\nexception = \n${e?.printStackTrace()}\n"
            }
        })
    }

    /**
     * 变更流程审批之同意
     */
    private fun testAgreeApprovalWorkflow() {
        /**
         * 变更流程审批之同意
         * @param version 请求版本号
         * @param applyId 申请流程编号
         * @param serialNo 印章设备序列号
         * @param ResultCallback 返回结果回调
         */
        SignetOnline?.agreeApprovalWorkflow("1.0.8", "9ffq99f89q99vq99f", "9ffq99f89q99vq99f", object : ResultCallBack() {
            /**
             * 返回请求成功
             * @param data 返回null
             * @param msg 返回msg字段信息
             */
            override fun onResultSuccess(data: String?, msg: String?) {
                ToastUtil.showShort(MyApplication.application, msg ?: "")
                main_result_msg?.text = "[agreeApprovalWorkflow()]返回请求成功\nmsg = $msg\ndata = $data\n"
            }

            /**
             * 返回请求失败
             * @param code 返回错误状态code码
             * @param data 返回data字段信息
             * @param msg 返回msg字段信息
             */
            override fun onResultFail(code: String?, msg: String?, data: String?) {
                ToastUtil.showShort(MyApplication.application, msg ?: "")
                main_result_msg?.text = "[agreeApprovalWorkflow()]返回请求失败\ncode = $code\nmsg = $msg\ndata = $data\n"
            }

            /**
             * Http请求出错
             * @param e 返回相关请求失败信息
             */
            override fun onHttpReqErr(e: ApiException?) {
                ToastUtil.showShort(MyApplication.application, e?.message ?: "")
                main_result_msg?.text =
                        "[agreeApprovalWorkflow()]返回请求失败\ncode = ${e?.code}\nerrorMsg = $e?.message\nexception = \n${e?.printStackTrace()}\n"
            }
        })
    }

    /**
     * 变更流程审批之拒绝
     */
    private fun testRefusedApprovalWorkflow() {
        /**
         * 变更流程审批之拒绝
         * @param version 请求版本号
         * @param applyId 申请流程编号
         * @param serialNo 印章设备序列号
         * @param ResultCallback 返回结果回调
         */
        SignetOnline?.refusedApprovalWorkflow(
            "1.0.8",
            "9ffq99f89q99vq99f",
            "9ffq99f89q99vq99f",
            object : ResultCallBack() {
                /**
                 * 返回请求成功
                 * @param data 返回null
                 * @param msg 返回msg字段信息
                 */
                override fun onResultSuccess(data: String?, msg: String?) {
                    ToastUtil.showShort(MyApplication.application, msg ?: "")
                    main_result_msg?.text = "[refusedApprovalWorkflow()]返回请求成功\nmsg = $msg\ndata = $data\n"
                }

                /**
                 * 返回请求失败
                 * @param code 返回错误状态code码
                 * @param data 返回data字段信息
                 * @param msg 返回msg字段信息
                 */
                override fun onResultFail(code: String?, msg: String?, data: String?) {
                    ToastUtil.showShort(MyApplication.application, msg ?: "")
                    main_result_msg?.text = "[refusedApprovalWorkflow()]返回请求失败\ncode = $code\nmsg = $msg\ndata = $data\n"
                }

                /**
                 * Http请求出错
                 * @param e 返回相关请求失败信息
                 */
                override fun onHttpReqErr(e: ApiException?) {
                    ToastUtil.showShort(MyApplication.application, e?.message ?: "")
                    main_result_msg?.text =
                            "[refusedApprovalWorkflow()]返回请求失败\ncode = ${e?.code}\nerrorMsg = $e?.message\nexception = \n${e?.printStackTrace()}\n"
                }
            })
    }

    /**
     * 印章二维码扫描
     */
    private fun testSignetQrCodeScan() {
        /**
         * 印章二维码扫描
         * @param version 请求版本号
         * @param serialNum 印章序列号
         * @param applyId 申请流程编号
         * @param clientid 印章设备编码
         * @param ResultCallback 返回结果回调
         */
        SignetOnline?.signetQrCodeScan(
            "1.0.8",
            "9ffq99f89q99vq99f",
            "9ffq99f89q99vq99f",
            "9ffq99f89q99vq99f",
            object : ResultCallBack() {
                /**
                 * 返回请求成功
                 * @param data 返回印章序列号
                 * @param msg 返回msg字段信息
                 */
                override fun onResultSuccess(data: String?, msg: String?) {
                    ToastUtil.showShort(MyApplication.application, msg ?: "")
                    main_result_msg?.text = "[signetQrCodeScan()]返回请求成功\nmsg = $msg\ndata = $data\n"
                }

                /**
                 * 返回请求失败
                 * @param code 返回错误状态code码
                 * @param data 返回data字段信息
                 * @param msg 返回msg字段信息
                 */
                override fun onResultFail(code: String?, msg: String?, data: String?) {
                    ToastUtil.showShort(MyApplication.application, msg ?: "")
                    main_result_msg?.text = "[signetQrCodeScan()]返回请求失败\ncode = $code\nmsg = $msg\ndata = $data\n"
                }

                /**
                 * Http请求出错
                 * @param e 返回相关请求失败信息
                 */
                override fun onHttpReqErr(e: ApiException?) {
                    ToastUtil.showShort(MyApplication.application, e?.message ?: "")
                    main_result_msg?.text =
                            "[signetQrCodeScan()]返回请求失败\ncode = ${e?.code}\nerrorMsg = $e?.message\nexception = \n${e?.printStackTrace()}\n"
                }
            })
    }
}
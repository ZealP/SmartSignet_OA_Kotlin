package com.jxtele.sealonline_library.contact

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/27
 * Email: zealpeng@163.com
 * Description:
 */
object ApiContact {

    /**
     * api通过该接口请求信息
     */
    const val BASE_API = "/eh-web-api/gateway"

    object METHOD{

        /**
         * 申请签章流程
         */
        const val METHOD_SEAL_APPLY = "com.shuige.flow.ymApply"

        /**
         * 签章列表
         */
        const val METHOD_SIGNET_LIST = "com.shuige.signet.ymSignetList"

        /**
         * 审批印章同意
         */
        const val METHOD_APPROVAL_WORKFLOW_AGREE = "com.shuige.flow.ymApprove"

        /**
         * 审批印章拒绝
         */
        const val METHOD_APPROVAL_WORKFLOW_REFUSED = "com.shuige.flow.refusedApply"

        /**
         * 印章二维码扫描接口
         */
        const val METHOD_QRCODE_SCAN = "com.shuige.signet.ymScanning"
    }
}
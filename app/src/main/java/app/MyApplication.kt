package app

import android.app.Application
import com.jxtele.sealonline_library.api.SealOnline

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/28
 * Email: zealpeng@163.com
 * Description:
 */
class MyApplication : Application() {

    companion object {
        lateinit var application: MyApplication
    }

    override fun onCreate() {
        super.onCreate()
        application = this

        /**
         * 初始化组件
         * @param application Application对象
         * @param openId  平台唯一标识
         * @param secretKey 平台匹配密钥
         * @param serviceUrl 服务器地址
         */
        SealOnline.initSealOnline(this, "xxx", "xxx", "http://www.baidu.com")
    }
}
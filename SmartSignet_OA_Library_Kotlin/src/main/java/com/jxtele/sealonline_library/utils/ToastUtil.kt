package com.jxtele.sealonline_library.utils

import android.app.Application
import android.content.Context
import android.widget.Toast

/**
 * Author: Dev_@ZealP
 * Created On: 2018/11/23
 * Email: zealpeng@163.com
 * Description:
 */
object ToastUtil {

    private var toast: Toast? = null

    /**
     * 系统时长:Toast.LENGTH_SHORT
     * @param message
     */
    fun showShort(context: Context?, message: String) {
        context?.let {

            if (toast == null) {
                toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
            } else {
                toast!!.setText(message)
            }
            toast!!.show()

        }
    }

    /**
     * 自定义显示时长
     * @param message
     * @param duration
     */
    fun showDuration(context: Context?, message: String, duration: Int) {

        context?.let {
            if (toast == null) {
                toast = Toast.makeText(context, message, duration)
            } else {
                toast!!.setText(message)
                toast!!.duration = duration
            }
            toast!!.show()
        }

    }

    /**
     * 系统时长：Toast.LENGTH_LONG
     * @param message
     */
    fun showLong(context: Context?, message: String) {

        context?.let {
            if (toast == null) {
                toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
            } else {
                toast!!.setText(message)
            }
            toast!!.show()
        }
    }

}
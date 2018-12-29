package com.jxtele.sealonline_library.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/27
 * Email: zealpeng@163.com
 * Description:
 */
object CommonUtil {

    /**
     * 格式化日期字符串 也可以用 ：commons-lang.rar 下的：DateFormatUtils类 更为简单
     *
     * @param date
     * @param pattern
     * @return String
     */
    private fun formatDate(date: Date, pattern: String): String {
        val format = SimpleDateFormat(pattern)
        return format.format(date)
    }

    /**
     * 解析long型时间数据格式化为yyyy-MM-dd
     *
     * @param time
     * @return
     */
    fun formatTimeStamp(time: Long?): String {
        time?.let {
            return formatDate(Date(time), "yyyyMMddHHmmss")
        }
        return ""
    }
}
package com.jxtele.sealonline_library.utils;

import java.util.*;

/**
 * Author: Dev_@ZealP
 * Created On: 2018/12/27
 * Email: zealpeng@163.com
 * Description:
 */
public class CompareSortUtil {
    /**
     * Map按key进行排序
     *
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) return null;
        Map<String, String> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    /**
     * 比较器类
     */
    private static class MapKeyComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
    }
}

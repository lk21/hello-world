package com.lk.util;

import org.apache.commons.lang.StringUtils;

public class StringUtil {
    
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }
    
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}

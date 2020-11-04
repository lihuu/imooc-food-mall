package com.imooc.utils;

/**
 * Created by lihu on 2020/11/4.
 *
 * @author lihu
 * @date 2020/11/4
 */
public class StringUtils {
    /**
     * 安全转换为String
     *
     * @param object
     * @return
     */
    public static String safeToString(Object object){
        return object!=null?object.toString():"";
    }
}

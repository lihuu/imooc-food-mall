package com.imooc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lihu
 * @date 2015/10/28
 */
public class RegexUtil {
    private static final Pattern PATTERN_CHINESE = Pattern.compile("[\\u4e00-\\u9fa5]");

    public static boolean match(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean isContainsChinese(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        Matcher matcher = PATTERN_CHINESE.matcher(str);
        return matcher.find();
    }

}

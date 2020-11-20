package com.imooc.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by 1449488533qq@gmail.com on 10/24/2018.
 *
 * @author 1449488533qq@gmail.com
 * @date 10/24/2018
 */
public class LocalDateUtils {
    public static Date convertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime convertToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

}

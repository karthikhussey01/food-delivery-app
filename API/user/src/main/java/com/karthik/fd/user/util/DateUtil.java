package com.karthik.fd.user.util;

import java.util.Date;

public class DateUtil {

    private DateUtil() {}

    public static Date addMillis(long time) {
        return new Date(getCurrentTime() + time);
    }

    public static Date getCurrentDate() {
        return new Date(getCurrentTime());
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }
}

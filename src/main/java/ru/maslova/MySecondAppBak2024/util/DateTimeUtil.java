package ru.maslova.MySecondAppBak2024.util;

import java.text.SimpleDateFormat;

public class DateTimeUtil {
    public static SimpleDateFormat getCustomFormat () {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }
}

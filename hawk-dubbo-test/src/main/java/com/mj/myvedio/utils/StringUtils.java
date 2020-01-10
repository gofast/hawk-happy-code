package com.mj.myvedio.utils;

import java.util.UUID;

public class StringUtils {
    private StringUtils() {
    }

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isBlank(final CharSequence cs) {
        return isEmpty(cs);
    }

    public static boolean isNotBlank(final CharSequence cs) {
        return !isEmpty(cs);
    }

    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    public static String buildUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static boolean contains(String str, String searchStr) {
        if (str != null && searchStr != null) {
            return str.indexOf(searchStr) >= 0;
        } else {
            return false;
        }
    }

    public static boolean contains(String str, char searchChar) {
        if (isEmpty(str)) {
            return false;
        } else {
            return str.indexOf(searchChar) >= 0;
        }
    }

    public static boolean equals(String str1, String str2) {
        if(str1 == null){
            return str2 == null;
        }
        return str2 == null ? str1 == null : str1.equals(str2);
    }
}

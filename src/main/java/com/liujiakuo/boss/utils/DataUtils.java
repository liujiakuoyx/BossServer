package com.liujiakuo.boss.utils;

import java.util.List;

public class DataUtils {
    public static <T> boolean isEmpty(T data) {
        if (data instanceof String) {
            return ((String) data).isEmpty();
        }
        if (data instanceof List) {
            return ((List) data).isEmpty();
        }
        return data != null;
    }
}

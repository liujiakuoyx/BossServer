package com.liujiakuo.boss.utils;

import java.io.Closeable;
import java.io.IOException;
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

    public static void closeStream(Closeable closeable){
        if(closeable!=null){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

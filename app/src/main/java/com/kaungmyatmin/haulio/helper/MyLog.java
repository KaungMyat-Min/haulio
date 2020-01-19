package com.kaungmyatmin.haulio.helper;


public class MyLog {

    //Set ENABLE_LOG to true to show logs
    public static boolean ENABLE_ALL_LOG = true;


    public static void d(String tag, String message) {
        if (ENABLE_ALL_LOG) {
            android.util.Log.d(tag, message);
        }
    }

    public static void d(String tag, String message, Throwable th) {
        if (ENABLE_ALL_LOG) {
            android.util.Log.d(tag, message, th);
        }
    }


    public static void i(String tag, String message) {
        if (ENABLE_ALL_LOG) {
            android.util.Log.i(tag, message);
        }
    }

    public static void i(String tag, String message, Throwable th) {
        if (ENABLE_ALL_LOG) {
            android.util.Log.i(tag, message, th);
        }
    }

    public static void v(String tag, String message) {
        if (ENABLE_ALL_LOG) {
            android.util.Log.v(tag, message);
        }
    }

    public static void v(String tag, String message, Throwable th) {
        if (ENABLE_ALL_LOG) {
            android.util.Log.v(tag, message, th);
        }
    }

    public static void w(String tag, String message) {
        if (ENABLE_ALL_LOG) {
            android.util.Log.w(tag, message);
        }
    }

    public static void w(String tag, String message, Throwable th) {
        if (ENABLE_ALL_LOG) {
            android.util.Log.w(tag, message, th);
        }
    }

    public static void e(String tag, String message) {
        if (ENABLE_ALL_LOG) {
            android.util.Log.e(tag, message);
        }
    }

    public static void e(String tag, String message, Throwable th) {
        if (ENABLE_ALL_LOG) {
            android.util.Log.e(tag, message, th);
        }
    }
}

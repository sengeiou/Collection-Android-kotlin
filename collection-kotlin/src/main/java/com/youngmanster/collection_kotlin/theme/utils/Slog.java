package com.youngmanster.collection_kotlin.theme.utils;

import android.util.Log;

public class Slog {
    public static boolean DEBUG = false;
    private static final String TAG = "ThemeManager";

    public static void i(String msg) {
        if (DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void i(String subtag, String msg) {
        if (DEBUG) {
            Log.i(TAG, subtag + ": " + msg);
        }
    }

    public static void r(String msg) {
        Log.i(TAG, msg);
    }

    public static void r(String subtag, String msg) {
        Log.i(TAG, subtag + ": " + msg);
    }
}

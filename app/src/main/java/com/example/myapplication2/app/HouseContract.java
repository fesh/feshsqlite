package com.example.myapplication2.app;

import android.provider.BaseColumns;

/**
 * Created by Administrator on 2014/4/9.
 */
public final class HouseContract {
    public HouseContract() {
    }
    public static abstract class User implements BaseColumns
    {
        public static final String TABLE_NAME="user";
        public static final String COLUMN__USER_NAME ="username";
        public static final String COLUMN__USER_IDENTIFY ="identify";
        public static final String COLUMN__USER_FLAG = "flag";

    }
}

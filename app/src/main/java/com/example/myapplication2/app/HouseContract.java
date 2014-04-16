package com.example.myapplication2.app;

import android.provider.BaseColumns;

/**
 * Created by Administrator on 2014/4/9.
 */
public final class HouseContract {
    public HouseContract() {
    }
    public static class User implements BaseColumns
    {
        public static final String TABLE_NAME="user";
        public static final String COLUMN__USER_NAME ="username";
        public static final String COLUMN__USER_IDENTIFY ="identify";
        public static final String COLUMN__USER_FLAG = "flag";
        public String username;
        public String identify;
        public String flag;

        public void setUsername(String username) {
            this.username = username;
        }

        public void setIdentify(String identify) {
            this.identify = identify;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getIdentify() {

            return identify;
        }

        public String getFlag() {
            return flag;
        }

        public String getUsername() {

            return username;
        }
    }
}

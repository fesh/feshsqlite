package com.example.myapplication2.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myapplication2.app.HouseContract.User;

/**
 * Created by Administrator on 2014/4/10.
 */
public class UserReaderHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "User.db";
    public static  final int DATABASE_VERSION = 1;

    public UserReaderHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_QUERY = "CREATE TABLE" +User.COLUMN__USER_NAME+ " ("
            +User._ID + " INTEGER PRIMARY KEY , "
            +User.COLUMN__USER_NAME + TEXT_TYPE + COMMA_SEP
            +User.COLUMN__USER_IDENTIFY + TEXT_TYPE + COMMA_SEP
            +User.COLUMN__USER_FLAG + TEXT_TYPE + COMMA_SEP
            +" )";

    private static final String SQL_DELETE_QUERY = " DROP TABLE IF EXISTS "+ User.TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL(SQL_DELETE_QUERY);
        onCreate(sqLiteDatabase);
    }
}

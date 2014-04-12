package com.example.myapplication2.app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by Administrator on 2014/4/10.
 */
public class UserBusiness {
    private UserReaderHelper userHelper;
    private SQLiteDatabase db;

    public UserBusiness(Context context)
    {
        userHelper = new UserReaderHelper(context);
        db = userHelper.getWritableDatabase();
    }

    public void addUser(String[] user)
    {
        db.beginTransaction();
        try{
            db.execSQL(userHelper.SQL_INSERT_QUERY,user);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    public void delUser(String id)
    {
        db.delete(HouseContract.User.TABLE_NAME, HouseContract.User._ID+" =?",new String[]{id});
    }

    public void getUserList()
    {
        Cursor cursor = getCursor();
    }

    private Cursor getCursor()
    {
        Cursor c = db.rawQuery(UserReaderHelper.SQL_SELECT_QUERY,null);
        return  getCursor();
    }
    public void closeDb()
    {
        db.close();
    }

}

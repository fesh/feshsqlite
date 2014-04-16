package com.example.myapplication2.app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
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

    public List<HouseContract.User> getUserList()
    {
        Cursor cursor = getCursor();
        ArrayList<HouseContract.User> userlist = new ArrayList<HouseContract.User>();
        while (cursor.moveToNext())
        {
            HouseContract.User user = new HouseContract.User() ;
            user.setFlag(cursor.getString(cursor.getColumnIndex("flag")));
            user.setIdentify(cursor.getString(cursor.getColumnIndex("identify")));
            user.setUsername(cursor.getString(cursor.getColumnIndex("username")));
            userlist.add(user);
        }
        cursor.close();
        return userlist;

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

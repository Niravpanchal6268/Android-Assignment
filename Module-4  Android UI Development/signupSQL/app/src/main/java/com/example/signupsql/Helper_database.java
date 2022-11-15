package com.example.signupsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper_database extends SQLiteOpenHelper {

    private static final String dbname = "User_registration";
    private static final int Version = 1;

    public Helper_database(Context context) {
        super(context, dbname, null, Version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table  user_signup(id integer primary key autoincrement, username tex,Email text " + ",password text)";

            db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user_signup");
        onCreate(db);

    }
    public  boolean insert_recored(String  username,String email,String password)
    {
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("UserName",username);
        values.put("Email",email);
        values.put("Password",password);

        long r=db.insert(" user_signup",null,values);
        if (r==-1){
            return  false;
        }
        else {
            return true;
        }
    }

    public boolean checkEmail(String email)
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor  cursor=db.rawQuery("select * from  user_signup where Email=?",new  String[]{email});

            if (cursor.getCount()>0)
            {
                return true;
            }
            else
            {
                return false;
            }

    }
    public  boolean checkEmailPassword(String email,String password)
    {
        SQLiteDatabase db= getWritableDatabase();
        Cursor  cursor=db.rawQuery("select * from  user_signup where Email=? and password=?",new  String[]{email,password});

        if (cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

}

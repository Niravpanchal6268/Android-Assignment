package com.example.multipleuser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Student_DB extends SQLiteOpenHelper {
    private static final String DB_NAME = "database";
    private static final int version = 1;

    public Student_DB(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Student(id integer primary key autoincrement,name text,email text,password text,category text,course text,fee text,joindate text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Student");
        onCreate(sqLiteDatabase);

    }

    public boolean SignStudent(String Email, String Password, String Name,String Category) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", Name);
        values.put("email", Email);
        values.put("password", Password);
        values.put("category",Category);
        long i = db.insert("Student", null, values);
        if (i == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean CheckStudents(String Email, String Password,String Category) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Student where email=? and password=? and category=?", new String[]{Email, Password,Category});
        if (cursor.getCount() > 0) {
            return true;

        } else {
            return false;
        }

    }

    public  boolean CheckEmailStudent(String Email,String Category)
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from Student where email=? and category=?",new String[]{Email,Category});
        if (cursor.getCount()>0)
        {
            return true;
        }
        else {
            return false;
        }
    }

}

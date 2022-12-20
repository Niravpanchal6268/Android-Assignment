package com.example.dailyexpensetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.math.BigInteger;
import java.util.jar.JarEntry;

public class Database_class extends SQLiteOpenHelper {

    private final static String Db_name = "expence";
    private final static int version = 1;

    public Database_class(Context context) {
        super(context, Db_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String c = "create table user(id integer primary key autoincrement,EXPENCE integer,TITLE text,DESCREPTION text,DATE text)";
        db.execSQL(c);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
        onCreate(db);

    }

    public boolean insertdate(BigInteger Expence, String Title, String Descreoption, String date) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("EXPENCE", String.valueOf(Expence));
        values.put("TITLE", Title);
        values.put("DESCREPTION", Descreoption);
        values.put("DATE", date);
        long i = db.insert("user", null, values);
        if (i == -1) {
            return true;
        } else {
            return false;
        }


    }

    public Cursor showdate() {
        SQLiteDatabase db = getWritableDatabase();
        String s = "select * from user";
        Cursor cursor = db.rawQuery(s, null);
        return cursor;

    }

    public String totalamount() {
        SQLiteDatabase db = getWritableDatabase();
        String tamount;
        String t = "Select SUM(EXPENCE) from user";
        Cursor cursor = db.rawQuery(t, null);
        if (cursor.moveToFirst()) {
            tamount = String.valueOf(cursor.getInt(0));
        } else {
            tamount = "0";
        }

        return tamount;

    }


    public void deleteall() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from user");

    }

    public boolean DeleteSingleitem(long Id) {
        SQLiteDatabase db = getWritableDatabase();
            long d1 = db.delete("user", "id=?", new String[]{String.valueOf(Id)});
            if (d1==-1)
            {
                return false;
            }
            else {
                return true;
            }

    }

}

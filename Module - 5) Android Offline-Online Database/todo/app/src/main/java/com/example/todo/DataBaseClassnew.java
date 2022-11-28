package com.example.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class DataBaseClassnew extends SQLiteOpenHelper {
    private static final String DB_name = "taskM";
    private static final int version = 1;


    public DataBaseClassnew(Context context) {
        super(context, DB_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table  task(id integer primary key autoincrement ,TITLE TEXT,DES TEXT,DATE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists task");
        onCreate(sqLiteDatabase);
    }

    public boolean insertdate(String Title, String Des, String Date) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TITLE", Title);
        values.put("DES", Des);
        values.put("DATE", Date);
        long i = db.insert("task", null, values);
        if (i == -1) {
            return true;
        } else {
            return false;
        }
    }

    public Cursor showdata() {
        SQLiteDatabase db = getWritableDatabase();
        String s = "select * from task";
        Cursor cursor = db.rawQuery(s, null);
        return cursor;
    }

    public boolean deletetask(int id) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from task where id=?", new String[]{String.valueOf(id)});
        if (cursor.getCount() > 0) {
            long d = db.delete("task", "TITLE=?", new String[]{String.valueOf(id)});
            if (d == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


}

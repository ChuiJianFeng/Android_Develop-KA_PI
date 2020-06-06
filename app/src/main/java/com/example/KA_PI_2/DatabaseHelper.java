package com.example.KA_PI_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Jian.db";
    public static final String CONTACTS_TABLE_NAME = "CoffeeRecord";


    //使用這個資料庫
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    //產生資料庫時使用
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

//        db.execSQL(
//                "create table if not exists CoffeeRecord " +
//                        "(id integer primary key AUTOINCREMENT, Beang text,Degree text,Time text, Temperature text,Water text)"
//        );
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + CONTACTS_TABLE_NAME + " (" +
                        "id" + " INTEGER PRIMARY KEY," +
                        "type TEXT,"+
                        "Beang text," +
                        "Time text,"+
                        "Temperature text,"+
                        "Water text,"+
                        "Degree" + " TEXT)";
        db.execSQL(SQL_CREATE_ENTRIES);

        Log.v("asd",SQL_CREATE_ENTRIES+"");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS CoffeeRecord");
        onCreate(db);
    }

    public boolean insertCoffeeRecord(String selectId ,String beang, int degree_, int time_, int temperature_, int water_) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String degree = String.valueOf(degree_);
        String time = String.valueOf(time_);
        String tempe = String.valueOf(temperature_);
        String water = String.valueOf(water_);


        contentValues.put("Beang", beang);
        contentValues.put("Degree", degree);
        contentValues.put("Time", time);
        contentValues.put("Temperature", tempe);
        contentValues.put("Water", water);
        contentValues.put("type",selectId);
        db.insert("CoffeeRecord", null, contentValues);
        Log.v("CC", contentValues+" ");
        return true;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from CoffeeRecord", null);
        Log.v("CC", "query");
        int no = res.getCount();
        Log.v("CC", "Rec No: " + no);
        return res;
    }
        /*public int numberOfRows() {
            SQLiteDatabase db = this.getReadableDatabase();
            int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME );
            return numRows;
        }*/

    /*public boolean updateNote(Integer id_, String type_, String topic_, String content_) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", type_);
        contentValues.put("topic", topic_);
        contentValues.put("content", content_);
        db.update("CoffeeRecord", contentValues, "id = ? ", new String[]{Integer.toString(id_)});
        return true;
    }*/

    /*public Integer deleteNote(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("CoffeeRecord", "id = ? ", new String[]{Integer.toString(id)});
    }*/

    public ArrayList<String> getAllCoffeeRecord() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from CoffeeRecord",null );
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex("type")));
            res.moveToNext();
        }
        return array_list;
    }


}

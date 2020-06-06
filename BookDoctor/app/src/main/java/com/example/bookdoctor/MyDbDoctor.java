package com.example.bookdoctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import doctor.doctor;
import patient.patient;


public class MyDbDoctor extends SQLiteOpenHelper {
    public static final int DB_VERSION =1;
    public static final String DB_NAME="doctor_booking.db";
    public static final String TABLE_NAME="doctor_table";
    public static final String KEY_ID1="doctors_Id";
    public static final String KEY_Name="Name";
    public static final String KEY_Specialization="specialization";
    public static final String KEY_Work_Time="time_slot";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = " CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_Name +" TEXT, "+ KEY_Specialization + " TEXT,"
                + KEY_Work_Time + " TEXT" + ");";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public MyDbDoctor(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void insert3(doctor d1){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_Name,d1.getKEY_Name());
        values.put(KEY_Specialization,d1.getKEY_Specialization());
        values.put(KEY_Work_Time,d1.getKEY_Work_Time());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public List<doctor> getAllDoctor(){
        List<doctor> doctorlist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = " SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);
        //Loop through now
        if(cursor.moveToFirst()){
            do {
                doctor dct = new doctor();
                dct.setKEY_Name(cursor.getString(1));
                dct.setKEY_Specialization(cursor.getString(2));
                dct.setKEY_Work_Time(cursor.getString(3));
                doctorlist.add(dct);
            }while (cursor.moveToNext());
        }
        return doctorlist;
    }

}


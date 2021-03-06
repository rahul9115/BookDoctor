package com.example.bookdoctor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

import patient.patient;

public class MyDbLogin extends SQLiteOpenHelper {
    public static final int DB_VERSION =1;
    public static final String DB_NAME="BookDoctor.db";
    public static final String TABLE_NAME="patients";

    public MyDbLogin(Context context) {
        super(context,DB_NAME, null,  DB_VERSION );
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ArrayList<patient> get_email(){
        ArrayList<patient> list=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = " SELECT * FROM " + TABLE_NAME;
        try (Cursor cursor = db.rawQuery(select, null)) {
            if (cursor.moveToFirst()) {
                do {
                    patient p2 = new patient();
                    p2.setKEY_email(cursor.getString(3));
                    p2.setKEY_password(cursor.getString(4));
                    list.add(p2);
                }while(cursor.moveToNext());
            }
        }catch (Exception e){
            Log.d("ex","Exception");
        }
        return list;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.bordeauxien_restaurant.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OrderHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABSE_NAME = "ord.db";

    public OrderHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_TABLE = "CREATE TABLE " + com.example.bordeauxien_restaurant.Database.OrderContract.OrderEntry.TABLE_NAME + " ("
                + com.example.bordeauxien_restaurant.Database.OrderContract.OrderEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +  com.example.bordeauxien_restaurant.Database.OrderContract.OrderEntry.COLUMN_NAME + " TEXT NOT NULL, "
                +  com.example.bordeauxien_restaurant.Database.OrderContract.OrderEntry.COLUMN_QUANTITY + " TEXT NOT NULL, "
                +  com.example.bordeauxien_restaurant.Database.OrderContract.OrderEntry.COLUMN_PRICE + " TEXT NOT NULL, "
                +  com.example.bordeauxien_restaurant.Database.OrderContract.OrderEntry.COLUMN_EXPRESS + " TEXT NOT NULL, "
                +  com.example.bordeauxien_restaurant.Database.OrderContract.OrderEntry.COLUMN_GIFT + " TEXT NOT NULL);";

                db.execSQL(SQL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

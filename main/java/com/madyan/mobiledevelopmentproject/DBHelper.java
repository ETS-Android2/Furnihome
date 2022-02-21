package com.madyan.mobiledevelopmentproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper
{
    public static final String DBNAME = "Login.db";

    public DBHelper(Context context)
    {
        super(context,DBNAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase myDB)
    {
        myDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        myDB.execSQL("create Table cart(id INTEGER primary key autoincrement, username TEXT, furnituretitle TEXT, furnitureimgid INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop Table if exists users");
        myDB.execSQL("drop Table if exists cart");
        onCreate(myDB);
    }

    public Boolean insertUserData(String username, String password)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDB.insert("users", null, contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Boolean checkUsername(String username)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM users WHERE username = ?" , new String[] {username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean checkUsernameAndPassword(String username, String password)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean addToCart(String username, String furnitureTitle, int furnitureImageId)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("furnituretitle", furnitureTitle);
        contentValues.put("furnitureimgid", furnitureImageId);
        long result = myDB.insert("cart", null, contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public ArrayList<Furniture> getCartItems(String username)
    {
        ArrayList<Furniture> furnitures = new ArrayList<Furniture>();
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT furnituretitle, furnitureimgid FROM cart WHERE username = ?", new String[] {username});
        while(cursor.moveToNext())
        {
            String furnitureTitle = cursor.getString(0);
            int furnitureImgId = cursor.getInt(1);
            furnitures.add(new Furniture(furnitureTitle,"", furnitureImgId, ""));
        }

        return furnitures;
    }
}

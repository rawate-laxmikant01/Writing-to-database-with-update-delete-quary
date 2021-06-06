package com.example.writingthedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="database_one";
    public static final int DATABASE_VIRSION=1;
    public static final String CREATE_TABLE="CREATE TABLE user_login(username text ,password text)";


    public DbHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VIRSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean updateData(String user,String pass,String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("username",user);
        values.put("password",pass);

        db.update("user_login",values,"username=?",new String[]{String.valueOf(name)});
        return true;

    }

}

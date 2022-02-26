package com.example.register;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Dbhelper extends SQLiteOpenHelper{

	public Dbhelper(Context context, int version) {
		super(context, "user", null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql="create table userinfo(_id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(20),pwd varchar(20))";

		Log.e("sql",sql);
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
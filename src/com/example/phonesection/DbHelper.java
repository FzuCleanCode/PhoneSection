package com.example.phonesection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

	private static  final String CREATE_PHONE = "CREATE TABLE user(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," 
	+ "category text DEFAULT \"\"," + "name text DEFAULT \"\"," + "number text DEFAULT \"\")";
	
	
	public DbHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PHONE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}

}

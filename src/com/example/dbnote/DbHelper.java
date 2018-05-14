package com.example.dbnote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "notepad.db";
	private static final int DATABASE_VERSION = 1;
	public static final String TABLE_pinfo = "personal";
	public static final String COLUMN_ID = "personId";
	public static final String COLUMN_Name = "name";
	public static final String COLUMN_LName = "lastname";
	public static final String COLUMN_Phonenum = "number";
	public static final String COLUMN_IMAGE = "image";
	
	private static final String TABLE_CREATE = 
			"CREATE TABLE " + TABLE_pinfo + " (" +
			COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			COLUMN_Name + " TEXT, " +
			COLUMN_LName + " TEXT, " +
			COLUMN_Phonenum + " NUMERIC, " +
			COLUMN_IMAGE + " TEXT " +
			")";
	public DbHelper(Context context) {
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
}

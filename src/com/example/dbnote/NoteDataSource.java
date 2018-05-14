package com.example.dbnote;

import java.util.ArrayList;
import java.util.List;

import com.example.phonebook.phoneclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteDataSource{
	SQLiteOpenHelper helper;
	SQLiteDatabase notedb;
	private static String[] Allcolumns={
		DbHelper.COLUMN_ID,
		DbHelper.COLUMN_Name,
		DbHelper.COLUMN_LName,
		DbHelper.COLUMN_IMAGE,
		DbHelper.COLUMN_Phonenum
	};
	
	public NoteDataSource(Context context)
	{
		helper=new DbHelper(context);
	}
	public void open()
	{
		notedb=helper.getWritableDatabase();
	}
	public void close()
	{
		helper.close();
	}
	public phoneclass Insert(phoneclass ph)
	{
		ContentValues values=new ContentValues();
		values.put(DbHelper.COLUMN_Name, ph.getName());
		values.put(DbHelper.COLUMN_LName, ph.getLname());
		values.put(DbHelper.COLUMN_IMAGE, ph.getIm());
		values.put(DbHelper.COLUMN_Phonenum, ph.getPhonenumber());
		long ID=notedb.insert(DbHelper.TABLE_pinfo, null, values);
		ph.setId(ID);
		return ph;
	}
	public List<phoneclass>findallitems()
	{
		Cursor cursor=notedb.query(DbHelper.TABLE_pinfo, Allcolumns, null, null, null, null, null);
		List<phoneclass> phones = cursortoList(cursor);
		return phones;
	}
	public List<phoneclass>finditemsneeded(String selection, String orderby)
	{
		Cursor cursor=notedb.query(DbHelper.TABLE_pinfo, Allcolumns, selection, null, null, null, orderby);
		List<phoneclass> phones = cursortoList(cursor);
		return phones;
	}
	private List<phoneclass> cursortoList(Cursor cursor) {
		List<phoneclass>phones=new ArrayList<phoneclass>();
		if(cursor.getCount()>0)
		{
			while (cursor.moveToNext()) {
				phoneclass ph=new phoneclass();
				ph.setId(cursor.getLong(cursor.getColumnIndex(DbHelper.COLUMN_ID)));
				ph.setName(cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_Name)));
				ph.setLname(cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_LName)));
				ph.setIm(cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_IMAGE)));
				ph.setPhonenumber(cursor.getLong(cursor.getColumnIndex(DbHelper.COLUMN_Phonenum)));
				phones.add(ph);
			}
		}
		return phones;
	}
}

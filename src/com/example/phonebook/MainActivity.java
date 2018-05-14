package com.example.phonebook;

import java.util.List;

import com.example.dbnote.NoteDataSource;
import com.example.helping.UIHelper;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	private List<phoneclass>phones;
	private NoteDataSource NDC;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		NDC=new NoteDataSource(this);
		NDC.open();
		Button but=(Button) findViewById(R.id.button1);
		but.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				createdata(R.id.Name, R.id.LName, R.id.phoneN, R.id.Image);
				Toast.makeText(MainActivity.this, "اطلاعات با موفقیت ثبت شد", Toast.LENGTH_LONG).show();
				UIHelper.ClearText(MainActivity.this, R.id.Name);
				UIHelper.ClearText(MainActivity.this, R.id.LName);
				UIHelper.ClearText(MainActivity.this, R.id.phoneN);
				UIHelper.ClearText(MainActivity.this, R.id.Image);
			}
		});
	findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			phones=NDC.findallitems();
			refreshdisplay(phones);
		}
	});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	protected void onPause() {
		super.onPause();
		NDC.close();
	}
	@Override
	protected void onResume() {
		super.onResume();
		NDC.open();
	}
	private void createdata(int idname,int idlname,int phoneid,int imgid)
	{
		phoneclass phone=new phoneclass();
		phone.setName(UIHelper.GetText(this, idname));
		phone.setLname(UIHelper.GetText(this, idlname));
		phone.setPhonenumber(Long.parseLong(UIHelper.GetText(this, phoneid)));
		phone.setIm(UIHelper.GetText(this, imgid));
		phone=NDC.Insert(phone);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_all:
			phones=NDC.findallitems();
			refreshdisplay(phones);
			break;
		case R.id.menu_mashhad:
			phones=NDC.finditemsneeded("name= 'mahdi'", "lastname ASC");
			refreshdisplay(phones);
			break;
		case R.id.menu_tehran:
			phones=NDC.finditemsneeded("name='reza'", "lastname ASC");
			refreshdisplay(phones);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	private void refreshdisplay(List<phoneclass> phones) {
		ArrayAdapter<phoneclass>ph=new ArrayAdapter<phoneclass>(MainActivity.this, 
				android.R.layout.simple_list_item_1, phones);
		setListAdapter(ph);
	}
}

package com.example.helping;

import android.app.Activity;
import android.widget.TextView;

public class UIHelper {
	
	public static void SetText(Activity activity, String text,int id)
	{
		TextView tv=(TextView) activity.findViewById(id);
		tv.setText(text);
	}
	public static String GetText(Activity activity,int id)
	{
		TextView tv=(TextView) activity.findViewById(id);
		return tv.getText().toString();
	}
	public static void ClearText(Activity activity, int id)
	{
		TextView tv=(TextView) activity.findViewById(id);
		tv.setText(null);
	}

}

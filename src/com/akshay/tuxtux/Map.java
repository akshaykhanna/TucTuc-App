package com.akshay.tuxtux;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

public class Map extends Activity
{
	DrawView drawView;
	int source,destination;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle b=getIntent().getExtras();
		 source=b.getInt("s");
        destination=b.getInt("d");
		 drawView = new DrawView(this);
		 drawView.setValues(source, destination);
	        drawView.setBackgroundColor(Color.WHITE);
	        setContentView(drawView);
	        
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	

}



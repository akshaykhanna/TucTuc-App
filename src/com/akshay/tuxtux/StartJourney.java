package com.akshay.tuxtux;


import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;



public class StartJourney extends Activity
{


	
	// protected ImageView _image;
	public EditText field;
    LinearLayout lf,lt,lc;
    RadioGroup rgM,rgF;
    RatingBar rBar;
    String text="",s,f[]={"User rating 4.5 Non meter Cost in range", "User rating 5 Non meter Cost less then range ","User rating 3.0 Non meter Cost More then range ","User rating 3.5 Metered  Cost In range "};
     TextView tv;
     int l;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		        
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_journey_lay);
		field = (EditText) findViewById(R.id.et_number);
		
		lf=(LinearLayout)findViewById(R.id.ll_feed)	;
		lt=(LinearLayout)findViewById(R.id.ll_thanks);
		lc=(LinearLayout)findViewById(R.id.ll_check);
		rgM=(RadioGroup) findViewById(R.id.rgM);
		rgF=(RadioGroup) findViewById(R.id.rgF);
	    rBar = (RatingBar) findViewById(R.id.ratingBar1);
		tv=(TextView) findViewById(R.id.tv123);

	}
	
	public void func_submit(View v)
	{
	 lf.setVisibility(View.GONE);
	  text+=field.getText().toString().trim();
	 
	 if(rgM.getCheckedRadioButtonId()!=-1){
		    int id= rgM.getCheckedRadioButtonId();
		    View radioButton = rgM.findViewById(id);
		    int radioId = rgM.indexOfChild(radioButton);
		    RadioButton btn = (RadioButton) rgM.getChildAt(radioId);
		     s = (String) btn.getText();
		}
	 text+=  " !" + s.charAt(0);
	 if(rgF.getCheckedRadioButtonId()!=-1){
		    int id= rgF.getCheckedRadioButtonId();
		    View radioButton = rgF.findViewById(id);
		    int radioId = rgF.indexOfChild(radioButton);
		    RadioButton btn = (RadioButton) rgF.getChildAt(radioId);
		     s = (String) btn.getText();
		}
	 text+=  " @" + s.charAt(0);
	 
	 text+= " #" + rBar.getRating();
	 
	 lt.setVisibility(View.VISIBLE);
	}
	
	public void func_check(View v)
	{
		Random r=new Random(4);
		int n=r.nextInt();
		tv.setText(f[n]);
		
	}
	public void func_open(View v)
	{
		
		lf.setVisibility(View.VISIBLE);
		lf.setVisibility(View.GONE);
	}
	
}
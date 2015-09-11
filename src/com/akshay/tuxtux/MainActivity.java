package com.akshay.tuxtux;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button b1,b2; 

	int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.bt_New);
        b2=(Button)findViewById(R.id.bt_Old);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void func_New(View v)
	{
		//new
    	if(counter==0)
    	//Toast.makeText(this,"Fare chart", Toast.LENGTH_LONG).show();
    	{	Intent sta2= new Intent(MainActivity.this,FareChart.class);
		startActivity(sta2);
		}
		else
		{
			//now
			Intent sta2= new Intent(MainActivity.this,Route.class);
			startActivity(sta2);
			
		}
    	
	}
    public void func_Old(View v)
    
   	{
   		//old
    	//Toast.makeText(this,"Now or Later", Toast.LENGTH_LONG).show();
   		if(counter==0)
   		{
   			b1.setText("Now");
   	   		b2.setText("Later");
   	   		counter++;
   		}
   		else
   		{
   			//later
   		}
       	//Intent 	i=new Intent(JoinPartyFirst.this,JoinParty.class);
   		//startActivity(i);
   		
   	}
	
}

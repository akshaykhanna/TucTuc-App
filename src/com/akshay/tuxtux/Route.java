package com.akshay.tuxtux;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Route extends ModActivity implements OnItemSelectedListener, OnClickListener

{

	Spinner spS,spD; 
    TextView tvD; 
    Button bVM,bStart;
    MapDesign obj=new MapDesign();
    String station[]=obj.locations;
    //String st[]=new String[station.length-1];
    //double time[]={0,5,13.2,20.6,29.5};
    double t,cost,basic_cost=7;
    
    String text="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.route_lay);
		intial();
	}

	private void intial() {
		// TODO Auto-generated method stub
		spS=(Spinner)findViewById(R.id.spSource);
		spD=(Spinner)findViewById(R.id.spDestination);
		tvD=(TextView)findViewById(R.id.tvData);
		bVM=(Button)findViewById(R.id.btViewImage);
		bStart=(Button)findViewById(R.id.bt_start);
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(Route.this,android.R.layout.simple_spinner_item,station);
		spS.setAdapter(adapter1);
		ArrayAdapter<String> adapter2=new ArrayAdapter<String>(Route.this,android.R.layout.simple_spinner_item,station);
		spD.setAdapter(adapter2);
		spS.setOnItemSelectedListener(this);
		spD.setOnItemSelectedListener(this);
		bStart.setOnClickListener(this);
		bVM.setOnClickListener(this);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	int si=0,di=0;
	float temp_t,temp_d,temp_cost;
	double time,d;
	 public void methodDest()
     {
		//tvD.setText("Trip Estimate");
		 cost=0;
		text="";
		 si=spS.getSelectedItemPosition();
			di=spD.getSelectedItemPosition();
			time=Math.sqrt( Math.pow((obj.coord[si][0]-obj.coord[di][0]), 2)+ Math.pow((obj.coord[si][1]-obj.coord[di][1]), 2));
			time=60*time;
	         /* if(si<di)
	        	  t=time[di]-time[si];
	          else
	        	  t=time[si]-time[di];
	           if(si<di)
	        	   d=di-si;
	           else
	        	   d=si-di;*/;
	        	d= (time*0.35);  
	          // cost=basic_cost + (d)*3;
	           temp_t=(float)(time);
	           temp_d=(float)(d);
	           if(d<=2 && d==0)
	        	   cost=25;
	           else
	        	 cost= (float)(25 +((d-2)*8));
	           temp_cost=(float)(cost);

	           /*if(temp_t.indexOf('.')!=-1)
	           {
	        	   temp_t=temp_t.substring(0, temp_t.indexOf('.')) + temp_t.substring( temp_t.indexOf('.'),temp_t.indexOf('.')+3);
	           }*/
	           text+="Time: "+ Math.round(temp_t)+" minutes";
	           text+="\n Distance= "+ Math.round(temp_d)+"km";
	           text+="\n Approx Cost= Rs "+ Math.round(temp_cost) +"--"+ (Math.round(temp_cost)+20);
	           tvD.setText(text);
     }
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		tvD.setText("Spinner selected");
		int k=0;
		switch(arg0.getId())
		{
		case R.id.spSource:
			//p=sp1.getSelectedItemPosition();
			methodDest();
			
			break;
		case R.id.spDestination:
		//p=sp2.getSelectedItemPosition();
			methodDest();
		
		}
		/*
		for(int i=0;i<station.length;i++)
		{
			if(i==spS.getSelectedItemPosition())
				continue;
			
			st[k]=station[i];
			k++;
		}*/
		//ArrayAdapter<String> adapter2=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,station);
		//spD.setAdapter(adapter2);
		/*switch(arg1.getId())
		{
		
		case R.id.spDestination: 
		*/
			/*
			si=spS.getSelectedItemPosition();
			di=spD.getSelectedItemPosition();
	          if(si<di)
	        	  t=time[di]-time[si];
	          else
	        	  t=time[si]-time[di];
	           if(si<di)
	        	   d=di-si;
	           else
	        	   d=si-di;
	           cost=basic_cost + (--d)*3;
	           text+="\n Time: "+ time+" min";
	           text+="\n Cost: Rs"+ cost+"/-";
	           tvD.setText(text);
	        	 
		break;
		default:
			
		} */
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
  
	int so,dest;
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId())
		{
		/*
		case R.id.btFare:/// no 
		methodDest();
		break;*/
		case R.id.bt_start:
			start_journey();
			methodDest();
			break;
		case R.id.btViewImage:
			so=spS.getSelectedItemPosition();
			dest=spD.getSelectedItemPosition();
			Bundle suitcase=new Bundle();
			suitcase.putInt("s",so);
			suitcase.putInt("d",dest);
			Intent id=new Intent(Route.this,Map.class);
			id.putExtras(suitcase);
				startActivity(id);
			break;	
		}
	}

	/*
	  public void fare_calc(View v)
		{
			//new
	    	
	    	Intent sta2= new Intent(Route.this,FareChart.class);
			startActivity(sta2);
			
	    	
		}*/
	 public void start_journey()
		{
			
	   
	    	Intent sta2= new Intent(Route.this,StartJourney.class);
			startActivity(sta2);
			
	    	
		}
}

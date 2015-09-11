package com.akshay.tuxtux;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ModActivity extends Activity
{
	private void handle_actionBar(String title)
    {
		// TODO Auto-generated method stub
    	 ColorDrawable colorDrawable = new ColorDrawable();
		ActionBar acb = getActionBar();
		//colorDrawable.setColor(0xff006B00);
       // acb.setBackgroundDrawable(colorDrawable);
        //enable home button
        acb.setHomeButtonEnabled(true);
        //change title of action bar
        acb.setTitle(title);
		//acb.setBackgroundDrawable(d);
        
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
		/*
	    switch (item.getItemId()) {
	    
	    case android.R.id.home:
	        Intent intent = new Intent(this, GalleryActivity.class);
	        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        startActivity(intent);
	        break;
	    // action with ID action_refresh was selected
	    case R.id.action_About:
	    	Intent ia=new Intent(this,RLD_About.class);
			startActivity(ia);
	      break;
	    // action with ID action_settings was selected
	    case R.id.action_Contact:
	      Toast.makeText(this, "Contact selected", Toast.LENGTH_SHORT)
	          .show();
	      Intent ic=new Intent(this,Contact.class);
			startActivity(ic);
	      break;
	    case R.id.action_Devloper:
		      Toast.makeText(this, "Developer selected", Toast.LENGTH_SHORT)
		          .show();
		      Intent id=new Intent(this,About.class);
				startActivity(id);
		      break;
	    case R.id.action_Rate:
		      Toast.makeText(this, "Rate selected", Toast.LENGTH_SHORT)
		          .show();
		      rateMyApp();
		      break;
	    default:
	      break;*
	    }
          */
	    return true;
	  } 
	
	public void rateMyApp() 
	{
	    Intent intent = new Intent(Intent.ACTION_VIEW);
	    //Try Google play
	    intent.setData(Uri.parse("market://details?id=package_name_or_id"));
	    if (!MyStartActivity(intent)) {
	        //Market (Google play) app seems not installed, let's try to open a webbrowser
	        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=package_name_or_id"));
	        if (!MyStartActivity(intent)) {
	            //Well if this also fails, we have run out of options, inform the user.
	            Toast.makeText(this, "Could not open Android market, please install the market app.", Toast.LENGTH_SHORT).show();
	        }
	    }
	    
	}
	private boolean MyStartActivity(Intent aIntent) {
	    try
	    {
	        startActivity(aIntent);
	        return true;
	    }
	    catch (ActivityNotFoundException e)
	    {
	        return false;
	    }
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//finish();
	}
	
}

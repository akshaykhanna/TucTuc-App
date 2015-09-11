package com.akshay.tuxtux;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

public class DrawView extends View {
    Paint paint = new Paint();
    int source=1,destination=3;
    MapDesign obj=new MapDesign();
    String station[]=obj.locations;
    float h,w;
    //Drawable draw= getResources().getDrawable( R.drawable.map_outline );
    public DrawView(Context context) 
    {
        super(context);
        paint.setColor(Color.BLACK);
        //setBackground(draw);
        //setBackgroundResource(R.drawable.map_outline);
    }
    public void setValues(int s,int d)
    {
    	source=s;
        destination=d;
    }

  
	@Override
    public void onDraw(Canvas canvas) {
       w=canvas.getWidth();
       h=canvas.getHeight();
      // Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.delhi);
      // canvas.drawBitmap(bmp,-w/4,h/4, null); // 24 is the height of image
       paint.setColor(Color.BLACK);
       paint.setTextSize(70); 
		canvas.drawText("Tuc Tuc Route", (float)(w*0.33),(float)(h*0.1), paint);
       drawCircleOnMap(canvas);
       drawSoucreDest(canvas);
       // Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.jiit_map_head);
        //canvas.drawBitmap(bmp,(float)((0.50*w)-(bmp.getWidth()/2)),(float)((0.10*h)-(bmp.getHeight()/2)), null); // 24 is the height of image 
       /*
        paint.setColor(Color.BLUE);
        
        paint.setStrokeWidth(6);
        canvas.drawLine((float) (0.70*w), ((float)(0.25*h)),((float)(0.4*w)),((float)(0.75*h)), paint);
        canvas.drawLine(((float)(0.4*w)),((float)(0.75*h)),((float)(0.45*w)),((float)(0.9*h)),paint);
        paint.setTextSize(30);
        paint.setColor(Color.RED);
        canvas.drawText("Start: "+station[source], (float) (0.09*w), ((float)(0.25*h+10)), paint);
        paint.setColor(Color.GREEN);
        canvas.drawText("Stop: "+station[destination], (float) (0.09*w), ((float)(0.25*h+45)), paint);
      //  paint.setColor(Color.BLACK);
       // canvas.drawRect((float) (0.1*w)-5, ((float)(0.25*h)-5), (float) (0.1*w)+100,((float)(0.25*h+70)), paint);
        drawRectAndText(canvas);
        //paint.setStrokeWidth(4);
    	//canvas.drawLine(((float)(3/4))*w, ((float)(1/4))*h,((float)(1/4))*w,((float)(3/5))*h, paint);
        //canvas.drawLine(((float)(1/4))*w,((float)(3/5))*h,((float)(1/2))*w,((float)(3/4))*h,paint);
         * */
         
    }
   
	private void drawCircleOnMap(Canvas canvas) 
    {
		// TODO Auto-generated method stub
    	paint.setColor(Color.BLUE);
    	for(int i=0;i<obj.locations.length;i++)
    	{
		canvas.drawCircle((float)obj.coord[i][0]*w,(float)obj.coord[i][1]*h, 7, paint);
		paint.setTextSize(20); 
		canvas.drawText(obj.locations[i], (float)obj.coord[i][0]*w+7,(float)obj.coord[i][1]*h, paint);
    	}
	}
	 private void drawSoucreDest(Canvas canvas) 
	 {
			// TODO Auto-generated method stub
		 paint.setColor(Color.BLACK);
	       paint.setStrokeWidth(6);
	        //canvas.drawLine((float) (0.70*w), ((float)(0.25*h)),((float)(0.4*w)),((float)(0.75*h)), paint);
	        canvas.drawLine((float)obj.coord[source][0]*w,(float)obj.coord[source][1]*h, (float)obj.coord[destination][0]*w,(float)obj.coord[destination][1]*h,  paint);
	       
	    		paint.setColor(Color.RED);	
	    		canvas.drawCircle((float)obj.coord[source][0]*w,(float)obj.coord[source][1] * h, 7, paint);
	    		//paint.setTextSize(30); 
	    		//canvas.drawText(obj.locations[source], (float)obj.coord[source][0]*w-15,(float)obj.coord[source][1]*h, paint);
	    		
	    		 paint.setColor(Color.GREEN);
	    		 canvas.drawCircle((float)obj.coord[destination][0]*w,(float)obj.coord[destination][1]*h, 7, paint);
		    		//paint.setTextSize(30); 
		    		//canvas.drawText(obj.locations[destination], (float)obj.coord[destination][0]*w-15,(float)obj.coord[destination][1]*h, paint);
	}
	 /*
	float y1,y2,x2,x1,m,c,px1,py1,px2,py2;
    public void drawRectAndText(Canvas canvas)
    {
    	
    	//source=1;destination=3;
    	//calculating line eq;
    	y1=((float)(0.25*h));
    	y2=((float)(0.75*h));
    	x1=(float) (0.70*w);
    	x2=((float)(0.4*w));
    	m=(float)((y2-y1)/(x2-x1));
    	c=y1-(m*x1);
    	//finding point 1
    	px1=((float)(0.6*w));
    	py1=(m*px1)+c;
    	//finding point 2
    	px2=((float)(0.5*w));
    	py2=(m*px2)+c;
    	if(destination==0 || source == 0)
    	{
    		if(source==0)
    		paint.setColor(Color.RED);
    		else
    	   paint.setColor(Color.GREEN);	
    		canvas.drawCircle((float) (0.70*w),((float)(0.25*h)), 15, paint);
    		paint.setTextSize(30); 
    		canvas.drawText(station[0], (float) (0.70*w+15),((float)(0.25*h)), paint);
    		

    	}
    	else
    	{
    		paint.setColor(Color.BLUE);
    		canvas.drawCircle((float) (0.70*w),((float)(0.25*h)), 7, paint);
    		paint.setTextSize(20); 
    		canvas.drawText(station[0], (float) (0.70*w+7),((float)(0.25*h)), paint);
    		
    	}
    	if(destination==1 || source == 1)
    	{
    		if(source==1)
        		paint.setColor(Color.RED);
        		else
        	   paint.setColor(Color.GREEN);	
    		canvas.drawCircle(px1,py1, 15, paint);
    		paint.setTextSize(30); 
    		canvas.drawText(station[1], px1+30,py1, paint);
    		
    	}
    	else
    	{
    		paint.setColor(Color.BLUE);
    		canvas.drawCircle(px1,py1, 7, paint);
    		paint.setTextSize(20); 
    		canvas.drawText(station[1], px1+7,py1, paint);
    	}
    	if(destination==2 || source == 2)
    	{
    		if(source==2)
        		paint.setColor(Color.RED);
        		else
        	   paint.setColor(Color.GREEN);	    		
    		canvas.drawCircle(px2,py2, 15, paint);
    		paint.setTextSize(30); 
    		canvas.drawText(station[2], px2+15,py2, paint);
    	}
    	else
    	{
    		paint.setColor(Color.BLUE);
    		canvas.drawCircle(px2,py2, 7, paint);
    		paint.setTextSize(20); 
    		canvas.drawText(station[2], px2+7,py2, paint);
    	}
    	if(destination==3 || source == 3)
    	{
    		if(source==3)
        		paint.setColor(Color.RED);
        		else
        	   paint.setColor(Color.GREEN);	
    		canvas.drawCircle(((float)(0.4*w)),((float)(0.75*h)), 15, paint);
    		paint.setTextSize(30); 
    		canvas.drawText(station[3], ((float)(0.4*w+15)),((float)(0.75*h)), paint);
    	}
    	else
    	{
    		paint.setColor(Color.BLUE);
    		canvas.drawCircle(((float)(0.4*w)),((float)(0.75*h)), 7, paint);
    		paint.setTextSize(20); 
    		canvas.drawText(station[3], ((float)(0.4*w+7)),((float)(0.75*h)), paint);
    	}
    	if(destination==4 || source == 4)
    	{
    		if(source==4)
        		paint.setColor(Color.RED);
        		else
        	   paint.setColor(Color.GREEN);	
    		canvas.drawCircle(((float)(0.45*w)),((float)(0.9*h)), 15, paint);
    		paint.setTextSize(30); 
    		canvas.drawText(station[4],((float)(0.45*w+15)),((float)(0.9*h)), paint);
    	}
    	else
    	{
    		paint.setColor(Color.BLUE);
    		canvas.drawCircle(((float)(0.45*w)),((float)(0.9*h)), 7, paint);
    		paint.setTextSize(20); 
    		canvas.drawText(station[4],((float)(0.45*w+7)),((float)(0.9*h)), paint);
    	}
    }
	*/

}
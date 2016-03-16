package com.kainotomia.start;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class splash extends Activity {
	 public static final int TIMER_RUNTIME = 5000;
	 public boolean mbActive;
	 public TextView progress;
	 public Button b;
	 public EditText et;
	   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.splashing);
		progress=(TextView)findViewById(R.id.textView1);
		
		b=(Button)findViewById(R.id.buttonConn);
		et=(EditText)findViewById(R.id.editIP);
	}
	public void clicked(View view)
	{
		client.getIP(et.getText().toString());
		progress.setText("Wait.... Getting Permission from windows...");

		
			Thread background = new Thread() {
				public void run() {
	      
	               try {
	                    
	                    
	            	   Display display =    getWindowManager().getDefaultDisplay();
	       		    Point size = new Point();
	       		    display.getSize(size);
	       		    double width = size.x;
	       		    double height = size.y;
	       		    String loc="*x"+width+"y"+height;
	       		    client.launching(loc);
	                    
	                    Intent i=new Intent(getBaseContext(),MainActivity.class);
	                    startActivity(i);
	                    
	                    
	                    finish();
	                     
	                } catch (Exception e) {
	                 
	                }
	        
	          }
	       };  background.start();
	     		 
		}
	

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	

	

	
}

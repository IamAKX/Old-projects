package com.akash.brainreader;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Res extends Activity {
	static int res=0;
	TextView txt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	          WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_res);
		txt=(TextView)findViewById(R.id.showIt);
		try {
			Thread.sleep(1000);
			txt.setText(String.valueOf(res));
			res=0;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void again(View v)
	{
		Thread background = new Thread() {
            public void run() {
                 
                try {
                    
                 
                    Intent i=new Intent(getBaseContext(),BlockOne.class);
                    startActivity(i);
                     
                    finish();
                     
                } catch (Exception e) {
                 
                }
            }
        };
         
        
        background.start();
	}
	public static void cal(int a)
	{
		res+=a;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.res, menu);
		return true;
	}

}

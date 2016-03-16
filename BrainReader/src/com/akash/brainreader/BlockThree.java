package com.akash.brainreader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class BlockThree extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	          WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_block_three);
	}

	
	public void onClickYes(View view)
	{
		int a=4;
	
		Res.cal(a);
		Thread background = new Thread() {
            public void run() {
                 
                try {
                    
                   // sleep(1000);
                     
                    Intent i=new Intent(getBaseContext(),BlockFour.class);
                    startActivity(i);
                     
                    finish();
                     
                } catch (Exception e) {
                 
                }
            }
        };
         
        
        background.start();
   
	}
	public void onClickNo(View view)
	{
		
		Thread background = new Thread() {
            public void run() {
                 
                try {
                    
                   
                    Intent i=new Intent(getBaseContext(),BlockFour.class);
                    startActivity(i);
                     
                    finish();
                     
                } catch (Exception e) {
                 
                }
            }
        };
         
        
        background.start();
   
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.block_three, menu);
		return true;
	}

}

package com.akash.prankcalci;

import android.R.color;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	 private static final String TAG = "ServicesDemo";
	 TextView tv;
	 RelativeLayout l;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		tv=(TextView)findViewById(R.id.textView1);
		l=(RelativeLayout)findViewById(R.id.lay);
		

		 
	}
	
	
   
	public void clear(View view)
	{
		tv.setText("0");
	}
	public void print(View view)
	{
		
		 Button b = (Button)view;
		    String s = b.getText().toString();
		    tv.setText(tv.getText().toString()+s);
	}
	
	public void startService(View view)
	{
		tv.setText("Hehehe!! You Fool!!");
		 Log.d(TAG, "onClick: starting srvice");
	    startService(new Intent(this, MyService.class));
	      Animation anim = new AlphaAnimation(0.0f, 1.0f);
	      anim.setDuration(50); //You can manage the time of the blink with this parameter
	      anim.setStartOffset(20);
	      l.setBackgroundColor(Color.parseColor("#eb0509"));
	      anim.setRepeatMode(Animation.REVERSE);
	      anim.setRepeatCount(Animation.INFINITE);
	      l.startAnimation(anim);
	}
	public void stopService(View view)
	{
		Log.d(TAG, "onClick: stopping srvice");
	      startService(new Intent(this, MyService.class));
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

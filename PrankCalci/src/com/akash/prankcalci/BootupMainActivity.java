package com.akash.prankcalci;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class BootupMainActivity extends Activity {
	 private static final String TAG = "ServicesDemo";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 Log.d(TAG, "onClick: starting srvice");
		    startService(new Intent(this, MyService.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bootup_main, menu);
		return true;
	}
	public void startService(View view)
	{
		//tv.setText("Hehehe!! You Fool!!");
		 Log.d(TAG, "onClick: starting srvice");
	    startService(new Intent(this, MyService.class));
	     /* Animation anim = new AlphaAnimation(0.0f, 1.0f);
	      anim.setDuration(50); //You can manage the time of the blink with this parameter
	      anim.setStartOffset(20);
	      l.setBackgroundColor(Color.parseColor("#eb0509"));
	      anim.setRepeatMode(Animation.REVERSE);
	      anim.setRepeatCount(Animation.INFINITE);
	      l.startAnimation(anim);*/
	}

}

package com.akash.prankcalci;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class BootUpReceiver extends BroadcastReceiver{
	 private static final String TAG = "ServicesDemo";
    @Override
    public void onReceive(Context context, Intent intent) {
           Intent i = new Intent(context, BootupMainActivity.class);  
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
    	 //Log.d(TAG, "onClick: starting srvice");
 	    // startService(new Intent(this, MyService.class));	
         
    }
}
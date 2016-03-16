package com.akash.prankcalci;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;


public class MyService extends Service {
	private static final String TAG = "MyService";
	MediaPlayer player;
	Vibrator vibrator;
	public void onCreate() {
		Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
		 
		player = MediaPlayer.create(this, R.raw.abc);
		player.setLooping(true); 
		
		
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);    
	      vibrator.vibrate(999999);  
			
	}		
		
	/*public void makeCall() {
		 
		Calendar c= Calendar.getInstance();
		 SimpleDateFormat sdf = new SimpleDateFormat("mm");
		 String strDate = sdf.format(c.getTime());
	      
                Log.i("Make call", "");

	      Intent phoneIntent = new Intent(Intent.ACTION_CALL);
	      phoneIntent.setData(Uri.parse("tel:91-916-3009-564"));

	      try {
	    	 // if(Integer.parseInt(strDate)%5==0)
	    	  if(Integer.parseInt(strDate)==49)
	    	  {
				 Toast.makeText(getApplicationContext(), strDate, Toast.LENGTH_LONG).show();
					
	         startActivity(phoneIntent);
	         finish();
	         Log.i("Finished making a call...", "");
	         
				 }
	 		 else
	 			 Toast.makeText(getApplicationContext(), strDate, Toast.LENGTH_LONG).show();

	      } catch (android.content.ActivityNotFoundException EX) {
	         Toast.makeText(MyService.this, 
	         "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
	      }
	   }*/
	
	

	private void finish() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDestroy() {
		Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy");
		player.stop();
	}
	
	@Override
	public void onStart(Intent intent, int startid) {
		Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onStart");
		// makeCall();
		AudioManager am = 
			    (AudioManager) getSystemService(Context.AUDIO_SERVICE);

			am.setStreamVolume(
			    AudioManager.STREAM_MUSIC,
			    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
			    0);
		player.start();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}

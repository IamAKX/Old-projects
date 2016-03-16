package com.kainotomia.start;

import org.apache.http.conn.ClientConnectionManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class TrackPad extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.trackpad);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		/*if(event.equals(MotionEvent.ACTION_MOVE))
		{
			
		}*/
		float x=event.getX();
		float y=event.getY();
		//String data="Motion x="+x+"ex y="+y+"ey";
		String data="#x"+x+"y"+y;
		client.launching(data);
		//System.out.println("x = "+x+" y = "+y);
		return super.onTouchEvent(event);
	}
	public void right(View view)
	{
		client.launching("rightclick");
	}
	public void left(View view)
	{
		client.launching("leftclick");
	}

}

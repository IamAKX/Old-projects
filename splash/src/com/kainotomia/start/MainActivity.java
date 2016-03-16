package com.kainotomia.start;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Locale;


import com.kainotomia.start.view.viewgroup.FlyOutContainer;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.text.InputFilter.LengthFilter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements FragmentManager.OnBackStackChangedListener  {
static String hist="";
protected static final int RESULT_SPEECH=1;
	 private Handler mHandler = new Handler();
	 float x1,y1,x2,y2;
	 private final int REQ_CODE_SPEECH_INPUT = 100;
	private static TextView log1;
     private boolean mShowingBack = false;
     EditText et;
     FlyOutContainer root;
     View vi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.main);
		
			 
		 
		 if (savedInstanceState == null) 
		{        getFragmentManager()
	                    .beginTransaction()
	                    .add(R.id.container, new CardFrontFragment())
	                    .commit();
	        } else {
	            mShowingBack = (getFragmentManager().getBackStackEntryCount() > 0);
	        }

	        getFragmentManager().addOnBackStackChangedListener(this);
	        mShowingBack=false;
	        //log1.setText("hello");
	
	       
	}
	
	
	public void speech(View view)
	{
		promptSpeechInput();
	}
	
	
	
	private void promptSpeechInput() {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
				getString(R.string.speech_prompt));
		try {
			startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
		} catch (ActivityNotFoundException a) {
			Toast.makeText(getApplicationContext(),
					getString(R.string.speech_not_supported),
					Toast.LENGTH_SHORT).show();
		}
	}
	
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {
		case REQ_CODE_SPEECH_INPUT: {
			if (resultCode == RESULT_OK && null != data) {

				ArrayList<String> result = data
						.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
				//String s=setText(result.get(0));
				//Toast.makeText(getApplicationContext(), result.get(0), Toast.LENGTH_LONG).show();
			client.launching(result.get(0));
			}
			break;
		}

		}
	}
	
	public  void launchdesktop(View view)
	{
		hist+="Desktop\n";

		client.launching("start desktop:");
		/*Toast.makeText(getApplicationContext(), hist,Toast.LENGTH_LONG ).show();
		Intent intent = new Intent(MainActivity.this, LogGenerator.class);
        intent.putExtra("tempstring", hist);
        startActivity(intent);
        SystepromptSpeechInput();m.out.print("History : "+hist);
		*/
			}
			
	public void launchskype(View view)
	{
		hist+="Skype\n";
		client.launching("start skype:");
	}
	public static void launchxbox(View view)
	{
		hist+="XBox\n";
	client.launching("start xboxgames:");
	}
	public static void launchpeople(View view)
	{
		
	
		client.launching("start wlpeople:");
	}
	public static void launchmail(View view)
	{
		hist+="Mail\n";
		client.launching("start mailto:");
	}
	public static void launchiexplore(View view)
	{
		hist+="Internet Explorer\n";
		client.launching("iexplore");
	}
	public static void launchcalender(View view)
	{
		hist+="Calender\n";
				client.launching("start wlcalendar:");
	}
	public static void launchmusic(View view)
	{
		hist+="Music\n";
		client.launching("start microsoftmusic:");
	}
	public static void launchvideo(View view)
	{
		hist+="Video\n";
		client.launching("start microsoftvideo:");
	}
	public static void launchreadinglist(View view)
	{
		hist+="Reading List\n";
		client.launching("start windowsreadinglist:");
	}
	public static void launchweather(View view)
	{
		hist+="Weather\n";
		client.launching("start bingweather:");
	}
	public static void launchfinance(View view)
	{
		hist+="Finance\n";
		client.launching("start bingfinance:");
	}
	public static void launchfood(View view)
	{

		hist+="Food\n";
		client.launching("start bingfoodanddrink:");
	}
	public static void launchhealth(View view)
	{
		hist+="Health\n";
		client.launching("start binghealthnfitness:");
	}
	public static void launchstore(View view)
	{
		hist+="Store\n";
		client.launching("start ms-windows-store:");
	}
	public static void launchmaps(View view)
	{
		hist+="Maps\n";
		client.launching("start bingmaps:");
	}
	public static void launchnews(View view)
	{
		hist+="News\n";
		client.launching("start bingnews:");
	}
	public static void launchsport(View view)
	{
		hist+="Sport\n";
		client.launching("start bingsports:");
	}
	public static void launchtravel(View view)
	{
		hist+="Travel\n";
		client.launching("start bingtravel:");
	}
	public void showTrackPad()
	{
		Intent i=new Intent(getBaseContext(),TrackPad.class);
        startActivity(i);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
		case R.id.trackpad : showTrackPad();
		break;
		case R.id.About : startActivity(new Intent(getBaseContext(),About.class));
		break;
		case R.id.ctrl : showCTRL();
		break;
		
		
		
		}
		return super.onOptionsItemSelected(item);
	}










void showCTRL() {
	
		client.launching("control panel");
	}





	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sample, menu);
		return true;
	}
	public void toggleMenu(View v){
		this.root.toggleMenu();
		 this.root = (FlyOutContainer) this.getLayoutInflater().inflate(R.layout.proglist, null);
			this.setContentView(root);
			
			
	}
	
	 private void flipCard() {
	        if (mShowingBack) {
	            getFragmentManager().popBackStack();
	            return;
	        }

	        mShowingBack = true;

	        getFragmentManager()
	                .beginTransaction()
                .setCustomAnimations(
	                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
	                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)

	                .replace(R.id.container, new CardBackFragment())

	                .addToBackStack(null)

	                .commit();
	    	mHandler.post(new Runnable() {
	            @Override
	            public void run() {
	                invalidateOptionsMenu();
	            }
	        });
	    }

	    @Override
	    public void onBackStackChanged() {
	        mShowingBack = (getFragmentManager().getBackStackEntryCount() > 0);

	        invalidateOptionsMenu();
	    }

	   
	    public static class CardFrontFragment extends Fragment {
	        public CardFrontFragment() {
	        }

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	            return inflater.inflate(R.layout.activity_main, container, false);
	        }
	    }
	    public void runcmd(View view)
	    {
	    	// LayoutInflater i=(LayoutInflater)new Activity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			// vi=i.inflate(R.layout.proglist, null);
			et=(EditText)findViewById(R.id.command);
	    	
	    	String str=et.getText().toString();
	    	
	    	client.launching(str);
	    }
	    public void shutdown(View view)
	    {
	    	client.launching("shutdown /s /t 1");
	    }
	    public void restart(View view)
	    {
	    	client.launching("shutdown /r /t 1");
	    }
	    public void omg(View view)
	    {
	    	flipCard();
	    }

	    public static class CardBackFragment extends Fragment {
	        public CardBackFragment() {
	        }

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	            return inflater.inflate(R.layout.proglist, container, false);
	        }
	    }
	    
	    public boolean onTouchEvent(MotionEvent touchevent) 
	    {
	                 switch (touchevent.getAction())
	                 {
	                         case MotionEvent.ACTION_DOWN: 
	                         {
	                             x1 = touchevent.getX();
	                             y1 = touchevent.getY();
	                             break;
	                        }
	                         case MotionEvent.ACTION_UP: 
	                         {
	                             x2 = touchevent.getX();
	                             y2 = touchevent.getY(); 
                                 if (y1 < y2) 
	                             {
	                                 omg(null);
	                             }
	                            
	                            
	                             if (y1 > y2)
	                             {
	                                omg(null);
	                              }
	                             break;
	                         }
	                 }
	                 return false;
	    }
	    

	}




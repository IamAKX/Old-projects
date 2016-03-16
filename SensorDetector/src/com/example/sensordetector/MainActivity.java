package com.example.sensordetector;

import java.util.List;


import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

   @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
	   
	   switch(item.getItemId())
		{
		
		case R.id.About : startActivity(new Intent(getBaseContext(),AboutUs.class));
		break;
		
		
		
		
		}
		return super.onOptionsItemSelected(item);
	   
	   
		
	}

private SensorManager sMgr;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      TextView sensorsData = (TextView)findViewById(R.id.textView1);

      sMgr = (SensorManager)this.getSystemService(SENSOR_SERVICE);
      List<Sensor> list = sMgr.getSensorList(Sensor.TYPE_ALL);

      StringBuilder data = new StringBuilder();
      for(Sensor sensor: list){
         data.append("NAME : "+sensor.getName() + "\n");
         data.append("VENDOR : "+sensor.getVendor() + "\n");
         data.append("Version : "+sensor.getVersion() + "\n");
         data.append("\n\n");

   }
   sensorsData.setText(data);
}

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }

}
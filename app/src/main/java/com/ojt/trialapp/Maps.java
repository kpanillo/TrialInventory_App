package com.ojt.trialapp;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.location.Criteria;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by OJT on 1/29/2015.
 */
public class Maps extends Activity {

   // LocationManager locationManager;
   // String provider;
   // LocationListener listener;


    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main2);

        LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        LocationListener listener = new MyLocationListener();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
    }
   public class MyLocationListener implements LocationListener{

       @Override
       public void onLocationChanged(Location loc) {
          // loc = null;
           loc.getLatitude();
           loc.getLongitude();

           String Text = "My current location is:" +
           "Latitude = " + loc.getLatitude() +
           "Longitude = " + loc.getLongitude();

           Toast.makeText( getApplicationContext(),
                   Text,
                   Toast.LENGTH_SHORT).show();
       }

       @Override
       public void onStatusChanged(String provider, int status, Bundle extras) {

       }

       @Override
       public void onProviderEnabled(String provider) {
           Toast.makeText( getApplicationContext(),
                   "Gps Disabled",
                   Toast.LENGTH_SHORT ).show();
       }

       @Override
       public void onProviderDisabled(String provider) {
           Toast.makeText( getApplicationContext(),
                   "Gps Enabled",
                   Toast.LENGTH_SHORT).show();
       }
   }
}

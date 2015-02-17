package com.ojt.trialapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.location.LocationManager;
import android.location.LocationListener;
import android.location.Location;
import android.location.Criteria;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private static final int IMAGE_CAPTURE = 0;
    Button btnAdd;
    Button btnTakePhoto;
    Button btnLocate;
    ImageView iV;
    LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnTakePhoto = (Button)findViewById(R.id.btnTakePhoto);
        iV = (ImageView)findViewById(R.id.theImage);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Notes.class);
                startActivity(intent);

      }
    });
        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });

        btnLocate =(Button)findViewById(R.id.btnLocate);
        btnLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Maps.class);
                startActivity(intent);

        btnLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

            }
        });
    }

    @Override
        public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, IMAGE_CAPTURE);
    }
    public void onActivityResult (int requestcode, int resultcode, Intent data)
    {
        if (requestcode==0)
        {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                iV.setImageBitmap(bitmap);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

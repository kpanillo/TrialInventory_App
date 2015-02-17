package com.ojt.trialapp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;


/**
 * Created by OJT on 1/5/2015.
 */
public class Notes extends Activity{


    EditText input;
    Button getInfo;
    ListView listView;
    ArrayAdapter aAdapter;
    ArrayList aList = new ArrayList();
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main1);

            input = (EditText)findViewById(R.id.editText3);
            getInfo = (Button)findViewById(R.id.btnSaveNote);
            listView = (ListView)findViewById(R.id.listView);
            aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, aList);
            listView.setAdapter(aAdapter);


            getInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aList.add(input.getText().toString());
                    aAdapter.notifyDataSetChanged();

                    EditText input = (EditText) findViewById(R.id.editText3);
                    input.setText("");

                }

            });

       }

  }


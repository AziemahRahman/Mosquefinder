package com.example.user.mosquefinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.text.SimpleDateFormat;

    public class PrayerTime extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_prayer_time);
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        while (!isInterrupted()) {
                            Thread.sleep(500);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    TextView tdate = (TextView) findViewById(R.id.date);
                                    long date = System.currentTimeMillis();
                                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy\nhh-mm-ss a");
                                    String dateString = sdf.format(date);
                                    tdate.setText(dateString);
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();

            ImageButton buttonNearby = (ImageButton) findViewById(R.id.buttonNearby);
            buttonNearby.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PrayerTime.this, MapsActivity.class);
                    startActivity(intent);
                }
            });

            Button buttonTime = (Button) findViewById(R.id.buttonTime);
            buttonTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(PrayerTime.this, PrayerTime.class);
                    startActivity(intent1);
                }
            });

            Button buttonSetting= (Button) findViewById(R.id.buttonSetting);
            buttonSetting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = new Intent(PrayerTime.this, MapsActivity.class);
                    startActivity(intent2);
                }
            });

        }
    }
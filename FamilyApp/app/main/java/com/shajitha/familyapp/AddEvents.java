package com.shajitha.familyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;

import android.provider.CalendarContract;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddEvents extends AppCompatActivity {

TextView dateToday;
Calendar calendar;
SimpleDateFormat dateFormat;
String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        dateToday = findViewById(R.id.datetoday);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy" );
        date = dateFormat.format(calendar.getTime());

        dateToday.setText(date);
    }

        public void AddEvent(View view){



            Intent event = new Intent(Intent.ACTION_EDIT);

            //To launch calendar editor
            event.setType("vnd.android.cursor.item/event");
            getSupportActionBar().hide();

            // To add extra characteristics
            event.putExtra("title", "Added Event using FamilyApp");

            event.putExtra("beginTime", calendar.getTimeInMillis());
            event.putExtra("endTime", calendar.getTimeInMillis() + 60 * 60 * 1000);

            event.putExtra("allDay", true);

            // To make recurring events EX:FREQ=WEEKLY;INTERVAL=2;BYDAY=MO
            event.putExtra("rule", "FREQ=YEARLY");

            startActivity(event);
        }


    public void addCalendar(View v) {
        Intent cal = new Intent(this, viewCalendar.class);
        startActivity(cal);
    }
    }

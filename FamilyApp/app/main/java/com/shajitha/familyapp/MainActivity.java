package com.shajitha.familyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void addEvents(View v) {
        Intent events = new Intent(this, AddEvents.class);
        startActivity(events);
    }

    public void mealPlanner(View v) {
        Intent mealplanner = new Intent(this, MealPlanner.class);
        startActivity(mealplanner);
    }

    public void famappTimer(View v) {
        Intent famapptimer = new Intent(this,FamAppTimer.class);
        startActivity(famapptimer);
    }

    public void famAppTodoList(View v) {
        Intent todolist = new Intent(this, ToDoList.class);
        startActivity(todolist);
    }

    public void Reading(View v) {
        Intent reading = new Intent(this, Reading.class);
        startActivity(reading);
    }

    public void photoGallery(View v) {
        Intent photogallery = new Intent(this, PhotoGallery.class);
        startActivity(photogallery);
    }

    public void checkList (View v) {
        Intent cList = new Intent(this, CheckList.class);
        startActivity(cList);
    }

    public void activities(View v) {
        Intent activitiesFun = new Intent(this, ActivitiesFun.class);
        startActivity(activitiesFun);
    }

    public void contactUs(View v) {
        Intent contactus = new Intent(this, ContactUs.class);
        startActivity(contactus);
    }


}
package com.shajitha.familyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class MealPlanner extends AppCompatActivity
{
Spinner spinnerMenu;

ImageView spinBoard;
Button spin;
CountDownTimer timer;
Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_planner);
        getSupportActionBar().hide();

        // spinner menu/list
        spinnerMenu = findViewById(R.id.mealspinner1);

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,
                R.array.foodmenu, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item); //layout
        spinnerMenu.setAdapter(adapter);

        // spinner spinboard

        spin = findViewById(R.id.spin);
        spinBoard = findViewById(R.id.spinBoard);


        spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spin.setEnabled(false);


                int spinVal = random.nextInt(15)+5;


                // full 360 rotation for 8 parts 360/8 = 45 degrees
                spinVal = spinVal * 45;

                // for more than one rotation. 1ms one rotation 10. set 2 degrees
                timer = new CountDownTimer(spinVal*20,1) {
                    @Override
                    public void onTick(long l) {

                        float rotateTimer = spinBoard.getRotation() + 2;
                        spinBoard.setRotation(rotateTimer);
                    }

                    @Override
                    public void onFinish() {

                        spin.setEnabled(true);
                    }
                }.start();

            }
        });
    }


}


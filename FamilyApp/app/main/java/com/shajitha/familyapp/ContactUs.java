package com.shajitha.familyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import java.util.Random;

public class ContactUs extends AppCompatActivity {
    int rand1;
    ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().hide();

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);

        int []imgArray1={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,
                R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10};
        int []imgArray2={R.drawable.b1,R.drawable.b2,R.drawable.b3};

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i=0;
            int j=0;
            public void run() {
                img1.setImageResource(imgArray1[i]);
                i++;
                if(i>imgArray1.length-1)
                {
                    i=0;
                }
                img2.setImageResource(imgArray2[j]);
                j++;
                if(j>imgArray2.length-1)
                {
                    j=0;
                }
                handler.postDelayed(this, 1500);
            }
        };
        handler.postDelayed(runnable, 500);
    }
    }









package com.shajitha.familyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Timer;

public class FamAppTimer<RemindTask> extends AppCompatActivity {

    TextView timertxt, timer1;

    ImageView startstop_timer,reset_timer;
    Button getready, watchmedia, cleanup;

    CountDownTimer countdownTimer;

    long START_TIMER_IN_MILLISEC;
    long monitor_Countdown = START_TIMER_IN_MILLISEC;

    Boolean isTimerOn= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fam_app_timer);

        timertxt = findViewById(R.id.timertext);
        timer1 = findViewById(R.id.timer1);
        getready = findViewById(R.id.getready);
        watchmedia= findViewById(R.id.watchmedia);
        cleanup = findViewById(R.id.cleanup);

        startstop_timer  = findViewById(R.id.startstoptimer);
        reset_timer = findViewById(R.id.resettimer);

        //to start and stop timer
        startstop_timer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isTimerOn) {
                    pauseTimer();
                    startstop_timer.setImageResource(R.drawable.pause);
                }
                else{
                    startTimer();
                    startstop_timer.setImageResource(R.drawable.starttimer);
                }
            }
        });

        //to reset timer
        reset_timer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                resetTimer();
            }

        });
        updateTimer();
    }


    public void startTimer()
    {
        countdownTimer = new CountDownTimer(monitor_Countdown, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                monitor_Countdown = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {

                isTimerOn = false;
                timertxt.setText("Time Up!!!");
                getready.setBackgroundColor(Color.parseColor("#E8D46D"));
                cleanup.setBackgroundColor(Color.parseColor("#E8D46D"));
                watchmedia.setBackgroundColor(Color.parseColor("#E8D46D"));

            }
        }.start();
        isTimerOn = true;
    }
    public void pauseTimer(){
        countdownTimer.cancel();
        isTimerOn = false;

    }
    public void resetTimer(){
        countdownTimer.cancel();
        isTimerOn = true;

        getready.setBackgroundColor(Color.parseColor("#E8D46D"));
        cleanup.setBackgroundColor(Color.parseColor("#E8D46D"));
        watchmedia.setBackgroundColor(Color.parseColor("#E8D46D"));

        timertxt.setText("");
        startstop_timer.setImageResource(R.drawable.starttimer);
        START_TIMER_IN_MILLISEC = 0;
        monitor_Countdown = START_TIMER_IN_MILLISEC;
        getready.setEnabled(true);
        watchmedia.setEnabled(true);
        cleanup.setEnabled(true);
        updateTimer();

    }

    public void updateTimer(){
        int hours = (int)  ((monitor_Countdown/1000) / 60) / 60 ;
        int minutes = (int) (monitor_Countdown/1000) / 60 % 60;
        int seconds = (int) (monitor_Countdown/1000) % 60;



        String timeformat = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours , minutes, seconds);
        timer1.setText(timeformat);

    }

    public void getready(View v) {

        timertxt.setText("Get Ready in");


        getready.setBackgroundColor(Color.LTGRAY);
        cleanup.setBackgroundColor(Color.parseColor("#E8D46D"));
        watchmedia.setBackgroundColor(Color.parseColor("#E8D46D"));

        startstop_timer.setImageResource(R.drawable.starttimer);
        getSupportActionBar().hide();

        START_TIMER_IN_MILLISEC = 900000;
        monitor_Countdown = START_TIMER_IN_MILLISEC;

        updateTimer();

        getready.setEnabled(false);
    }

    public void watchmedia(View v) {

        timertxt.setText("Watch or play media for");

        watchmedia.setBackgroundColor(Color.LTGRAY);
        getready.setBackgroundColor(Color.parseColor("#E8D46D"));
        cleanup.setBackgroundColor(Color.parseColor("#E8D46D"));

        startstop_timer.setImageResource(R.drawable.starttimer);

        START_TIMER_IN_MILLISEC = 3600000;
        monitor_Countdown = START_TIMER_IN_MILLISEC;

        updateTimer();
        watchmedia.setEnabled(false);

    }
    public void cleanup(View v) {

        timertxt.setText("Clean up in");

        cleanup.setBackgroundColor(Color.LTGRAY);
        getready.setBackgroundColor(Color.parseColor("#E8D46D"));
        watchmedia.setBackgroundColor(Color.parseColor("#E8D46D"));

        startstop_timer.setImageResource(R.drawable.starttimer);

        START_TIMER_IN_MILLISEC =  1800000;
        monitor_Countdown = START_TIMER_IN_MILLISEC;

        updateTimer();
        cleanup.setEnabled(false);
    }

}
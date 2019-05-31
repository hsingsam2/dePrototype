package com.example.deprototype;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Activity2 extends AppCompatActivity {
    private TextView countdownText;
    private Button countdownButton;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 14460000;
    private boolean timerRunning;

    private TextView nextHour1;
    private TextView nextHour2;
    private TextView nextHour3;

    private int increment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        countdownText = findViewById(R.id.countdownText);
        countdownButton = findViewById(R.id.countdownButton);

        if(getIntent().hasExtra("one")) {
            timeLeftInMilliseconds = 3600000;
            increment = 1;
            countdownText.setText("1:00:00");
        }
        if(getIntent().hasExtra("two")) {
            timeLeftInMilliseconds = 3600000*2;
            increment = 2;
            countdownText.setText("2:00:00");
        }
        if(getIntent().hasExtra("three")) {
            timeLeftInMilliseconds = 3600000*3;
            increment = 3;
            countdownText.setText("3:00:00");
        }
        if(getIntent().hasExtra("four")) {
            timeLeftInMilliseconds = 3600000*4;
            increment = 4;
            countdownText.setText("4:00:00");
        }
        if(getIntent().hasExtra("five")) {
            timeLeftInMilliseconds = 3600000*5;
            increment = 5;
            countdownText.setText("5:00:00");
        }
        if(getIntent().hasExtra("six")) {
            timeLeftInMilliseconds = 3600000*6;
            increment = 6;
            countdownText.setText("6:00:00");
        }


        nextHour1 = findViewById(R.id.nextHour1);
        nextHour2 = findViewById(R.id.nextHour2);
        nextHour3 = findViewById(R.id.nextHour3);

        Date date = new Date();
        String strDateFormat = "HH:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        final String formattedDate = dateFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, increment   );
        final String nexthr1 = calendar.getTime()+"";
        calendar.add(Calendar.HOUR, increment);
        final String nexthr2 = calendar.getTime()+"";
        calendar.add(Calendar.HOUR, increment);
        final String nexthr3 = calendar.getTime()+"";




        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
                nextHour1.setText(nexthr1);
                nextHour2.setText(nexthr2);
                nextHour3.setText(nexthr3);
            }
        });

    }

    public void startStop(){
        if(timerRunning){
            stopTimer();
        }
        else{
            startTimer();
        }
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        countdownButton.setText("PAUSE");
        timerRunning = true;
    }

    public void stopTimer(){
        countDownTimer.cancel();
        countdownButton.setText("START");
        timerRunning = false;
    }

    public void updateTimer(){
        int hours = (int) timeLeftInMilliseconds/3600000;
        int minutes = (int) timeLeftInMilliseconds/60000;
        minutes = minutes % 60;
        int seconds = (int) timeLeftInMilliseconds % 60000 /1000;
        String timeLeftText;
        timeLeftText = ""+hours;
        timeLeftText += ":";
        if(minutes == 0) timeLeftText += ""+ "00";
        else timeLeftText += ""+minutes;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;
        countdownText.setText(timeLeftText);
    }

}

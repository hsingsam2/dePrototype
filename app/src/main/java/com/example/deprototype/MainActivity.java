package com.example.deprototype;

import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String timeinterval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner myspinner = (Spinner) findViewById(R.id.spinner1);


       ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
               getResources().getStringArray(R.array.names));

       myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);

        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                // On selecting a spinner item
                String timeMed = parent.getItemAtPosition(pos).toString();

                }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        Spinner myspinner2 = (Spinner) findViewById(R.id.spinner);
        //myspinner2.setOnItemSelectedListener(this);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.names));

        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner2.setAdapter(myAdapter2);

        myspinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                // On selecting a spinner item
                timeinterval = parent.getItemAtPosition(pos).toString();


                }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });



        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextPage = new Intent(getApplicationContext(), Activity2.class);
                int parsedTime = Integer.parseInt(timeinterval);
                if(parsedTime == 1) nextPage.putExtra("one", "hehe");
                if(parsedTime == 2) nextPage.putExtra("two", "hehe");
                if(parsedTime == 3) nextPage.putExtra("three", "hehe");
                if(parsedTime == 4) nextPage.putExtra("four", "hehe");
                if(parsedTime == 5) nextPage.putExtra("five", "hehe");
                if(parsedTime == 6) nextPage.putExtra("six", "hehe");
                startActivity(nextPage);
            }
        });





       /* NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification")
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);*/


    }
}

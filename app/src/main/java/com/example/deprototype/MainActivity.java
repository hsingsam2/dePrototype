package com.example.deprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner myspinner = (Spinner) findViewById(R.id.spinner1);
//get the spinner from the xml.
        //Spinner dropdown = findViewById(R.id.spinner1);
//create a list of items for the spinner.
        //String[] items = new String[]{"1", "2", "3", "4", "5", "6"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
       ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
               getResources().getStringArray(R.array.names));

       myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);
//set the spinners adapter to the previously created one.
        //dropdown.setAdapter(adapter);

        Spinner myspinner2 = (Spinner) findViewById(R.id.spinner);
//get the spinner from the xml.
        //Spinner dropdown = findViewById(R.id.spinner1);
//create a list of items for the spinner.
        //String[] items = new String[]{"1", "2", "3", "4", "5", "6"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.names));

        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner2.setAdapter(myAdapter2);
//set the spinners adapter to the previously created one.
        //dropdown.setAdapter(adapter);
    }
}

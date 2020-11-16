package com.example.Asthma_Pal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button settings, journal, graph, meds;
    public static Activity MA;
    public static boolean active;
    DatabaseHelper db;

    @Override
    protected void onStart() {
        super.onStart();
        active = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        active = false;
    }

    private Button Logout, PersonalInformation, Journal, Chart, Medication, Settings;
    public static Activity RA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        journal = findViewById(R.id.btnViewJournal);
        graph = findViewById(R.id.btnViewChart);
        MA = this;
        db = new DatabaseHelper(this);

        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DailyEntryActivity.class);
                startActivity(intent);
            }
        });

        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChartActivity.class);
                startActivity(intent);
            }
        });

        //create variables for all of the buttons to use with onclick listeners
        RA = this;
        Logout = (Button)findViewById(R.id.btnLogOut);
        PersonalInformation = (Button)findViewById(R.id.btnViewInformation);
        Journal = (Button)findViewById(R.id.btnViewJournal);
        Chart = (Button)findViewById(R.id.btnViewChart);
        Medication = (Button)findViewById(R.id.btnViewMeds);
        Settings = (Button)findViewById(R.id.btnSettings);

        //on click listener for the logout button, for now it just sends user to log-in page
        //IMPLEMENT: logout of firebase eventually
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(logout);
            }
        });

        //on click listener for user to go to their personal information page
        PersonalInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personalInfo = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(personalInfo);
            }
        });

    }

}
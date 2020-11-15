package com.example.Asthma_Pal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InformationActivity extends AppCompatActivity {

    private String filename = "PersonalInformation";
    private TextView textView1, textView2, textView3;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        String firstName, lastName, Country;
        textView1 = findViewById(R.id.txtCountry);
        textView2 = findViewById(R.id.txtFirstName);
        textView3 = findViewById(R.id.txtLastName);
        

        try {
            FileInputStream fis = getApplicationContext().openFileInput(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(inputStreamReader)){
                String line = reader.readLine();
                textView2.setText(line);
                line = reader.readLine();
                textView3.setText(line);
                line = reader.readLine();
                textView1.setText(line);

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                //String contents = stringBuilder.toString();
                //textView.setText(contents);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
package com.example.Asthma_Pal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DailySymptomsActivity extends AppCompatActivity {

    private ChipGroup cough, wheeze, chest, sleep, exercise, meds;
    private Chip coughsel, wheezesel, chestsel, sleepsel, exercisesel, medssel;
    private Button submit, back;
    private String strcoughsel, strwheezesel, strchestsel, strsleepsel, strexercisesel, strmedssel, strDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("MMM dd h:mm aa");
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_symptoms);
        back = findViewById(R.id.btnBack);
        strcoughsel = "";
        strchestsel = "";
        strexercisesel = "";
        strmedssel = "";
        strsleepsel = "";
        strwheezesel = "";

        cough = findViewById(R.id.chgCoughAnswer);
        wheeze = findViewById(R.id.chgWheezeAnswer);
        chest = findViewById(R.id.chgSleepAnswer);
        sleep = findViewById(R.id.chgTightChestAnswer);
        exercise = findViewById(R.id.chgStopExcerAnswer);
        meds = findViewById(R.id.chgRescueMed);
        submit = findViewById(R.id.btnSubmit);
        db = new DatabaseHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coughsel = findViewById(cough.getCheckedChipId());
                strcoughsel = coughsel.getText().toString();
                wheezesel = findViewById(wheeze.getCheckedChipId());
                strwheezesel = wheezesel.getText().toString();
                chestsel = findViewById(chest.getCheckedChipId());
                strchestsel = chestsel.getText().toString();
                sleepsel = findViewById(sleep.getCheckedChipId());
                strsleepsel = sleepsel.getText().toString();
                exercisesel = findViewById(exercise.getCheckedChipId());
                strexercisesel = exercisesel.getText().toString();
                medssel = findViewById(meds.getCheckedChipId());
                strmedssel = medssel.getText().toString();

                if(strcoughsel.length() == 0 || strwheezesel.length() == 0  || strchestsel.length() == 0  || strsleepsel.length() == 0  || strexercisesel.length() == 0  || strmedssel.length() == 0 ){
                    Toast.makeText(DailySymptomsActivity.this, "Please make sure all fields are\nfilled before continuing ", Toast.LENGTH_SHORT).show();
                }
                else{
                    strDate = sdf.format(new Date().getTime());
                    addData(strDate, strcoughsel, strwheezesel, strchestsel, strsleepsel, strexercisesel, strmedssel);
                    Intent intent = new Intent(DailySymptomsActivity.this, JournalHistoryActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addData(sdf.format(new Date().getTime()),strcoughsel, strwheezesel, strchestsel, strsleepsel, strexercisesel, strmedssel);
                Intent intent = new Intent(DailySymptomsActivity.this, DailyEntryActivity.class);
                DailyEntryActivity.DA.finish();
                startActivity(intent);
                finish();
            }
        });
    }

    public void addData(String date, String cough, String wheeze, String chest, String sleep, String exercise, String meds){
        db.insertData(date , cough, wheeze, chest, sleep, exercise, meds);
    }
}
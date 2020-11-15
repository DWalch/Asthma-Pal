package com.example.Asthma_Pal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChartActivity extends AppCompatActivity {

    private GraphView graphview;
    private LineGraphSeries<DataPoint> series;
    private SimpleDateFormat sdf = new SimpleDateFormat("MMM dd  \n aa");
    private double[][] graphValues;
    private Button update, back;
    private EditText Yvalue;
    private int clickNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        graphview = (GraphView) findViewById(R.id.graph);
        update = findViewById(R.id.btnAddtoGraph);
        Yvalue = findViewById(R.id.etYvalue);
        graphValues = new double[1][2];
        activateScroll();
        clickNumber = 0;
        back = findViewById(R.id.btnBackToMenu);

        graphview.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter()
        {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX){
                    return sdf.format(new Date((long) value));
                }
                else{
                return super.formatLabel(value, isValueX);
            }
        }
        });

        graphview.getGridLabelRenderer().setNumHorizontalLabels(3);





        init();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(MainActivity.active){
                    Intent intent = new Intent(ChartActivity.this, MainActivity.class);
                    MainActivity.MA.finish();
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(ChartActivity.this, MainActivity.class);
                    DailyEntryActivity.DA.finish();
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void init(){
        series = new LineGraphSeries<>();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Yvalue.getText().toString().equals("")){
                    double y = Double.parseDouble(Yvalue.getText().toString());
                    clickNumber++;


                    double[][] temp = new double[graphValues.length+1][2];
                    for(int i = 0; i <= graphValues.length; i++){
                        if(i == graphValues.length){
                            temp[i][0] = clickNumber;//new Date().getTime();
                            temp[i][1] = y;
                        }
                        else{
                            temp[i][0] = graphValues[i][0];
                            temp[i][1] = graphValues[i][1];
                        }

                    }
                    graphValues = temp;


                    //for(int i = 0; i < graphValues.length; i++) {
                      //  double xval = graphValues[i][0];
                       // double yval = graphValues[i][1];
                        series.appendData(new DataPoint(new Date().getTime(), y), true, 1000);
                    //}

                    graphview.addSeries(series);
                }
                else
                    Toast.makeText(ChartActivity.this, "Please Enter a value", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void activateScroll() {
        // activate horizontal zooming and scrolling
        //graphview.getViewport().setScalable(true);
        // activate horizontal scrolling
        graphview.getViewport().setScrollable(true);
        // activate horizontal and vertical zooming and scrolling
        graphview.getViewport().setScalableY(true);
        // activate vertical scrolling
        graphview.getViewport().setScrollableY(true);
    }




}
package com.example.claud.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class Sim extends AppCompatActivity {

    private LineChart mLChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);

        mLChart = findViewById(R.id.Lchart1);

        setData(7);
    }
    public void verNoticias(View v){
        Intent intent = new Intent(this, Noticias.class);
        startActivity(intent);
    }

    private void setData(int count){
        ArrayList<Entry> yVals1 = new ArrayList<>();
        float bitcoin = (float)(Math.random()*(5000-(10001))+10000);
        yVals1.add(new Entry(0, bitcoin));
        for (int i=1; i<=count; i++){
            if(i == 1 || i == 5){
                bitcoin = (float) (bitcoin + (bitcoin * 0.5)); //dar valores al "Y"
                yVals1.add(new Entry(i, bitcoin));             //agregar valores x = x+1; y = math.random*range
            }else if(i == 2 || i == 6){
                bitcoin = (float) (bitcoin - (bitcoin * 0.31416));
                yVals1.add(new Entry(i, bitcoin));
            } else if (i == 3 || i == 7) {
                bitcoin = (float) (bitcoin + (bitcoin * 0.18));
                yVals1.add(new Entry(i, bitcoin));
            } else if (i == 4){
                bitcoin = (float) (bitcoin - (bitcoin * 0.25));
                yVals1.add(new Entry(i, bitcoin));
            }
        }



        LineDataSet set1;

        set1 = new LineDataSet(yVals1, "Bitcoin");
        set1.setColor(Color.RED);
        set1.setDrawCircles(true);
        set1.setLineWidth(7f);



        LineData data = new LineData(set1);

        mLChart.setData(data);
    }
}

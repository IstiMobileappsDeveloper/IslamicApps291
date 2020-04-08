package com.example.islamicapps.quran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.islamicapps.R;

public class SuraDetailsActivity extends AppCompatActivity implements View.OnTouchListener {


    TextView suraNameTv;
    TextView suraDetailsTv;


    final static float move=200;
    float ratio=1.0f;
    int baseDist;
    float baseRatio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_details);
        suraNameTv = findViewById(R.id.suraNameId_DetailsActivity);
        suraDetailsTv = findViewById(R.id.suraDetails_DetailsActivity);
        suraDetailsTv.setTextSize(ratio+15);


        //Receiving Data

        Intent intent = this.getIntent();
        String suraName = intent.getExtras().getString("SURA_NAME_KEY");
        String suraDetails = intent.getExtras().getString("SURA_DETAILS_KEY");

        //Data Binding

        suraNameTv.setText(suraName);
        suraDetailsTv.setText(suraDetails);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount()==2){
            int action = event.getAction();
            int mainaction=action&MotionEvent.ACTION_MASK;
            if (mainaction==MotionEvent.ACTION_POINTER_DOWN){
                baseDist=getDistance(event);
                baseRatio=ratio;
            }else {
                float scale = (getDistance(event)-baseDist)/move;
                float factor = (float) Math.pow(2,scale);
                ratio=Math.min(1024.0f,Math.max(0.1f,baseRatio*factor));
                suraDetailsTv.setTextSize(ratio+25);

            }
        }
        return  true;
    }

    private int getDistance(MotionEvent event) {
        int dx = (int) (event.getX(0)-event.getX(1));
        int dy = (int) (event.getY(0)-event.getY(1));
        return (int) (Math.sqrt(dx*dx+dy*dy));
    }
}

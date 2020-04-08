package com.example.islamicapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.islamicapps.prayertimes.PrayerTimesActivity;
import com.example.islamicapps.quran.QuranActivity;

public class MainActivity extends AppCompatActivity {

    CardView quran;
    CardView prayer;
    CardView doya;
    CardView kibla;
    CardView readQuran;

    CardView tasbeeh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quran=findViewById(R.id.quranId);
        prayer=findViewById(R.id.prayerId);
        doya=findViewById(R.id.doyaId);
        kibla=findViewById(R.id.kiblaId);
        readQuran=findViewById(R.id.readQuranId);

        tasbeeh=findViewById(R.id.tasbeehId);



        quran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QuranActivity.class));

            }
        });


        prayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PrayerTimesActivity.class));

            }
        });

        doya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Doya_Dorud_Activity.class));

            }
        });

        kibla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,KiblaActivity.class));

            }
        });

        readQuran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ReadQuranActivity.class));

            }
        });


        tasbeeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TasbeehActivity.class));

            }
        });




    }
}

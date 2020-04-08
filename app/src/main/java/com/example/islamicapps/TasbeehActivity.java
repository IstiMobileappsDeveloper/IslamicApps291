package com.example.islamicapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TasbeehActivity extends AppCompatActivity {
    public int increment = 0 ;
    Button count;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbeeh);
        count=findViewById(R.id.countId);
        reset=findViewById(R.id.resetId);
        Toast.makeText(TasbeehActivity.this, "Click Tasbeeh", Toast.LENGTH_LONG).show();

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                increment++;

                count.setText(Integer.toString(increment));

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment=0;
                count.setText(Integer.toString(increment));
            }
        });
    }
}

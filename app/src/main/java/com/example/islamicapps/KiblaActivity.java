package com.example.islamicapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class KiblaActivity extends AppCompatActivity implements SensorEventListener {
    ImageView compass;
    private static SensorManager sensorManager;
    private static Sensor sensor;
    private float currentDegree;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kibla);

        compass=findViewById(R.id.compassId);
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        if (sensor!=null)
        {
            sensorManager.registerListener(this,sensor, sensorManager.SENSOR_DELAY_FASTEST);

        }
        else
        {
            Toast.makeText(getApplicationContext(),"not supported",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        int degree = Math.round(event.values[0]);
        RotateAnimation animation = new RotateAnimation(currentDegree,-degree, Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(500);
        animation.setFillAfter(true);
        compass.setAnimation(animation);
        currentDegree=-degree;


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

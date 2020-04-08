package com.example.islamicapps.prayertimes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.islamicapps.R;

import org.json.JSONException;
import org.json.JSONObject;

public class PrayerTimesActivity extends AppCompatActivity {

    String url ;

    // Tag used to cancel the request
    String tag_json_obj = "json_obj_req";

    ProgressDialog pDialog;
    private static final String TAG = "tag";

    TextView mFajrTv,mDudhrTv,mAsrTv,mMagribTv,mEshaTv,mDateTv,mLocationTv;
    EditText mSearchEt;
    Button mSearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_times);

        mFajrTv=findViewById(R.id.fajrId);
        mDudhrTv=findViewById(R.id.dhuhorId);
        mAsrTv=findViewById(R.id.asrId);
        mMagribTv=findViewById(R.id.magribId);
        mEshaTv=findViewById(R.id.eshaId);
        mDateTv=findViewById(R.id.dateTv);
        mLocationTv=findViewById(R.id.locationTv);
        mSearchEt=findViewById(R.id.searchEt);
        mSearchBtn=findViewById(R.id.searchBtn);


        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mLocation = mSearchEt.getText().toString().trim();
                if (mLocation.isEmpty()){
                    Toast.makeText(PrayerTimesActivity.this, "please enter your location", Toast.LENGTH_SHORT).show();
                }
                else{
                   url = "https://muslimsalat.com/"+mLocation+".json?key=f0867740d0fc1e591a9ebb76f5060e0f";
                    searchLocation();
                }
            }
        });





    }

    private void searchLocation() {


        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            String country = response.get("country").toString();
                            String state = response.get("state").toString();
                            String city = response.get("city").toString();
                            String location = country +"," +state+"," + city;

                            String date=response.getJSONArray("items").getJSONObject(0).get("date_for").toString();

                            String mFajr=response.getJSONArray("items").getJSONObject(0).get("fajr").toString();
                            String mDudhr=response.getJSONArray("items").getJSONObject(0).get("dhuhr").toString();
                            String mAsr=response.getJSONArray("items").getJSONObject(0).get("asr").toString();
                            String mMagrib=response.getJSONArray("items").getJSONObject(0).get("maghrib").toString();
                            String mEsha=response.getJSONArray("items").getJSONObject(0).get("isha").toString();

                            mFajrTv.setText(mFajr);
                            mDudhrTv.setText(mDudhr);
                            mAsrTv.setText(mAsr);
                            mMagribTv.setText(mMagrib);
                            mEshaTv.setText(mEsha);
                            mLocationTv.setText(location);
                            mDateTv.setText(date);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(PrayerTimesActivity.this,"Error",Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                pDialog.hide();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);


    }
}

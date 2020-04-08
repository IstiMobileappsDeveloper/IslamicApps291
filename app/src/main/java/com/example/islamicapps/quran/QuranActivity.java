package com.example.islamicapps.quran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.islamicapps.R;
import com.example.islamicapps.sura.SuraCollection;

import java.util.ArrayList;
import java.util.Arrays;

public class QuranActivity extends AppCompatActivity {

   // ArrayList<String> suraId=new ArrayList<>(Arrays.asList("1) সূরা আল ফাতিহা - Surah Al-Fatihah (মক্কায় অবতীর্ণ - Ayah 7)", "2)  সূরা ইয়াসীন - Surah Ya-Sin (মক্কায় অবতীর্ণ - Ayah 83)" , "3) সূরা আল হাশর - Surah Al-Hashr (মদীনায় অবতীর্ণ - Ayah 24))",
          //  "4)সূরা কদর - Surah Al-Qadr (মক্কায় অবতীর্ণ - Ayah 5)" , "5) সূরা কোরাইশ - Surah Quraish (মক্কায় অবতীর্ণ - Ayah 4)" , "6)  সূরা নাস - Surah Al-Nas (মদীনায় অবত  ীর্ণ - Ayah 6)",
           // "7) সূরা লাহাব - Surah Al-Lahab (মক্কায় অবতীর্ণ - Ayah 5)", "8) সূরা এখলাছ - Surah Al-Ikhlas (মক্কায় অবতীর্ণ - Ayah 4)", "9) সূরা ফালাক্ব - Surah Al-Falaq (মদীনায় অবতীর্ণ - Ayah 5)",
          //  "সূরা হুমাযাহ - Surah Al-Humaza (মক্কায় অবতীর্ণ - Ayah 9)"));

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);


        RecyclerView recyclerView =findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.context=context;

        QuranAdapter quranAdapter = new QuranAdapter(this, SuraCollection.getAllSura());
        recyclerView.setAdapter(quranAdapter);





    }




}

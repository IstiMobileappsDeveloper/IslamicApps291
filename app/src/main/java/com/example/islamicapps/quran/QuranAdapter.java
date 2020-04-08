package com.example.islamicapps.quran;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamicapps.sura.CustomItemClickListener;
import com.example.islamicapps.R;
import com.example.islamicapps.sura.Sura;

import java.util.List;

public class QuranAdapter extends RecyclerView.Adapter<QuranViewHolder> {
    Context context;
    List<Sura> listOfSura;

    public QuranAdapter(Context context, List<Sura> listOfSura) {
        this.context = context;
        this.listOfSura = listOfSura;
    }

    @NonNull
    @Override
    public QuranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.quran_raw_layout, parent, false);
        QuranViewHolder quranViewHolder = new QuranViewHolder(view);
        return quranViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuranViewHolder holder, int position) {
        final String suraName = listOfSura.get(position).getSuraName();
        final String suraDetails = listOfSura.get(position).getSuraDetails();

        holder.suraNameText.setText(suraName);

        holder.setCustomItemClickListener(new CustomItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openSuraDetailsActivity(suraName, suraDetails);
            }
        });


    }



    @Override
    public int getItemCount() {
        return listOfSura.size();
    }

    private void openSuraDetailsActivity(String suraName, String suraDetails) {
        Intent intent = new Intent(context, SuraDetailsActivity.class);

        intent.putExtra("SURA_NAME_KEY", suraName);
        intent.putExtra("SURA_DETAILS_KEY", suraDetails);
        context.startActivity(intent);
    }


    // ArrayList<String> suraId;



}

package com.example.islamicapps.quran;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamicapps.sura.CustomItemClickListener;
import com.example.islamicapps.R;

public class QuranViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView suraNameText;
    CustomItemClickListener customItemClickListener;
    
    public QuranViewHolder(@NonNull View itemView) {
        super(itemView);

        suraNameText=itemView.findViewById(R.id.suraId);
        
        itemView.setOnClickListener(this);
    }
    
    public void setCustomItemClickListener(CustomItemClickListener customItemClickListener){
        this.customItemClickListener = customItemClickListener;
    }

    @Override
    public void onClick(View v) {
        this.customItemClickListener.onItemClick(this.getLayoutPosition());
    }
}

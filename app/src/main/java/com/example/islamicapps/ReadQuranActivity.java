package com.example.islamicapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ReadQuranActivity extends AppCompatActivity {
    PDFView pdfReadQuran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_quran);

        pdfReadQuran=findViewById(R.id.read_quran_pdf_Book);

        pdfReadQuran.fromAsset("book1.pdf").load();
    }
}

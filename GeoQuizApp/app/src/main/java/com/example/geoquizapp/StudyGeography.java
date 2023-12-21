package com.example.geoquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class StudyGeography extends AppCompatActivity {

    private TextView titleTextView;
    private TextView infoTextView;
    private ImageView imageViewGeography;
    private Button nextButton;

    private String[] titles;
    private String[] infoTexts;
    private int currentIndex = 0;

    private int[] geographyImages = {
            R.drawable.foto,
            R.drawable.foto2,
            R.drawable.foto3,
            R.drawable.foto4,
            R.drawable.foto5,
            R.drawable.foto6,
            R.drawable.foto7,
            R.drawable.foto8,
            R.drawable.foto9,
            R.drawable.foto10,
            R.drawable.foto11,
            R.drawable.foto12,
            R.drawable.foto13,
            R.drawable.foto14,
            R.drawable.foto15,
            R.drawable.foto16,
            R.drawable.foto17,
            R.drawable.foto18,
            R.drawable.foto19,
            R.drawable.foto20,
            R.drawable.foto21,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_geography);

        titleTextView = findViewById(R.id.titleTextView);
        infoTextView = findViewById(R.id.infoTextView);
        imageViewGeography = findViewById(R.id.imageViewGeography);
        nextButton = findViewById(R.id.nextButton);


        titles = getResources().getStringArray(R.array.study_geography_titles);
        infoTexts = getResources().getStringArray(R.array.study_geography_info_texts);

        updateContent();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % titles.length;
                updateContent();
            }
        });
    }

    private void updateContent() {
        titleTextView.setText(titles[currentIndex]);
        infoTextView.setText(infoTexts[currentIndex]);
        imageViewGeography.setImageResource(geographyImages[currentIndex]);

    }
}




     
        





package com.fatbit.ieltsexamprep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReadingMainPage extends AppCompatActivity {

    Button multipleChoice,matchHeading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_main_page);

        multipleChoice = findViewById(R.id.mc);
        matchHeading = findViewById(R.id.mh);
        multipleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadingMainPage.this, ReadingMCQTopics.class));
            }
        });

        matchHeading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadingMainPage.this, ReadingMatchHeadingsTopics.class));

            }
        });
    }
}
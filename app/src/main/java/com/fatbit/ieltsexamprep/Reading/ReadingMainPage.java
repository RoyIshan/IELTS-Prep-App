package com.fatbit.ieltsexamprep.Reading;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fatbit.ieltsexamprep.R;

public class ReadingMainPage extends AppCompatActivity {

    Button multipleChoice,matchHeading,trueFalseNotGiven,summaryCompletion,sentanceCompletion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_main_page);

        multipleChoice = findViewById(R.id.mc);
        matchHeading = findViewById(R.id.mh);
        trueFalseNotGiven =findViewById(R.id.tfng);
        summaryCompletion = findViewById(R.id.smt);
        sentanceCompletion =findViewById(R.id.stc);
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
        sentanceCompletion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadingMainPage.this,ReadingSentanceCompletion.class));
            }
        });
        summaryCompletion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadingMainPage.this,ReadingSummaryCompletion.class));
            }
        });
        trueFalseNotGiven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadingMainPage.this, ReadingSummaryCompletion.class));

            }
        });

    }
}
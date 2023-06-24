package com.fatbit.ieltsexamprep.Speaking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fatbit.ieltsexamprep.R;
import com.fatbit.ieltsexamprep.Speaking.SpeakingPart1Topics;

public class SpeakingMainPage extends AppCompatActivity {

    Button part1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speaking_main_page);

        part1 = findViewById(R.id.part1btn);

        part1.setOnClickListener(v -> startActivity(new Intent(SpeakingMainPage.this, SpeakingPart1Topics.class)));
    }

}

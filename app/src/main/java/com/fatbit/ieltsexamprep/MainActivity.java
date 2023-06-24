package com.fatbit.ieltsexamprep;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fatbit.ieltsexamprep.Speaking.SpeakingMainPage;

public class MainActivity extends AppCompatActivity {
    Button speaking,listening,reading,writing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speaking = findViewById(R.id.speaking);
        listening = findViewById(R.id.listening);
        reading = findViewById(R.id.reading);
        writing = findViewById(R.id.writing);

        reading.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,ReadingMainPage.class)));

        speaking.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SpeakingMainPage.class)));
    }
}
package com.fatbit.ieltsexamprep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ReadingMainPage.class));
            }
        });

        speaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ReadingMainPage.class));
            }
        });
    }
}
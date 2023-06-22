package com.fatbit.ieltsexamprep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ReadingPassagesMultipleChoice extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_passages_multiple_choice);

        listView = findViewById(R.id.listview);

        // Create an ArrayAdapter with sample data
        String[] data = {"Passage 1", "Passage 2", "Passage 3", "Passage 4", "Passage 5"};

        adapter = new ArrayAdapter<>(this, R.layout.listview_adapter, R.id.textView, data);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = adapter.getItem(position);
                Toast.makeText(ReadingPassagesMultipleChoice.this, selectedItem + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
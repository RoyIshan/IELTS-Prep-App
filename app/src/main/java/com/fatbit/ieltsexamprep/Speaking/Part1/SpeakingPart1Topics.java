package com.fatbit.ieltsexamprep.Speaking.Part1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fatbit.ieltsexamprep.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

public class SpeakingPart1Topics extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speaking_part1_activity);

        listView = findViewById(R.id.listview);

        db = FirebaseFirestore.getInstance();
        // Create an ArrayAdapter with sample data
        ArrayList<String> data = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, R.layout.listview_adapter, R.id.textView, data);

        db.collection("Reading Part1 Topics")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            data.add(document.getId());
                            listView.setAdapter(adapter);
                        }
                    } else {
                        Toast.makeText(SpeakingPart1Topics.this,"Error",Toast.LENGTH_SHORT).show();
                    }
                });
        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = adapter.getItem(position);
            Intent intent = new Intent(SpeakingPart1Topics.this, SpeakingPart1EachContent.class);
            intent.putExtra("paraNo",selectedItem);
            startActivity(intent);
            Toast.makeText(SpeakingPart1Topics.this, selectedItem + " clicked", Toast.LENGTH_SHORT).show();
        });
    }

}

package com.fatbit.ieltsexamprep.Speaking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fatbit.ieltsexamprep.R;
import com.fatbit.ieltsexamprep.ReadingMCQEachPara;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //data.add(document.getString("Name"));
                                data.add(document.getId());
                                listView.setAdapter(adapter);
                            }
                        } else {
                            Toast.makeText(SpeakingPart1Topics.this,"Ni chal ra",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = adapter.getItem(position);
                Intent intent = new Intent(SpeakingPart1Topics.this, ReadingMCQEachPara.class);
                intent.putExtra("paraNo",selectedItem);
                startActivity(intent);
                Toast.makeText(SpeakingPart1Topics.this, selectedItem + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

package com.fatbit.ieltsexamprep.Reading;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.fatbit.ieltsexamprep.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ReadingTrueFalseNotGiven extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_true_false_not_given);

        listView = findViewById(R.id.listview);

        db = FirebaseFirestore.getInstance();
        // Create an ArrayAdapter with sample data
        ArrayList<String> data = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, R.layout.listview_adapter, R.id.textView, data);

        db.collection("Passages True False Not Given")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                data.add(document.getString("Name"));
                                listView.setAdapter(adapter);
                            }
                        } else {
                            Toast.makeText(ReadingTrueFalseNotGiven.this,"Ni chal ra",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = adapter.getItem(position);
                Intent intent = new Intent(ReadingTrueFalseNotGiven.this, ReadingTrueFalseNotGivenEachPara.class);
                intent.putExtra("paraNo",selectedItem);
                startActivity(intent);
                Toast.makeText(ReadingTrueFalseNotGiven.this, selectedItem + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
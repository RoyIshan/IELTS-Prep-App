package com.fatbit.ieltsexamprep.Reading;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fatbit.ieltsexamprep.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ReadingSummaryCompletionEachPara extends AppCompatActivity {

    TextView passage,heading,ansView;
    FirebaseFirestore db;
    String paraNo;
    Button ans;
    boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_summary_completion_each_para);

        paraNo = getIntent().getStringExtra("paraNo");
        passage = findViewById(R.id.passage);
        heading = findViewById(R.id.heading);
        ansView = findViewById(R.id.ansView);
        ans = findViewById(R.id.ans);
        check = true;

        db = FirebaseFirestore.getInstance();
        db.collection("Passages Summary Completion")
                .whereEqualTo("Name",paraNo)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                passage.setText(document.getString("Passage").replace("\\n", "\n"));
                                heading.setText(document.getString("Question").replace("\\n", "\n"));
                            }
                        } else {

                        }
                    }
                });
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check == true)
                {
                    check = false;
                    ans.setText("Hide Answers");
                    db.collection("Passages Summary Completion")
                            .whereEqualTo("Name",paraNo)
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        for (QueryDocumentSnapshot document : task.getResult()) {
                                            ansView.setText(document.getString("Answer").replace("\\n", "\n"));
                                        }
                                    } else {

                                    }
                                }
                            });
                }
                else {
                    check = true;
                    ans.setText("Show Answers");
                    ansView.setText("");
                }
            }
        });
    }
}
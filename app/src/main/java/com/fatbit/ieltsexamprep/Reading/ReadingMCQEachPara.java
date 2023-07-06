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

public class ReadingMCQEachPara extends AppCompatActivity {

    TextView passage,q1,q2,q3,q4,q5,ansView;
    FirebaseFirestore db;
    String paraNo;
    Button ans;
    boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_passage_multiple_choice_each_para);

        paraNo = getIntent().getStringExtra("paraNo");
        passage = findViewById(R.id.passage);
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);
        ansView = findViewById(R.id.ansView);
        ans = findViewById(R.id.ans);
        check = true;

        db = FirebaseFirestore.getInstance();
        db.collection("Passages Multiple Choice")
                .whereEqualTo("Name",paraNo)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                passage.setText(document.getString("Passage").replace("\\n", "\n"));
                                q1.setText(document.getString("Q1").replace("\\n", "\n"));
                                q2.setText(document.getString("Q2").replace("\\n", "\n"));
                                q3.setText(document.getString("Q3").replace("\\n", "\n"));
                                q4.setText(document.getString("Q4").replace("\\n", "\n"));
                                q5.setText(document.getString("Q5").replace("\\n", "\n"));
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
                    db.collection("Passages Multiple Choice")
                            .whereEqualTo("Name",paraNo)
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        for (QueryDocumentSnapshot document : task.getResult()) {
                                            ansView.setText(document.getString("Answers").replace("\\n", "\n"));
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
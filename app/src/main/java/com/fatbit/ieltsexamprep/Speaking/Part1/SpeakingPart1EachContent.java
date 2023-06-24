package com.fatbit.ieltsexamprep.Speaking.Part1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fatbit.ieltsexamprep.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class SpeakingPart1EachContent extends AppCompatActivity {

    TextView q1,q2,q3,q4,q5,ans1View,ans2View,ans3View,ans4View,ans5View;
    FirebaseFirestore db;
    String paraNo;
    Button ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speaking_part1_eachcontent);

        paraNo = getIntent().getStringExtra("paraNo");

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);
        ans1View = findViewById(R.id.ans1View);
        ans2View = findViewById(R.id.ans2View);
        ans3View = findViewById(R.id.ans3View);
        ans4View = findViewById(R.id.ans4View);
        ans5View = findViewById(R.id.ans5View);
        ans = findViewById(R.id.ans);

        db = FirebaseFirestore.getInstance();
        db.collection("Reading Part1 Topics")
                .whereEqualTo(FieldPath.documentId(),paraNo)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                q1.setText(document.getString("Q1"));
                                q2.setText(document.getString("Q2"));
                                q3.setText(document.getString("Q3"));
                                q4.setText(document.getString("Q4"));
                                q5.setText(document.getString("Q5"));

                            }
                        }
                    }
                });
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("Reading Part1 Topics")
                        .whereEqualTo(FieldPath.documentId(),paraNo)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        ans1View.setText(document.getString("Ans1"));
                                        ans2View.setText(document.getString("Ans2"));
                                        ans3View.setText(document.getString("Ans3"));
                                        ans4View.setText(document.getString("Ans4"));
                                        ans5View.setText(document.getString("Ans5"));
                                    }
                                }
                            }
                        });
            }
        });
    }

}

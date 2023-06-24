package com.fatbit.ieltsexamprep.Speaking.Part1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.fatbit.ieltsexamprep.R;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class SpeakingPart1EachContent extends AppCompatActivity {

    TextView q1,q2,q3,q4,q5,ans1View,ans2View,ans3View,ans4View,ans5View, textView2;
    FirebaseFirestore db;
    String paraNo;
    //Button ans;
    ToggleButton ToggleAnswer;
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
        textView2 = findViewById(R.id.textView2);
        //ans = findViewById(R.id.ans);
        ToggleAnswer = findViewById(R.id.toggleButton);
        ToggleAnswer.setChecked(false);

        ans1View.setVisibility(View.GONE);
        ans2View.setVisibility(View.GONE);
        ans3View.setVisibility(View.GONE);
        ans4View.setVisibility(View.GONE);
        ans5View.setVisibility(View.GONE);

        db = FirebaseFirestore.getInstance();
        db.collection("Reading Part1 Topics")
                .whereEqualTo(FieldPath.documentId(),paraNo)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            textView2.setText(document.getId());
                            q1.setText(document.getString("Q1"));
                            q2.setText(document.getString("Q2"));
                            q3.setText(document.getString("Q3"));
                            q4.setText(document.getString("Q4"));
                            q5.setText(document.getString("Q5"));

                        }
                    }
                });

        /*ans.setOnClickListener(v -> {

            ans1View.setVisibility(View.VISIBLE);
            ans2View.setVisibility(View.VISIBLE);
            ans3View.setVisibility(View.VISIBLE);
            ans4View.setVisibility(View.VISIBLE);
            ans5View.setVisibility(View.VISIBLE);

            db.collection("Reading Part1 Topics")
                    .whereEqualTo(FieldPath.documentId(),paraNo)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ans1View.setText(document.getString("Ans1"));
                                ans2View.setText(document.getString("Ans2"));
                                ans3View.setText(document.getString("Ans3"));
                                ans4View.setText(document.getString("Ans4"));
                                ans5View.setText(document.getString("Ans5"));
                            }
                        }
                    });
        });*/
    }

    public void onToggleClick(View view)
    {
        if (ToggleAnswer.isChecked()) {
            ans1View.setVisibility(View.VISIBLE);
            ans2View.setVisibility(View.VISIBLE);
            ans3View.setVisibility(View.VISIBLE);
            ans4View.setVisibility(View.VISIBLE);
            ans5View.setVisibility(View.VISIBLE);

            db.collection("Reading Part1 Topics")
                    .whereEqualTo(FieldPath.documentId(),paraNo)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ans1View.setText(document.getString("Ans1"));
                                ans2View.setText(document.getString("Ans2"));
                                ans3View.setText(document.getString("Ans3"));
                                ans4View.setText(document.getString("Ans4"));
                                ans5View.setText(document.getString("Ans5"));
                            }
                        }
                    });
        }
        else {

            ans1View.setVisibility(View.GONE);
            ans2View.setVisibility(View.GONE);
            ans3View.setVisibility(View.GONE);
            ans4View.setVisibility(View.GONE);
            ans5View.setVisibility(View.GONE);

        }
    }

}

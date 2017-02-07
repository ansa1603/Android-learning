package com.ansadavis.android.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
public static final String someName = "Answer";
    public static final String someCheat = "cheat";

    public void setSameIntent(boolean isScheated){
        Intent i = new Intent();
        i.putExtra(someCheat, isScheated);
        setResult(RESULT_OK, i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        final boolean someString = getIntent().getBooleanExtra(someName, false);
        final TextView answerView = (TextView) findViewById(R.id.answer_view);
        Button showAnswer  = (Button)findViewById(R.id.btn_show_answer);


        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(someString){
                    answerView.setText(R.string.btn_true);
                }else {
                    answerView.setText(R.string.btn_false);
                }
                setSameIntent(true);
            }

        });
    }
}

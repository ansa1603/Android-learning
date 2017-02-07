package com.ansadavis.android.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Question[] questions = new Question[]{
        new Question(R.string.q1,true),
        new Question(R.string.q2,true),
        new Question(R.string.q3,true),
        new Question(R.string.q4,true)
};
private int q = 0;
    private static final String TAG="Main Activity";

    TextView question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "inSide onCreate");
        setContentView(R.layout.activity_main);
if(savedInstanceState != null){
    q = savedInstanceState.getInt("Ansa");
}
        question = (TextView) findViewById(R.id.question_view);
        question.setText(questions[q].getQuestion());

        Button trueButton = (Button)findViewById(R.id.btn_true);
        Button falseButton = (Button)findViewById(R.id.btn_false);
        Button cheatButton = (Button) findViewById(R.id.btn_cheat);

        cheatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,CheatActivity.class);
                i.putExtra(CheatActivity.someName, questions[q].isAnswer());

                startActivityForResult(i, 0);
                //startActivity(i);
            }
        });

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                //
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                //Toast.makeText(MainActivity.this,R.string.false_msg,Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG, "onSaveInstanceState: ");
        savedInstanceState.putInt("Ansa", q);
    }
    @Override
    protected void onPause (){
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStart (){
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume (){
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onStop (){
        super.onStop();
        Log.d(TAG, "onStop: ");
    }
    @Override
    protected void onDestroy (){
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
    private void checkAnswer(boolean value){
        Log.d(TAG, "inSide checkAnswer");
        if(questions[q].isAnswer() == value){
            Toast.makeText(MainActivity.this,R.string.true_msg,Toast.LENGTH_LONG).show();
            nextQuestion();
        }else{
            Toast.makeText(MainActivity.this,R.string.false_msg,Toast.LENGTH_LONG).show();
            previousQuestion();
        }
    }
    private void nextQuestion(){
        q = (q+1) % questions.length;

        question.setText(questions[q].getQuestion());
    }
    private void previousQuestion(){
        q = q==0?q:(q-1);

        question.setText(questions[q].getQuestion());
    }

    @Override
    protected void onActivityResult(int reqCode,int resultCode, Intent data){
        if(data != null){
            Boolean dataFromCheatActivity = data.getBooleanExtra(CheatActivity.someCheat, false);

            if(dataFromCheatActivity){
                Toast.makeText(MainActivity.this,R.string.cheat_toast,Toast.LENGTH_LONG).show();
            }
        }else{
            return;
        }
    }
}

package com.ansadavis.android.firstapp;

/**
 * Created by ANSA DAVIS on 17-01-2017.
 */

public class Question {
int question;
    boolean answer;

    Question(int question, boolean answer){
        this.question = question;
        this.answer = answer;
    }

    public boolean isAnswer() {
        return answer;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

}

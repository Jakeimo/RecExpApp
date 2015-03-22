package com.example.jakespicer.recexpapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity{

    int currentAnswer = 0;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView changingText = (TextView) findViewById(R.id.textView2);
        text = changingText;

       setTitleText(changingText);
    }

    public void setTitleText(TextView text) {
       String result = getNewResult();
       text.setText(result);
       Log.d("setTitleText() = ", result);
    }

    public int getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(int currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    public String getNewResult(){
        String stringResult = "Error";
        Random rnd = new Random();

        rnd.setSeed(System.currentTimeMillis());
        int result = rnd.nextInt(3);

        switch (result) {
            case 0:
                stringResult = "Apple";
                setCurrentAnswer(0);
                break;
            case 1:
                stringResult = "Banana";
                setCurrentAnswer(1);
                break;
            case 2:
                stringResult = "Carrot";
                setCurrentAnswer(2);
                break;
        }

        return stringResult;
    }

    public void onClick(View view){

        int id = view.getId();
        int result = Integer.parseInt(getResources().getResourceEntryName(id).substring(5));

        if (result == getCurrentAnswer()){
            Animation expand = AnimationUtils.loadAnimation(this, R.anim.correct_expand);
            view.startAnimation(expand);
            Toast.makeText(this, "Correct! Well done.",
                    Toast.LENGTH_SHORT).show();
            setTitleText(text);
        } else {
            Animation shake = AnimationUtils.loadAnimation(this, R.anim.incorrect_shake);
            view.startAnimation(shake);
            Toast.makeText(this, "Incorrect. Bad luck.",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
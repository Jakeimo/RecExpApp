package com.example.jakespicer.recexpapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    int currentAnswer = 0;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView changingText = (TextView) findViewById(R.id.textView2);
        text = changingText;

        TextView correctText = (TextView) findViewById(R.id.textView3);
        correctText.setText("0");


        changeText(changingText);
    }

    public void incrementCorrect(){
        TextView correctText = (TextView) findViewById(R.id.textView3);
        int current = Integer.parseInt(correctText.getText().toString());
        current++;
        correctText.setText(Integer.toString(current));
    }

    public void changeText(TextView text) {
        Random rnd = new Random();

        rnd.setSeed(System.currentTimeMillis());
        int result = rnd.nextInt(3);

        currentAnswer = result;

        switch (result) {
            case 0:
                text.setText("Apple");
                break;
            case 1:
                text.setText("Banana");
                break;
            case 2:
                text.setText("Carrot");
                break;
        }
    }
    public void onClick(View view){

        int id = view.getId();
        int result = Integer.parseInt(getResources().getResourceEntryName(id).substring(5));

        if (result == currentAnswer){
            Toast.makeText(this, "Correct! Well done.",
                    Toast.LENGTH_SHORT).show();
            changeText(text);
            incrementCorrect();
        } else {
            Toast.makeText(this, "Incorrect. Bad luck.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
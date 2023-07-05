package com.example.fibonaccisequence;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String fibSeries = " ";
    int fib =0;
    Button btn;
    EditText et;
    TextView tvDisplay;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        et = findViewById(R.id.et);
        tvDisplay = findViewById(R.id.tvResult);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fib = Integer.parseInt(et.getText().toString());
                fibHandler(fib);
                fibSeries = " ";
            }
        });

    }

    public void fibHandler(int fib){
        int firstTerm = 0, secondTerm = 1, nextTerm;
        fibSeries = fibSeries + String.valueOf(firstTerm) + ", " + String.valueOf(secondTerm);

        for (int i = 0; i < fib - 2; i++){
            nextTerm = firstTerm + secondTerm;
            fibSeries = fibSeries + ", "+ String.valueOf(nextTerm);
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        tvDisplay.setText(fibSeries);
    }

}
package com.example.blackjacksegev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int bet,totalmoeny;
    private Button btn1, btn10, btn50, btn200,btnstartGame;
    private TextView betview, moneyview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        betview = findViewById(R.id.betview);
        btn1 = findViewById(R.id.btn1);
        btn10 = findViewById(R.id.btn10);
        btn50 = findViewById(R.id.btn50);
        btn200 = findViewById(R.id.btn200);
        moneyview = findViewById(R.id.moneyview);

        btnstartGame = findViewById(R.id.btnstart);
        btn1.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn50.setOnClickListener(this);
        btn200.setOnClickListener(this);
        btnstartGame.setOnClickListener(this);
        bet = 0;
        totalmoeny = 1000;
        moneyview.setText("You have:" + totalmoeny);

    }

    @Override
    public void onClick(View v) {
        if(v == btnstartGame)
        {
            if(bet > 0)
            {
                Intent intent = new Intent(this, GameActivity.class);
                intent.putExtra("bet",bet);
                startActivity(intent);
            }
        }
        if(v == btn1)
        {
            if(1 <= totalmoeny)
            {
                bet = bet+1;
                totalmoeny = totalmoeny-1;
            }
        }
        if(v == btn10)
        {
            if(10 <= totalmoeny)
            {
                bet = bet+10;
                totalmoeny = totalmoeny-10;
            }
        }
        if(v == btn50)
        {
            if(50 <= totalmoeny)
            {
                bet = bet+50;
                totalmoeny = totalmoeny-50;
            }
        }
        if(v == btn200)
        {
            if(200 <= totalmoeny)
            {
                bet = bet+200;
                totalmoeny = totalmoeny-200;
            }
        }
        refresh();
    }

    private void refresh() {
        String string = "Your current bet is: " + bet;
        String string1 = "You have: " + totalmoeny;
        betview.setText(string);
        moneyview.setText(string1);
    }
}